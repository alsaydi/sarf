package sarf.ui.testhelpers;

import com.google.inject.Inject;
import sarf.AugmentationFormula;
import sarf.SarfDictionary;
import sarf.SystemConstants;
import sarf.gerund.modifier.quadrilateral.QuadrilateralStandardModifier;
import sarf.gerund.quadrilateral.augmented.QuadrilateralAugmentedGerundConjugator;
import sarf.gerund.quadrilateral.augmented.nomen.QuadrilateralAugmentedNomenGerundConjugator;
import sarf.kov.KovRulesManager;
import sarf.noun.quadriliteral.augmented.AugmentedQuadrilateralActiveParticipleConjugator;
import sarf.noun.quadriliteral.augmented.AugmentedQuadrilateralPassiveParticipleConjugator;
import sarf.noun.quadriliteral.modifier.activeparticiple.ActiveParticipleModifier;
import sarf.noun.quadriliteral.modifier.passiveparticiple.PassiveParticipleModifier;
import sarf.verb.quadriliteral.QuadrilateralRoot;
import sarf.verb.quadriliteral.augmented.active.past.QuadrilateralAugmentedActivePastConjugator;
import sarf.verb.quadriliteral.augmented.active.present.AugmentedQuadActivePresentConjugator;
import sarf.verb.quadriliteral.augmented.imperative.AugmentedQuadImperativeConjugator;
import sarf.verb.quadriliteral.augmented.passive.past.QuadriAugmentedPassivePastConjugator;
import sarf.verb.quadriliteral.augmented.passive.present.AugmentedQuadPassivePresentConjugator;
import sarf.verb.quadriliteral.modifier.QuadrilateralModifier;
import sarf.verb.trilateral.augmented.passive.present.AugmentedPassivePresentConjugator;

import java.util.List;

public class QuadrilateralAugmentedHelper {

    private final SarfDictionary sarfDictionary;
    private final KovRulesManager kovRulesManager;
    private final QuadrilateralAugmentedActivePastConjugator quadriActivePastConjugator;
    private final QuadriAugmentedPassivePastConjugator passivePastConjugator;
    private final AugmentedQuadrilateralActiveParticipleConjugator activeParticipleConjugator;
    private final ActiveParticipleModifier activeParticipleModifier;
    private final AugmentedQuadrilateralPassiveParticipleConjugator passiveParticipleConjugator;
    private final PassiveParticipleModifier passiveParticipleModifier;
    private final QuadrilateralAugmentedGerundConjugator gerundConjugator;
    private final QuadrilateralStandardModifier standardModifier;
    private final QuadrilateralAugmentedNomenGerundConjugator nomenGerundConjugator;
    private final QuadrilateralModifier quadrilateralModifier;
    private final AugmentedQuadImperativeConjugator augmentedQuadImperativeConjugator;
    private final AugmentedQuadActivePresentConjugator augmentedQuadActivePresentConjugator;
    private final AugmentedQuadPassivePresentConjugator augmentedQuadPassivePresentConjugator;

