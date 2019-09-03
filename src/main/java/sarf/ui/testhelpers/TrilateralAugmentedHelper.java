package sarf.ui.testhelpers;

import com.google.inject.Inject;
import sarf.AugmentationFormula;
import sarf.SarfDictionary;
import sarf.SystemConstants;
import sarf.kov.KovRulesManager;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;
import sarf.verb.trilateral.augmented.active.past.AugmentedActivePastConjugator;
import sarf.verb.trilateral.augmented.active.present.AugmentedPresentConjugator;
import sarf.verb.trilateral.augmented.modifier.AugmentedTrilateralModifier;

import java.util.List;

public class TrilateralAugmentedHelper {
    private final SarfDictionary sarfDictionary;
    private final AugmentedActivePastConjugator augmentedActivePastConjugator;
    private final AugmentedTrilateralModifier augmentedTrilateralModifier;
    private final AugmentedPresentConjugator augmentedPresentConjugator;
    private final KovRulesManager kovRulesManager;

    @Inject
    public TrilateralAugmentedHelper(SarfDictionary sarfDictionary
            , KovRulesManager kovRulesManager
            , AugmentedActivePastConjugator augmentedActivePastConjugator
            , AugmentedTrilateralModifier augmentedTrilateralModifier
            , AugmentedPresentConjugator augmentedPresentConjugator
    ) {

        this.sarfDictionary = sarfDictionary;
        this.kovRulesManager = kovRulesManager;
        this.augmentedActivePastConjugator = augmentedActivePastConjugator;
        this.augmentedTrilateralModifier = augmentedTrilateralModifier;
        this.augmentedPresentConjugator = augmentedPresentConjugator;
    }

    public void printPastActiveAugmentedVerbs(String rootLetters) {
        try {
            var augmentedRoot = sarfDictionary.getAugmentedTrilateralRoot(rootLetters);
            var kov = kovRulesManager.getTrilateralKov(rootLetters.charAt(0), rootLetters.charAt(1), rootLetters.charAt(2));
            for (var formula : augmentedRoot.getAugmentationList()) {
                var verbs = augmentedActivePastConjugator.createVerbList(augmentedRoot, formula.getFormulaNo());
                var conjugationResult = augmentedTrilateralModifier.build(augmentedRoot, kov, formula.getFormulaNo(), verbs, SystemConstants.PAST_TENSE
                        , true, () -> false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printPresentActiveAugmentedVerbs(String rootLetters) {
        try {
            var augmentedRoot = sarfDictionary.getAugmentedTrilateralRoot(rootLetters);
            var kov = kovRulesManager.getTrilateralKov(rootLetters.charAt(0), rootLetters.charAt(1), rootLetters.charAt(2));
            for (var formula : augmentedRoot.getAugmentationList()) {
                var verbs = augmentedPresentConjugator.createVerbList(augmentedRoot, formula.getFormulaNo());
                var conjugationResult = augmentedTrilateralModifier.build(augmentedRoot, kov, formula.getFormulaNo(), verbs, SystemConstants.PRESENT_TENSE
                        , true, () -> false);
                printFinalResultPipeSeparated(augmentedRoot, conjugationResult.getFinalResult(), formula);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printFinalResultPipeSeparated(AugmentedTrilateralRoot root, List finalResult, AugmentationFormula augmentationFormula) {
        System.out.printf("| %c%c%c | %d |", root.getC1(), root.getC2(), root.getC3(), augmentationFormula.getFormulaNo());
        for (Object word : finalResult) {
            System.out.printf(" %s |", word == null ? "" : word);
        }
        System.out.println("");
    }
}
