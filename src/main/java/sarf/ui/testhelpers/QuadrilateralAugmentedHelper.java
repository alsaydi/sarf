package sarf.ui.testhelpers;

import com.google.inject.Inject;
import sarf.AugmentationFormula;
import sarf.SarfDictionary;
import sarf.SystemConstants;
import sarf.kov.KovRulesManager;
import sarf.noun.quadriliteral.augmented.AugmentedQuadrilateralActiveParticipleConjugator;
import sarf.noun.quadriliteral.modifier.activeparticiple.ActiveParticipleModifier;
import sarf.verb.quadriliteral.QuadrilateralRoot;
import sarf.verb.quadriliteral.augmented.active.past.QuadrilateralAugmentedActivePastConjugator;
import sarf.verb.quadriliteral.augmented.active.present.AugmentedActivePresentConjugator;
import sarf.verb.quadriliteral.augmented.imperative.AugmentedImperativeConjugator;
import sarf.verb.quadriliteral.augmented.passive.past.QuadriAugmentedPassivePastConjugator;
import sarf.verb.quadriliteral.augmented.passive.present.AugmentedPassivePresentConjugator;
import sarf.verb.quadriliteral.modifier.QuadrilateralModifier;

import java.util.List;

public class QuadrilateralAugmentedHelper {

    private final SarfDictionary sarfDictionary;
    private final KovRulesManager kovRulesManager;
    private final QuadrilateralAugmentedActivePastConjugator quadriActivePastConjugator;
    private final QuadriAugmentedPassivePastConjugator passivePastConjugator;
    private final AugmentedQuadrilateralActiveParticipleConjugator activeParticipleConjugator;
    private final ActiveParticipleModifier activeParticipleModifier;
    @Inject
    public QuadrilateralAugmentedHelper(SarfDictionary sarfDictionary, KovRulesManager kovRulesManager
            , QuadrilateralAugmentedActivePastConjugator quadriActivePastConjugator
            , QuadriAugmentedPassivePastConjugator passivePastConjugator
            , AugmentedQuadrilateralActiveParticipleConjugator activeParticipleConjugator
            , ActiveParticipleModifier activeParticipleModifier) {
        this.sarfDictionary = sarfDictionary;
        this.kovRulesManager = kovRulesManager;
        this.quadriActivePastConjugator = quadriActivePastConjugator;
        this.passivePastConjugator = passivePastConjugator;
        this.activeParticipleConjugator = activeParticipleConjugator;
        this.activeParticipleModifier = activeParticipleModifier;
    }

