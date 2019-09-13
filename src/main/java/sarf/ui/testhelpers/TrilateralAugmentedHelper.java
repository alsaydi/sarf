package sarf.ui.testhelpers;

import com.google.inject.Inject;
import sarf.AugmentationFormula;
import sarf.SarfDictionary;
import sarf.SystemConstants;
import sarf.kov.KovRulesManager;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;
import sarf.verb.trilateral.augmented.active.past.AugmentedActivePastConjugator;
import sarf.verb.trilateral.augmented.active.present.AugmentedActivePresentConjugator;
import sarf.verb.trilateral.augmented.active.present.AugmentedPresentConjugator;
import sarf.verb.trilateral.augmented.modifier.AugmentedTrilateralModifier;

import java.util.List;

public class TrilateralAugmentedHelper {
    private final SarfDictionary sarfDictionary;
    private final AugmentedActivePastConjugator augmentedActivePastConjugator;
    private final AugmentedTrilateralModifier augmentedTrilateralModifier;
    private final AugmentedActivePresentConjugator augmentedActivePresentConjugator;
    private final KovRulesManager kovRulesManager;

    @Inject
    public TrilateralAugmentedHelper(SarfDictionary sarfDictionary
            , KovRulesManager kovRulesManager
            , AugmentedActivePastConjugator augmentedActivePastConjugator
            , AugmentedTrilateralModifier augmentedTrilateralModifier
            , AugmentedActivePresentConjugator augmentedActivePresentConjugator
    ) {

        this.sarfDictionary = sarfDictionary;
        this.kovRulesManager = kovRulesManager;
        this.augmentedActivePastConjugator = augmentedActivePastConjugator;
        this.augmentedTrilateralModifier = augmentedTrilateralModifier;
        this.augmentedActivePresentConjugator = augmentedActivePresentConjugator;
    }

    public void printPastActiveAugmentedVerbs(String rootLetters) {
        try {
            var augmentedRoot = sarfDictionary.getAugmentedTrilateralRoot(rootLetters);
            if(augmentedRoot == null){
                return;
            }
            var kov = kovRulesManager.getTrilateralKov(rootLetters.charAt(0), rootLetters.charAt(1), rootLetters.charAt(2));
            var augmentationFormulas = augmentedRoot.getAugmentationList();
            if(augmentationFormulas == null){
                return;
            }
            for (var formula : augmentationFormulas) {
                var verbs = augmentedActivePastConjugator.createVerbList(augmentedRoot, formula.getFormulaNo());
                var conjugationResult = augmentedTrilateralModifier.build(augmentedRoot, kov, formula.getFormulaNo(), verbs, SystemConstants.PAST_TENSE
                        , true, () -> true);

                printFinalResultPipeSeparated(augmentedRoot, conjugationResult.getFinalResult(),formula);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printPresentActiveAugmentedVerbs(String rootLetters) {
        try {
            var augmentedRoot = sarfDictionary.getAugmentedTrilateralRoot(rootLetters);
            var kov = kovRulesManager.getTrilateralKov(rootLetters.charAt(0), rootLetters.charAt(1), rootLetters.charAt(2));
            if(augmentedRoot == null || augmentedRoot.getAugmentationList() == null || augmentedRoot.getAugmentationList().isEmpty()){
                //System.err.println("No root or formulas for " + rootLetters);
                return;
            }
            for (var formula : augmentedRoot.getAugmentationList()) {
                var verbs = augmentedActivePresentConjugator.getNominativeConjugator().createVerbList(augmentedRoot, formula.getFormulaNo());
                var conjugationResult = augmentedTrilateralModifier.build(augmentedRoot, kov, formula.getFormulaNo(), verbs, SystemConstants.PRESENT_TENSE
                        , true, () -> true);
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
