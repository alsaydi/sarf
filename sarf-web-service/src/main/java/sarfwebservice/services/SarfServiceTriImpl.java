package sarfwebservice.services;

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
import sarfwebservice.models.ConjugationResultDisplay;
import sarfwebservice.models.RootResult;
import sarfwebservice.models.TriRootDisplay;

import java.util.ArrayList;
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

    @Autowired
    public SarfServiceTriImpl(SarfDictionary sarfDictionary
            , Validator sarfValidator
            , KovRulesManager kovRulesManager
            , AugmentedActivePastConjugator augmentedActivePastConjugator
            , AugmentedTrilateralModifier augmentedTrilateralModifier
            , ActivePastConjugator unaugmentedTriActivePastConjugator
            , UnaugmentedTrilateralModifier unaugmentedTrilateralModifier, ActivePresentConjugator activePresentConjugator, AugmentedActivePresentConjugator augmentedActivePresentConjugator) {
        super(sarfValidator);
        this.sarfDictionary = sarfDictionary;
        this.kovRulesManager = kovRulesManager;
        this.augmentedActivePastConjugator = augmentedActivePastConjugator;
        this.augmentedTrilateralModifier = augmentedTrilateralModifier;
        this.unaugmentedTriActivePastConjugator = unaugmentedTriActivePastConjugator;
        this.unaugmentedTrilateralModifier = unaugmentedTrilateralModifier;
        this.activePresentConjugator = activePresentConjugator;
        this.augmentedActivePresentConjugator = augmentedActivePresentConjugator;
    }

    public RootResult getRoots(String rootLetters) {
        try {
            var rootResult = new RootResult();
            var kov = kovRulesManager.getTrilateralKov(rootLetters.charAt(0), rootLetters.charAt(1), rootLetters.charAt(2));
            var conjugationResultDisplays = new ArrayList<ConjugationResultDisplay>();
            var displays = new ArrayList<TriRootDisplay>();

            var unaugmentedTrilateralRoots = sarfDictionary.getUnaugmentedTrilateralRoots(rootLetters);
            for (var root : unaugmentedTrilateralRoots) {
                var display = new TriRootDisplay();
                display.setRoot(root);
                display.setDisplay(conjugateRoot(root, kov));
                displays.add(display);
            }
            var augmentedTrilateralRoot = sarfDictionary.getAugmentedTrilateralRoot(rootLetters);
            var augmentationFormulas = augmentedTrilateralRoot.getAugmentationList();
            for (var formula : augmentationFormulas) {
                var verbs = augmentedActivePastConjugator.createVerbList(augmentedTrilateralRoot, formula.getFormulaNo());
                var conjugationResult = augmentedTrilateralModifier.build(augmentedTrilateralRoot, kov, formula.getFormulaNo(), verbs, SystemConstants.PAST_TENSE
                        , true, () -> true);

                var conjugationResultDisplay = new ConjugationResultDisplay();
                conjugationResultDisplay.setConjugationResult(conjugationResult);
                conjugationResultDisplay.setDisplay(conjugateAugmentedRoot(formula.getFormulaNo(), augmentedTrilateralRoot, kov));
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

    private static List<Word> createEmptyList() {
        List<Word> result = new ArrayList<>(13);
        for (int i = 1; i <= 13; i++) {
            result.add(Word.empty());
        }
        return result;
    }
}