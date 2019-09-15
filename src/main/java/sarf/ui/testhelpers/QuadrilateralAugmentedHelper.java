package sarf.ui.testhelpers;

import com.google.inject.Inject;
import sarf.SarfDictionary;
import sarf.SystemConstants;
import sarf.kov.KovRulesManager;
import sarf.verb.quadriliteral.QuadrilateralRoot;
import sarf.verb.quadriliteral.augmented.active.past.QuadrilateralAugmentedActivePastConjugator;
import sarf.verb.quadriliteral.modifier.QuadrilateralModifier;

import java.util.List;

public class QuadrilateralAugmentedHelper {

    private final SarfDictionary sarfDictionary;
    private final KovRulesManager kovRulesManager;
    private final QuadrilateralAugmentedActivePastConjugator quadriActivePastConjugator;

    @Inject
    public QuadrilateralAugmentedHelper(SarfDictionary sarfDictionary, KovRulesManager kovRulesManager
            , QuadrilateralAugmentedActivePastConjugator quadriActivePastConjugator) {
        this.sarfDictionary = sarfDictionary;
        this.kovRulesManager = kovRulesManager;
        this.quadriActivePastConjugator = quadriActivePastConjugator;
    }

    public void printPastActive(String rootLetters) {
        try {
            var root = sarfDictionary.getAugmentedQuadrilateralRoot(rootLetters);
            var kovRule = kovRulesManager.getQuadrilateralKovRule(root.getC1(), root.getC2(), root.getC3(), root.getC4());
            var formulas = root.getAugmentationList();
            if (formulas.isEmpty()) {
                return;
            }
            for (var formula : formulas) {
                var verbs = quadriActivePastConjugator.createVerbList(root, formula.getFormulaNo());
                var conjugationResult = QuadrilateralModifier.getInstance().build(root, formula.getFormulaNo(), kovRule.getKov(), verbs, SystemConstants.PAST_TENSE, true, true)
                        .getFinalResult();
                printFinalResultPipeSeparated(root, conjugationResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printFinalResultPipeSeparated(QuadrilateralRoot root, List finalResult) {
        System.out.printf("| %c%c%c%c |", root.getC1(), root.getC2(), root.getC3(), root.getC4());
        for (Object word : finalResult) {
            System.out.printf(" %s |", word == null ? "" : word);
        }
        System.out.println("");
    }
}
