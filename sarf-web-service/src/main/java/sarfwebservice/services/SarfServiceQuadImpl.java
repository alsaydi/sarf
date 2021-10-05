package sarfwebservice.services;
/*
 *
 * MIT License
 *
 * Copyright (c) 2021 Abdalaziz Alsaydi
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sarf.*;
import sarf.kov.KovRulesManager;
import sarf.verb.quadriliteral.augmented.AugmentedQuadrilateralRoot;
import sarf.verb.quadriliteral.augmented.active.past.QuadrilateralAugmentedActivePastConjugator;
import sarf.verb.quadriliteral.augmented.active.present.AugmentedQuadActivePresentConjugator;
import sarf.verb.quadriliteral.modifier.QuadrilateralModifier;
import sarf.verb.quadriliteral.unaugmented.UnaugmentedQuadrilateralRoot;
import sarf.verb.quadriliteral.unaugmented.active.QuadActivePresentConjugator;
import sarf.verb.quadriliteral.unaugmented.active.QuadriActivePastConjugator;
import sarfwebservice.models.ConjugationResultDisplay;
import sarfwebservice.models.RootResult;
import sarfwebservice.models.TriRootDisplay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class SarfServiceQuadImpl extends SarfServiceImpl implements SarfServiceQuad {

    private final SarfDictionary sarfDictionary;
    private final KovRulesManager kovRulesManager;
    private final QuadrilateralAugmentedActivePastConjugator quadrilateralAugmentedActivePastConjugator;
    private final QuadrilateralModifier quadrilateralModifier;
    private final QuadriActivePastConjugator quadriActivePastConjugator;
    private final QuadActivePresentConjugator quadActivePresentConjugator;
    private final AugmentedQuadActivePresentConjugator augmentedQuadActivePresentConjugator;

    @Autowired
    public SarfServiceQuadImpl(Validator sarfValidator, SarfDictionary sarfDictionary, KovRulesManager kovRulesManager, QuadrilateralAugmentedActivePastConjugator quadrilateralAugmentedActivePastConjugator, QuadrilateralModifier quadrilateralModifier, QuadriActivePastConjugator quadriActivePastConjugator, QuadActivePresentConjugator quadActivePresentConjugator, AugmentedQuadActivePresentConjugator augmentedQuadActivePresentConjugator) {
        super(sarfValidator);
        this.sarfDictionary = sarfDictionary;
        this.kovRulesManager = kovRulesManager;
        this.quadrilateralAugmentedActivePastConjugator = quadrilateralAugmentedActivePastConjugator;
        this.quadrilateralModifier = quadrilateralModifier;
        this.quadriActivePastConjugator = quadriActivePastConjugator;
        this.quadActivePresentConjugator = quadActivePresentConjugator;
        this.augmentedQuadActivePresentConjugator = augmentedQuadActivePresentConjugator;
    }

    @Override
    public List<RootResult> getRoots(String rootLetters) throws Exception {
        try {
            return processQuadrilateral(rootLetters);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String conjugateRoot(UnaugmentedQuadrilateralRoot root, KindOfVerb kov) {
        if (root == null) {
            return "";
        }
        //مع الضمير هو
        //past text formatting
        String pastRootText = quadriActivePastConjugator.createVerb(7, root).toString();
        var conjugations = createEmptyList();
        conjugations.set(7, Word.fromString(pastRootText));
        ConjugationResult conjResult = quadrilateralModifier.build(root, 0, kov, conjugations, SystemConstants.PAST_TENSE, true);
        pastRootText = conjResult.getFinalResult().get(7).toString();

        //past text formatting
        String presentRootText = quadActivePresentConjugator.createNominativeVerb(7, root).toString();
        conjugations = createEmptyList();
        conjugations.set(7, Word.fromString(presentRootText));
        conjResult = quadrilateralModifier.build(root, 0, kov, conjugations, SystemConstants.PRESENT_TENSE, true);
        presentRootText = conjResult.getFinalResult().get(7).toString();

        return pastRootText + " " + presentRootText;
    }

    private String conjugateAugmentedRoot(int formulaNo, AugmentedQuadrilateralRoot root, KindOfVerb kov) {
        //مع الضمير هو
        //past text formatting
        String pastRootText = quadrilateralAugmentedActivePastConjugator.createVerb(root, 7, formulaNo).toString();
        List<Word> conjugations = createEmptyList();
        conjugations.set(7, Word.fromString(pastRootText));
        ConjugationResult conjResult = quadrilateralModifier.build(root, formulaNo, kov, conjugations, SystemConstants.PAST_TENSE, true);
        pastRootText = conjResult.getFinalResult().get(7).toString();

        //past text formatting
        String presentRootText = augmentedQuadActivePresentConjugator.getNominativeConjugator().createVerb(root, 7, formulaNo).toString();
        conjugations = createEmptyList();
        conjugations.set(7, Word.fromString(presentRootText));
        conjResult = quadrilateralModifier.build(root, formulaNo, kov, conjugations, SystemConstants.PRESENT_TENSE, true);
        presentRootText = conjResult.getFinalResult().get(7).toString();

        return pastRootText + " " + presentRootText;
    }

    private List<Word> createEmptyList() {
        return IntStream.rangeClosed(1, SystemConstants.PRONOUN_RANGE_END)
                .mapToObj(i -> Word.empty())
                .collect(Collectors.toCollection(() -> new ArrayList<>(SystemConstants.PRONOUN_RANGE_END)));
    }

    private List<RootResult> processQuadrilateral(String root) throws Exception {
        //فحص إذا كان الفعل يبتدأ بهمزة
        if (root.charAt(0) == 'ء') {
            //displayErrorMessage("لا يوجد رباعي يبتدئ بهمزة");
            return Arrays.asList();
        }

        List<String> alefAlternatives = getSarfValidator().getQuadrilateralAlefAlternatives(root);
        if (alefAlternatives.isEmpty()) {
            //لا يوجد احتمالات للألف
            AugmentedQuadrilateralRoot augmentedRoot = sarfDictionary.getAugmentedQuadrilateralRoot(root);
            UnaugmentedQuadrilateralRoot unaugmentedRoot = sarfDictionary.getUnaugmentedQuadrilateralRoot(root);
            if (augmentedRoot == null && unaugmentedRoot == null) {
                //displayErrorMessage("لم يرد هذا الجذر في قاعدة المعطيات      ");
                return Arrays.asList();
            }
            return Arrays.asList(findRootResult(root, unaugmentedRoot, augmentedRoot));
        }
        //تجريب بدائل الألف
        var resultList = new ArrayList<RootResult>();
        for (String alternativeRoot : alefAlternatives) {
            AugmentedQuadrilateralRoot augmentedRoot = sarfDictionary.getAugmentedQuadrilateralRoot(alternativeRoot);
            UnaugmentedQuadrilateralRoot unaugmentedRoot = sarfDictionary.getUnaugmentedQuadrilateralRoot(alternativeRoot);
            if (augmentedRoot != null || unaugmentedRoot != null) {
                resultList.add(findRootResult(alternativeRoot, unaugmentedRoot, augmentedRoot));
            }
        }
        return resultList;
    }

    private RootResult findRootResult(String rootLetters, UnaugmentedQuadrilateralRoot root, AugmentedQuadrilateralRoot augmentedQuadrilateralRoot) {
        var rootResult = new RootResult();
        var kovRule = kovRulesManager.getQuadrilateralKovRule(rootLetters.charAt(0), rootLetters.charAt(1), rootLetters.charAt(2), rootLetters.charAt(3));
        var kov = kovRule.getKov();
        var conjugationResultDisplays = new ArrayList<ConjugationResultDisplay>();
        var displays = new ArrayList<TriRootDisplay>();

        var display = new TriRootDisplay();
        display.setRoot(root);
        display.setDisplay(conjugateRoot(root, kov));
        displays.add(display);
        if(augmentedQuadrilateralRoot != null) {
            var augmentationFormulas = augmentedQuadrilateralRoot.getAugmentationList();
            for (var formula : augmentationFormulas) {
                var verbs = quadrilateralAugmentedActivePastConjugator.createVerbList(augmentedQuadrilateralRoot, formula.getFormulaNo());
                var conjugationResult = quadrilateralModifier.build(augmentedQuadrilateralRoot, formula.getFormulaNo(), kov, verbs, SystemConstants.PAST_TENSE
                        , true);

                var conjugationResultDisplay = new ConjugationResultDisplay();
                conjugationResultDisplay.setConjugationResult(conjugationResult);
                conjugationResultDisplay.setDisplay(conjugateAugmentedRoot(formula.getFormulaNo(), augmentedQuadrilateralRoot, kov));
                conjugationResultDisplay.setTransitivity(formula.getTransitive());
                conjugationResultDisplays.add(conjugationResultDisplay);
            }
        }
        rootResult.setRoot(rootLetters);
        rootResult.setKindOfVerb(kovRule.getDesc());
        rootResult.setUnaugmentedRoots(displays);
        rootResult.setConjugationResults(conjugationResultDisplays);
        return rootResult;
    }
}