    @Inject
    public QuadrilateralAugmentedHelper(SarfDictionary sarfDictionary, KovRulesManager kovRulesManager
            , QuadrilateralAugmentedActivePastConjugator quadriActivePastConjugator
            , QuadriAugmentedPassivePastConjugator passivePastConjugator
            , AugmentedQuadrilateralActiveParticipleConjugator activeParticipleConjugator
            , ActiveParticipleModifier activeParticipleModifier
            , AugmentedQuadrilateralPassiveParticipleConjugator passiveParticipleConjugator
            , PassiveParticipleModifier passiveParticipleModifier
            , QuadrilateralAugmentedGerundConjugator gerundConjugator
            , QuadrilateralStandardModifier standardModifier
            , QuadrilateralAugmentedNomenGerundConjugator nomenGerundConjugator
            , QuadrilateralModifier quadrilateralModifier
            , AugmentedQuadImperativeConjugator augmentedQuadImperativeConjugator
            , AugmentedQuadActivePresentConjugator augmentedQuadActivePresentConjugator
            , AugmentedQuadPassivePresentConjugator augmentedQuadPassivePresentConjugator) {
        this.sarfDictionary = sarfDictionary;
        this.kovRulesManager = kovRulesManager;
        this.quadriActivePastConjugator = quadriActivePastConjugator;
        this.passivePastConjugator = passivePastConjugator;
        this.activeParticipleConjugator = activeParticipleConjugator;
        this.activeParticipleModifier = activeParticipleModifier;
        this.passiveParticipleConjugator = passiveParticipleConjugator;
        this.passiveParticipleModifier = passiveParticipleModifier;
        this.gerundConjugator = gerundConjugator;
        this.standardModifier = standardModifier;
        this.nomenGerundConjugator = nomenGerundConjugator;
        this.quadrilateralModifier = quadrilateralModifier;
        this.augmentedQuadImperativeConjugator = augmentedQuadImperativeConjugator;
        this.augmentedQuadActivePresentConjugator = augmentedQuadActivePresentConjugator;
        this.augmentedQuadPassivePresentConjugator = augmentedQuadPassivePresentConjugator;
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
                var conjugationResult = quadrilateralModifier.build(root, formula.getFormulaNo(), kovRule.getKov(), verbs, SystemConstants.PAST_TENSE, true, true)
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
                var verbs = augmentedQuadActivePresentConjugator.getEmphasizedConjugator().createVerbList(root, formula.getFormulaNo());
                var conjugationResult = quadrilateralModifier.build(root, formula.getFormulaNo(), kovRule.getKov(), verbs, SystemConstants.PRESENT_TENSE, true, true)
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
                var verbs = augmentedQuadImperativeConjugator.getEmphasizedConjugator().createVerbList(root, formula.getFormulaNo());
                var conjugationResult = quadrilateralModifier.build(root, formula.getFormulaNo(), kovRule.getKov(), verbs, SystemConstants.PRESENT_TENSE, true, true)
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
                var conjugationResult = quadrilateralModifier.build(root, formula.getFormulaNo(), kovRule.getKov()
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
                var verbs = augmentedQuadPassivePresentConjugator.getEmphasizedConjugator().createVerbList(root, formula.getFormulaNo());
                var conjugationResult = quadrilateralModifier.build(root, formula.getFormulaNo(), kovRule.getKov()
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

    public void printPassiveParticiple(String rootLetters) {
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
                var nouns = passiveParticipleConjugator.createNounList(root, formula.getFormulaNo());
                var conjugationResult = passiveParticipleModifier.build(root, formula.getFormulaNo(), kovRule.getKov()
                        , nouns).getFinalResult();
                printFinalResultPipeSeparated(root, conjugationResult, formula);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printTimeAndPlace(String rootLetters) {
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
                var nouns = passiveParticipleConjugator.createTimeAndPlaceNounList(root, formula.getFormulaNo());
                var conjugationResult = passiveParticipleModifier.build(root, formula.getFormulaNo(), kovRule.getKov()
                        , nouns).getFinalResult();
                printFinalResultPipeSeparated(root, conjugationResult, formula);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printGerund(String rootLetters) {
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
                var nouns = gerundConjugator.createGerundList(root, formula.getFormulaNo());
                var conjugationResult = standardModifier.build(root, formula.getFormulaNo(), kovRule.getKov(), nouns).getFinalResult();
                printFinalResultPipeSeparated(root, conjugationResult, formula);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printMeemGerund(String rootLetters) {
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
                var nouns = passiveParticipleConjugator.createMeemGerundNounList(root, formula.getFormulaNo());
                var conjugationResult = standardModifier.build(root, formula.getFormulaNo(), kovRule.getKov()
                        , nouns).getFinalResult();
                printFinalResultPipeSeparated(root, conjugationResult, formula);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printNomenGerund(String rootLetters) {
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
                //List nouns;
                var nouns = nomenGerundConjugator.createGerundList(root, formula.getFormulaNo());
                var conjugationResult = standardModifier.build(root, formula.getFormulaNo(), kovRule.getKov()
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
        System.out.println();
    }
}