    public void printPastActive(String rootLetters) {
        try {
            var root = sarfDictionary.getAugmentedQuadrilateralRoot(rootLetters);
            if (root == null) {
                return;
            }
            var kovRule = kovRulesManager.getQuadrilateralKovRule(root.getC1(), root.getC2(), root.getC3(), root.getC4());
            var formulas = root.getAugmentationList();
            if (formulas.isEmpty()) {
                return;
            }
            for (var formula : formulas) {
                var verbs = quadriActivePastConjugator.createVerbList(root, formula.getFormulaNo());
                var conjugationResult = QuadrilateralModifier.getInstance().build(root, formula.getFormulaNo(), kovRule.getKov(), verbs, SystemConstants.PAST_TENSE, true, true)
                        .getFinalResult();
                printFinalResultPipeSeparated(root, conjugationResult, formula);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printPresent(String rootLetters) {
        try {
            var root = sarfDictionary.getAugmentedQuadrilateralRoot(rootLetters);
            if (root == null) {
                return;
            }
            var kovRule = kovRulesManager.getQuadrilateralKovRule(root.getC1(), root.getC2(), root.getC3(), root.getC4());
            var formulas = root.getAugmentationList();
            if (formulas.isEmpty()) {
                return;
            }
            for (var formula : formulas) {
                var verbs = AugmentedActivePresentConjugator.getInstance().getEmphasizedConjugator().createVerbList(root, formula.getFormulaNo());
                var conjugationResult = QuadrilateralModifier.getInstance().build(root, formula.getFormulaNo(), kovRule.getKov(), verbs, SystemConstants.PRESENT_TENSE, true, true)
                        .getFinalResult();
                printFinalResultPipeSeparated(root, conjugationResult, formula);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printImperative(String rootLetters) {
        try {
            var root = sarfDictionary.getAugmentedQuadrilateralRoot(rootLetters);
            if (root == null) {
                return;
            }
            var kovRule = kovRulesManager.getQuadrilateralKovRule(root.getC1(), root.getC2(), root.getC3(), root.getC4());
            var formulas = root.getAugmentationList();
            if (formulas.isEmpty()) {
                return;
            }
            for (var formula : formulas) {
                var verbs = AugmentedImperativeConjugator.getInstance().getEmphsizedConjugator().createVerbList(root, formula.getFormulaNo());
                var conjugationResult = QuadrilateralModifier.getInstance().build(root, formula.getFormulaNo(), kovRule.getKov(), verbs, SystemConstants.PRESENT_TENSE, true, true)
                        .getFinalResult();
                printFinalResultPipeSeparated(root, conjugationResult, formula);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printPassivePast(String rootLetters) {
        try {
            var root = sarfDictionary.getAugmentedQuadrilateralRoot(rootLetters);
            if (root == null) {
                return;
            }
            var kovRule = kovRulesManager.getQuadrilateralKovRule(root.getC1(), root.getC2(), root.getC3(), root.getC4());
            var formulas = root.getAugmentationList();
            if (formulas.isEmpty()) {
                return;
            }
            for (var formula : formulas) {
                var verbs = passivePastConjugator.createVerbList(root, formula.getFormulaNo());
                var conjugationResult = QuadrilateralModifier.getInstance().build(root, formula.getFormulaNo(), kovRule.getKov()
                        , verbs
                        , SystemConstants.PAST_TENSE
                        , false
                        , true).getFinalResult();
                printFinalResultPipeSeparated(root, conjugationResult, formula);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printPassivePresent(String rootLetters) {
        try {
            var root = sarfDictionary.getAugmentedQuadrilateralRoot(rootLetters);
            if (root == null) {
                return;
            }
            var kovRule = kovRulesManager.getQuadrilateralKovRule(root.getC1(), root.getC2(), root.getC3(), root.getC4());
            var formulas = root.getAugmentationList();
            if (formulas.isEmpty()) {
                return;
            }
            for (var formula : formulas) {
                var verbs = AugmentedPassivePresentConjugator.getInstance().getEmphasizedConjugator().createVerbList(root, formula.getFormulaNo());
                var conjugationResult = QuadrilateralModifier.getInstance().build(root, formula.getFormulaNo(), kovRule.getKov()
                        , verbs
                        , SystemConstants.PRESENT_TENSE
                        , false
                        , true).getFinalResult();
                printFinalResultPipeSeparated(root, conjugationResult, formula);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printActiveParticiple(String rootLetters) {
        try {
            var root = sarfDictionary.getAugmentedQuadrilateralRoot(rootLetters);
            if (root == null) {
                return;
            }
            var kovRule = kovRulesManager.getQuadrilateralKovRule(root.getC1(), root.getC2(), root.getC3(), root.getC4());
            var formulas = root.getAugmentationList();
            if (formulas.isEmpty()) {
                return;
            }
            for (var formula : formulas) {
                var nouns = activeParticipleConjugator.createNounList(root, formula.getFormulaNo());
                var conjugationResult = activeParticipleModifier.build(root, formula.getFormulaNo(), kovRule.getKov()
                        , nouns).getFinalResult();
                printFinalResultPipeSeparated(root, conjugationResult, formula);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printFinalResultPipeSeparated(QuadrilateralRoot root, List finalResult, AugmentationFormula augmentationFormula) {
        System.out.printf("| %c%c%c%c | %d |", root.getC1(), root.getC2(), root.getC3(), root.getC4(), augmentationFormula.getFormulaNo());
        for (Object word : finalResult) {
            System.out.printf(" %s |", word == null ? "" : word);
        }
        System.out.println("");
    }
}
