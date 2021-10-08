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
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;
import sarf.verb.trilateral.augmented.active.past.AugmentedActivePastConjugator;
import sarf.verb.trilateral.augmented.active.present.AugmentedActivePresentConjugator;
import sarf.verb.trilateral.augmented.modifier.AugmentedTrilateralModifier;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;
import sarf.verb.trilateral.unaugmented.active.ActivePastConjugator;
import sarf.verb.trilateral.unaugmented.active.ActivePresentConjugator;
import sarf.verb.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier;
import sarfwebservice.models.*;
import sarfwebservice.sarf.bridges.tri.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SarfServiceTriImpl extends SarfServiceImpl implements SarfServiceTri {

    private final SarfDictionary sarfDictionary;
    private final KovRulesManager kovRulesManager;
    private final AugmentedActivePastConjugator augmentedActivePastConjugator;
    private final AugmentedTrilateralModifier augmentedTrilateralModifier;
    private final ActivePastConjugator unaugmentedTriActivePastConjugator;
    private final UnaugmentedTrilateralModifier unaugmentedTrilateralModifier;
    private final ActivePresentConjugator activePresentConjugator;
    private final AugmentedActivePresentConjugator augmentedActivePresentConjugator;
    private final TrilateralUnaugmentedBridge trilateralUnaugmentedBridge;
    private final TrilateralAugmentedBridge trilateralAugmentedBridge;
    private final TrilateralUnaugmentedDerivedNounBridge trilateralUnaugmentedDerivedNounBridge;
    private final TrilateralAugmentedDerivedNounBridge trilateralAugmentedDerivedNounBridge;
    private final TrilateralUnaugmentedGerundBridge trilateralUnaugmentedGerundBridge;
    private final TrilateralAugmentedGerundBridge trilateralAugmentedGerundBridge;

    @Autowired
    public SarfServiceTriImpl(SarfDictionary sarfDictionary
            , Validator sarfValidator
            , KovRulesManager kovRulesManager
            , AugmentedActivePastConjugator augmentedActivePastConjugator
            , AugmentedTrilateralModifier augmentedTrilateralModifier
            , ActivePastConjugator unaugmentedTriActivePastConjugator
            , UnaugmentedTrilateralModifier unaugmentedTrilateralModifier
            , ActivePresentConjugator activePresentConjugator
            , AugmentedActivePresentConjugator augmentedActivePresentConjugator
            , TrilateralUnaugmentedBridge trilateralUnaugmentedBridge
            , TrilateralAugmentedBridge trilateralAugmentedBridge
            , TrilateralUnaugmentedDerivedNounBridge trilateralUnaugmentedDerivedNounBridge
            , TrilateralAugmentedDerivedNounBridge trilateralAugmentedDerivedNounBridge
            , TrilateralUnaugmentedGerundBridge trilateralUnaugmentedGerundBridge
            , TrilateralAugmentedGerundBridge trilateralAugmentedGerundBridge) {
        super(sarfValidator);
        this.sarfDictionary = sarfDictionary;
        this.kovRulesManager = kovRulesManager;
        this.augmentedActivePastConjugator = augmentedActivePastConjugator;
        this.augmentedTrilateralModifier = augmentedTrilateralModifier;
        this.unaugmentedTriActivePastConjugator = unaugmentedTriActivePastConjugator;
        this.unaugmentedTrilateralModifier = unaugmentedTrilateralModifier;
        this.activePresentConjugator = activePresentConjugator;
        this.augmentedActivePresentConjugator = augmentedActivePresentConjugator;
        this.trilateralUnaugmentedBridge = trilateralUnaugmentedBridge;
        this.trilateralAugmentedBridge = trilateralAugmentedBridge;
        this.trilateralUnaugmentedDerivedNounBridge = trilateralUnaugmentedDerivedNounBridge;
        this.trilateralAugmentedDerivedNounBridge = trilateralAugmentedDerivedNounBridge;
        this.trilateralUnaugmentedGerundBridge = trilateralUnaugmentedGerundBridge;
        this.trilateralAugmentedGerundBridge = trilateralAugmentedGerundBridge;
    }

    private static List<Word> createEmptyList() {
        List<Word> result = new ArrayList<>(13);
        for (int i = 1; i <= 13; i++) {
            result.add(Word.empty());
        }
        return result;
    }

    @Override
    public List<RootResult> getRoots(String rootLetters) {
        try {
            return processTrilateral(rootLetters);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public VerbConjugations getActiveVerbConjugationsTri(String rootLetters, boolean augmented, int cclass, int formula) throws Exception {
        return augmented ? getVerbConjugationsForAugmented(rootLetters, formula, true)
                : getVerbConjugationsForUnaugmented(rootLetters, cclass, true);
    }

    private VerbConjugations getVerbConjugationsForAugmented(String rootLetters, int formula, boolean active) throws Exception {
        var past = this.trilateralAugmentedBridge.retrievePastConjugations(rootLetters, formula, active).stream().map(wp -> wp.toString()).toList();
        var nominativePresent = this.trilateralAugmentedBridge.retrieveNominativePresent(rootLetters, formula, active).stream().map(wp -> wp.toString()).toList();
        var accusativePresent = this.trilateralAugmentedBridge.retrieveAccusativePresent(rootLetters, formula, active).stream().map(wp -> wp.toString()).toList();
        var jussivePresent = this.trilateralAugmentedBridge.retrieveJussivePresent(rootLetters, formula, active).stream().map(wp -> wp.toString()).toList();
        var emphasizedPresent = this.trilateralAugmentedBridge.retrieveEmphasizedPresent(rootLetters, formula, active).stream().map(wp -> wp.toString()).toList();
        var imperative = this.trilateralAugmentedBridge.retrieveImperative(rootLetters, formula).stream().map(wp -> wp.toString()).toList();
        var emphasizedImperative = this.trilateralAugmentedBridge.retrieveEmphasizedImperative(rootLetters, formula).stream().map(wp -> wp.toString()).toList();
        var verbConjugations = new VerbConjugations();
        verbConjugations.setPast(past);
        verbConjugations.setNominativePresent(nominativePresent);
        verbConjugations.setAccusativePresent(accusativePresent);
        verbConjugations.setJussivePresent(jussivePresent);
        verbConjugations.setEmphasizedPresent(emphasizedPresent);
        verbConjugations.setImperative(imperative);
        verbConjugations.setEmphasizedImperative(emphasizedImperative);
        return verbConjugations;
    }
    private VerbConjugations getVerbConjugationsForUnaugmented(String rootLetters, int cclass, boolean active) throws Exception {
        var kov = kovRulesManager.getTrilateralKov(rootLetters.charAt(0), rootLetters.charAt(1), rootLetters.charAt(2));
        var root = sarfDictionary.getUnaugmentedTrilateralRoots(rootLetters).stream()
                .filter(r -> r.getConjugation().getValue() == cclass)
                .findFirst().orElse(null);
        if (root == null) {
            throw new Exception(String.format("Could not find a root with letters %s and class of %d.", rootLetters, cclass));
        }

        var past = this.trilateralUnaugmentedBridge.retrieveActivePastConjugations(root, kov, active).stream().map(wp -> wp.toString()).toList();
        var nominativePresent = this.trilateralUnaugmentedBridge.retrieveActiveNominativePresent(root, kov, active).stream().map(wp -> wp.toString()).toList();
        var accusativePresent = this.trilateralUnaugmentedBridge.retrieveActiveAccusativePresent(root, kov, active).stream().map(wp -> wp.toString()).toList();
        var jussivePresent = this.trilateralUnaugmentedBridge.retrieveActiveJussivePresent(root, kov, active).stream().map(wp -> wp.toString()).toList();
        var emphasizedPresent = this.trilateralUnaugmentedBridge.retrieveActiveEmphasizedPresent(root, kov, active).stream().map(wp -> wp.toString()).toList();
        var imperative = Arrays.asList("");
        var emphasizedImperative = Arrays.asList("");
        if(active) {
            imperative = this.trilateralUnaugmentedBridge.retrieveImperative(root, kov).stream().map(wp -> wp.toString()).toList();
            emphasizedImperative = this.trilateralUnaugmentedBridge.retrieveEmphasizedImperative(root, kov).stream().map(wp -> wp.toString()).toList();
        }
        var verbConjugations = new VerbConjugations();
        verbConjugations.setPast(past);
        verbConjugations.setNominativePresent(nominativePresent);
        verbConjugations.setAccusativePresent(accusativePresent);
        verbConjugations.setJussivePresent(jussivePresent);
        verbConjugations.setEmphasizedPresent(emphasizedPresent);
        verbConjugations.setImperative(imperative);
        verbConjugations.setEmphasizedImperative(emphasizedImperative);
        return verbConjugations;
    }

    private String conjugateRoot(UnaugmentedTrilateralRoot root, KindOfVerb kov) {
        var pastRootText = unaugmentedTriActivePastConjugator.createVerb(7, root);
        List<Word> conjugations = createEmptyList();
        conjugations.set(7, pastRootText);
        var conjResult = unaugmentedTrilateralModifier.build(root, kov, conjugations, SystemConstants.PAST_TENSE, true);
        var finalPastVerbText = conjResult.getFinalResult().get(7).toString();

        //present text formatting
        var presentRootText = activePresentConjugator.createNominativeVerb(7, root);
        conjugations = createEmptyList();
        conjugations.set(7, presentRootText);
        conjResult = unaugmentedTrilateralModifier.build(root, kov, conjugations, SystemConstants.PRESENT_TENSE, true);
        var finalPresentVerbText = conjResult.getFinalResult().get(7).toString();

        return finalPastVerbText + " " + finalPresentVerbText;
    }

    private String conjugateAugmentedRoot(int formulaNo, AugmentedTrilateralRoot root, KindOfVerb kov) {
        //مع الضمير هو
        //past text formatting
        var pastRootText = augmentedActivePastConjugator.createVerb(root, 7, formulaNo);
        var conjugations = createEmptyList();
        conjugations.set(7, pastRootText);
        ConjugationResult conjResult = augmentedTrilateralModifier.build(root, kov, formulaNo, conjugations, SystemConstants.PAST_TENSE, true, null);
        var finalPastRootText = conjResult.getFinalResult().get(7).toString();

        //past text formatting
        var presentRootText = augmentedActivePresentConjugator.getNominativeConjugator().createVerbList(root, formulaNo).get(7);
        conjugations = createEmptyList();
        conjugations.set(7, presentRootText);
        conjResult = augmentedTrilateralModifier.build(root, kov, formulaNo, conjugations, SystemConstants.PRESENT_TENSE, true, null);
        var finalPresentRootText = conjResult.getFinalResult().get(7).toString();

        return finalPastRootText + " " + finalPresentRootText;
    }

    private List<RootResult> processTrilateral(String root) throws Exception {
        var alefAlternatives = getSarfValidator().getTrilateralAlefAlternatives(root);
        if (alefAlternatives.isEmpty()) {
            //لا يوجد احتمالات للألف
            AugmentedTrilateralRoot augmentedRoot = sarfDictionary.getAugmentedTrilateralRoot(root);
            List<UnaugmentedTrilateralRoot> unaugmentedList = sarfDictionary.getUnaugmentedTrilateralRoots(root);
            if (augmentedRoot == null && unaugmentedList.isEmpty()) {
                return Arrays.asList();
            } else {
                return Arrays.asList(findRootResult(root, unaugmentedList, augmentedRoot));
            }
        }
        //تجريب بدائل الألف
        var resultList = new ArrayList<RootResult>();
        for (String alternativeRoot : alefAlternatives) {
            var augmentedRoot = sarfDictionary.getAugmentedTrilateralRoot(alternativeRoot);
            var unaugmentedList = sarfDictionary.getUnaugmentedTrilateralRoots(alternativeRoot);

            if (augmentedRoot != null || !unaugmentedList.isEmpty()) {
                resultList.add(findRootResult(alternativeRoot, unaugmentedList, augmentedRoot));
            }
        }
        return resultList;
    }

    private RootResult findRootResult(String rootLetters
            , List<UnaugmentedTrilateralRoot> unaugmentedTrilateralRoots
            , AugmentedTrilateralRoot augmentedTrilateralRoot) throws Exception {
        var rootResult = new RootResult();
        var kovRule = kovRulesManager.getTrilateralKovRule(rootLetters.charAt(0), rootLetters.charAt(1), rootLetters.charAt(2));
        var kov = kovRule.getKov();
        var conjugationResultDisplays = new ArrayList<ConjugationResultDisplay>();
        var displays = new ArrayList<TriRootDisplay>();

        for (var root : unaugmentedTrilateralRoots) {
            var display = new TriRootDisplay();
            display.setRoot(root);
            display.setDisplay(conjugateRoot(root, kov));
            displays.add(display);
        }
        if (augmentedTrilateralRoot != null) {
            var augmentationFormulas = augmentedTrilateralRoot.getAugmentationList();
            for (var formula : augmentationFormulas) {
                var verbs = augmentedActivePastConjugator.createVerbList(augmentedTrilateralRoot, formula.getFormulaNo());
                var conjugationResult = augmentedTrilateralModifier.build(augmentedTrilateralRoot, kov, formula.getFormulaNo(), verbs, SystemConstants.PAST_TENSE
                        , true, () -> true);

                var conjugationResultDisplay = new ConjugationResultDisplay();
                conjugationResultDisplay.setConjugationResult(conjugationResult);
                conjugationResultDisplay.setDisplay(conjugateAugmentedRoot(formula.getFormulaNo(), augmentedTrilateralRoot, kov));
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

    @Override
    public VerbConjugations getPassiveVerbConjugationsTri(String rootLetters, boolean augmented, int cclass, int formula) throws Exception {
        return augmented ? getPassiveVerbConjugationsForAugmented(rootLetters, formula)
                : getPassiveVerbConjugationsForUnaugmented(rootLetters, cclass);
    }

    private VerbConjugations getPassiveVerbConjugationsForUnaugmented(String rootLetters, int cclass) throws Exception {
        return getVerbConjugationsForUnaugmented(rootLetters, cclass, false);
    }

    private VerbConjugations getPassiveVerbConjugationsForAugmented(String rootLetters, int formula) throws Exception{
        return getVerbConjugationsForAugmented(rootLetters, formula, false);
    }


    @Override
    public NounConjugations getNouns(String rootLetters, boolean augmented, int cclass, int formula) throws Exception {
        return augmented ? getNounsForAugmented(rootLetters, formula) :
                getNounsForUnaugmented(rootLetters, cclass);
    }

    private NounConjugations getNounsForUnaugmented(String rootLetters, int cclass) throws Exception {
        var kov = kovRulesManager.getTrilateralKov(rootLetters.charAt(0), rootLetters.charAt(1), rootLetters.charAt(2));
        var root = sarfDictionary.getUnaugmentedTrilateralRoots(rootLetters).stream()
                .filter(r -> r.getConjugation().getValue() == cclass)
                .findFirst().orElse(null);
        if (root == null) {
            throw new Exception(String.format("Could not find a root with letters %s and class of %d.", rootLetters, cclass));
        }
        var nounConjugations = new NounConjugations();

        setDerivedNouns(kov, root, nounConjugations);
        return  nounConjugations;
    }

    private void setDerivedNouns(KindOfVerb kov, UnaugmentedTrilateralRoot root, NounConjugations nounConjugations) {
        var activeParticiples = this.trilateralUnaugmentedDerivedNounBridge.getActiveParticiple(root, kov);
        nounConjugations.setActiveParticiples(activeParticiples);

        var passiveParticiples = this.trilateralUnaugmentedDerivedNounBridge.getPassiveParticiple(root, kov);
        nounConjugations.setPassiveParticiples(passiveParticiples);

        var timeAndPlaceNouns = this.trilateralUnaugmentedDerivedNounBridge.getTimeAndPlaceNouns(root, kov);
        nounConjugations.setTimeAndPlaceNouns(timeAndPlaceNouns);

        var exaggeratedActiveParticiples = this.trilateralUnaugmentedDerivedNounBridge.getExaggeratedActiveParticiples(root, kov);
        nounConjugations.setExaggeratedActiveParticiples(exaggeratedActiveParticiples);

        var instrumentalNouns = this.trilateralUnaugmentedDerivedNounBridge.getInstrumentalNouns(root, kov);
        nounConjugations.setInstrumentalNouns(instrumentalNouns);

        var elatives = this.trilateralUnaugmentedDerivedNounBridge.getElatives(root, kov);
        nounConjugations.setElatives(elatives);

        var assimilates = this.trilateralUnaugmentedDerivedNounBridge.getAssimilates(root, kov);
        nounConjugations.setAssimilates(assimilates);
    }

    private NounConjugations getNounsForAugmented(String rootLetters, int formula) throws Exception {
        var kov = kovRulesManager.getTrilateralKov(rootLetters.charAt(0), rootLetters.charAt(1), rootLetters.charAt(2));
        var root = sarfDictionary.getAugmentedTrilateralRoot(rootLetters);
        if (root == null) {
            throw new Exception(String.format("Could not find a root with letters %s", rootLetters));
        }
        var nounConjugations = new NounConjugations();

        setDerivedNounsForTrilateralAugmented(kov, root, nounConjugations, formula);
        return  nounConjugations;
    }
    private void setDerivedNounsForTrilateralAugmented(KindOfVerb kov, AugmentedTrilateralRoot root, NounConjugations nounConjugations, int formulaNo){
        var activeParticiples = this.trilateralAugmentedDerivedNounBridge.getActiveParticiples(root, kov, formulaNo);
        nounConjugations.setActiveParticiples(activeParticiples);

        var passiveParticiples = this.trilateralAugmentedDerivedNounBridge.getPassiveParticiples(root, kov, formulaNo);
        nounConjugations.setPassiveParticiples(passiveParticiples);

        var timeAndPlaceNouns = this.trilateralAugmentedDerivedNounBridge.getTimeAndPlaceNouns(root, kov, formulaNo);
        nounConjugations.setTimeAndPlaceNouns(timeAndPlaceNouns);
    }

    @Override
    public GerundConjugations getGerunds(String rootLetters, boolean augmented, int cclass, int formula) throws Exception {
        return augmented ? getGerundsForAugmented(rootLetters, formula) :
                getGerundsForUnaugmented(rootLetters, cclass);
    }

    private GerundConjugations getGerundsForUnaugmented(String rootLetters, int cclass) throws Exception {
        var kov = kovRulesManager.getTrilateralKov(rootLetters.charAt(0), rootLetters.charAt(1), rootLetters.charAt(2));
        var root = sarfDictionary.getUnaugmentedTrilateralRoots(rootLetters).stream()
                .filter(r -> r.getConjugation().getValue() == cclass)
                .findFirst().orElse(null);
        if (root == null) {
            throw new Exception(String.format("Could not find a root with letters %s and class of %d.", rootLetters, cclass));
        }
        var gerundConjugations = new GerundConjugations();

        setGerunds(kov, root, gerundConjugations);
        return  gerundConjugations;
    }

    private void setGerunds(KindOfVerb kov, UnaugmentedTrilateralRoot root, GerundConjugations gerundConjugations) throws Exception {
        var standards = this.trilateralUnaugmentedGerundBridge.getStandardGerunds(root, kov);
        gerundConjugations.setStandards(standards);

        var meems = this.trilateralUnaugmentedGerundBridge.getMeemGerunds(root, kov);
        gerundConjugations.setMeems(meems);

        var nomens = this.trilateralUnaugmentedGerundBridge.getNomenGerunds(root, kov);
        gerundConjugations.setNomens(nomens);

        var qGerunds = this.trilateralUnaugmentedGerundBridge.getQualityGerunds(root, kov);
        gerundConjugations.setQualityGerunds(qGerunds);
    }

    private GerundConjugations getGerundsForAugmented(String rootLetters, int formula) throws Exception {
        var kov = kovRulesManager.getTrilateralKov(rootLetters.charAt(0), rootLetters.charAt(1), rootLetters.charAt(2));
        var root = sarfDictionary.getAugmentedTrilateralRoot(rootLetters);
        if (root == null) {
            throw new Exception(String.format("Could not find a root with letters %s", rootLetters));
        }
        var gerundConjugations = new GerundConjugations();
        setGerundsForAugmented(kov, formula, root, gerundConjugations);
        return gerundConjugations;
    }

    private void setGerundsForAugmented(KindOfVerb kov, int formulaNo, AugmentedTrilateralRoot root, GerundConjugations gerundConjugations) throws Exception {
        var standards = this.trilateralAugmentedGerundBridge.getStandardGerunds(root, kov, formulaNo);
        gerundConjugations.setStandards(standards);

        var meems = this.trilateralAugmentedGerundBridge.getMeemGerunds(root, kov, formulaNo);
        gerundConjugations.setMeems(meems);

        var nomens = this.trilateralAugmentedGerundBridge.getNomenGerunds(root, kov, formulaNo);
        gerundConjugations.setNomens(nomens);
    }
}
