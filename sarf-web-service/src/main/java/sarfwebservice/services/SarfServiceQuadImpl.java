package sarfwebservice.services;

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
    public RootResult getRoots(String rootLetters) throws Exception {
        try {
            var rootResult = new RootResult();
            var kov = kovRulesManager.getTrilateralKov(rootLetters.charAt(0), rootLetters.charAt(1), rootLetters.charAt(2));
            var conjugationResultDisplays = new ArrayList<ConjugationResultDisplay>();
            var displays = new ArrayList<TriRootDisplay>();

            var root = sarfDictionary.getUnaugmentedQuadrilateralRoot(rootLetters);
            var display = new TriRootDisplay();
            display.setRoot(root);
            display.setDisplay(conjugateRoot(root, kov));
            displays.add(display);
            var augmentedQuadrilateralRoot = sarfDictionary.getAugmentedQuadrilateralRoot(rootLetters);
            var augmentationFormulas = augmentedQuadrilateralRoot.getAugmentationList();
            for (var formula : augmentationFormulas) {
                var verbs = quadrilateralAugmentedActivePastConjugator.createVerbList(augmentedQuadrilateralRoot, formula.getFormulaNo());
                var conjugationResult = quadrilateralModifier.build(augmentedQuadrilateralRoot, formula.getFormulaNo(), kov, verbs, SystemConstants.PAST_TENSE
                        , true);

                var conjugationResultDisplay = new ConjugationResultDisplay();
                conjugationResultDisplay.setConjugationResult(conjugationResult);
                conjugationResultDisplay.setDisplay(conjugateAugmentedRoot(formula.getFormulaNo(), augmentedQuadrilateralRoot, kov));
                conjugationResultDisplays.add(conjugationResultDisplay);
            }
            rootResult.setUnaugmentedRoots(displays);
            rootResult.setConjugationResults(conjugationResultDisplays);
            return rootResult;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String conjugateRoot(UnaugmentedQuadrilateralRoot root, KindOfVerb kov) {
        if(root == null) {
            return  "";
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
}
