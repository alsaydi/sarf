package sarf.ui.testhelpers;

import com.google.inject.Inject;
import sarf.AugmentationFormula;
import sarf.SarfDictionary;
import sarf.SystemConstants;
import sarf.gerund.modifier.trilateral.augmented.standard.TrilateralAugmentedStandardModifier;
import sarf.gerund.trilateral.augmented.TrilateralAugmentedGerundConjugator;
import sarf.gerund.trilateral.augmented.nomen.TrilateralAugmentedNomenGerundConjugator;
import sarf.kov.KovRulesManager;
import sarf.noun.GenericNounSuffixContainer;
import sarf.noun.trilateral.augmented.AugmentedTrilateralActiveParticipleConjugator;
import sarf.noun.trilateral.augmented.AugmentedTrilateralPassiveParticipleConjugator;
import sarf.noun.trilateral.augmented.modifier.activeparticiple.ActiveParticipleModifier;
import sarf.noun.trilateral.augmented.modifier.passiveparticiple.PassiveParticipleModifier;
import sarf.verb.quadriliteral.augmented.active.present.AugmentedQuadActivePresentConjugator;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;
import sarf.verb.trilateral.augmented.active.past.AugmentedActivePastConjugator;
import sarf.verb.trilateral.augmented.active.present.AugmentedActivePresentConjugator;
import sarf.verb.trilateral.augmented.imperative.AugmentedImperativeConjugatorFactory;
import sarf.verb.trilateral.augmented.modifier.AugmentedTrilateralModifier;
import sarf.verb.trilateral.augmented.passive.past.AugmentedPassivePastConjugator;

import java.util.List;

public class TrilateralAugmentedHelper {
    private final SarfDictionary sarfDictionary;
    private final AugmentedActivePastConjugator augmentedActivePastConjugator;
    private final AugmentedTrilateralModifier augmentedTrilateralModifier;
    private final AugmentedActivePresentConjugator augmentedActivePresentConjugator;
    private final KovRulesManager kovRulesManager;
    private final AugmentedImperativeConjugatorFactory augmentedImperativeConjugatorFactory;
    private final AugmentedPassivePastConjugator augmentedPassivePastConjugator;
    private final AugmentedTrilateralActiveParticipleConjugator augmentedTrilateralActiveParticipleConjugator;
    private final ActiveParticipleModifier activeParticipleModifier;
    private final AugmentedTrilateralPassiveParticipleConjugator augmentedTrilateralPassiveParticipleConjugator;
    private final PassiveParticipleModifier passiveParticipleModifier;
    private final TrilateralAugmentedGerundConjugator gerundConjugator;
    private final TrilateralAugmentedStandardModifier trilateralAugmentedStandardModifier;
    private final TrilateralAugmentedNomenGerundConjugator nomenGerundConjugator;

    @Inject
    public TrilateralAugmentedHelper(SarfDictionary sarfDictionary
            , KovRulesManager kovRulesManager
            , AugmentedActivePastConjugator augmentedActivePastConjugator
            , AugmentedTrilateralModifier augmentedTrilateralModifier
            , AugmentedActivePresentConjugator augmentedActivePresentConjugator
            , AugmentedImperativeConjugatorFactory augmentedImperativeConjugatorFactory
            , AugmentedPassivePastConjugator augmentedPassivePastConjugator
            , AugmentedTrilateralActiveParticipleConjugator augmentedTrilateralActiveParticipleConjugator
            , ActiveParticipleModifier activeParticipleModifier
            , AugmentedTrilateralPassiveParticipleConjugator augmentedTrilateralPassiveParticipleConjugator
            , PassiveParticipleModifier passiveParticipleModifier
            , TrilateralAugmentedGerundConjugator gerundConjugator
            , TrilateralAugmentedStandardModifier trilateralAugmentedStandardModifier
            , TrilateralAugmentedNomenGerundConjugator nomenGerundConjugator
            , AugmentedQuadActivePresentConjugator augmentedPassivePresentConjugator) {

        this.sarfDictionary = sarfDictionary;
        this.kovRulesManager = kovRulesManager;
        this.augmentedActivePastConjugator = augmentedActivePastConjugator;
        this.augmentedTrilateralModifier = augmentedTrilateralModifier;
        this.augmentedActivePresentConjugator = augmentedActivePresentConjugator;
        this.augmentedImperativeConjugatorFactory = augmentedImperativeConjugatorFactory;
        this.augmentedPassivePastConjugator = augmentedPassivePastConjugator;
        this.augmentedTrilateralActiveParticipleConjugator = augmentedTrilateralActiveParticipleConjugator;
        this.activeParticipleModifier = activeParticipleModifier;
        this.augmentedTrilateralPassiveParticipleConjugator = augmentedTrilateralPassiveParticipleConjugator;
        this.passiveParticipleModifier = passiveParticipleModifier;
        this.gerundConjugator = gerundConjugator;
        this.trilateralAugmentedStandardModifier = trilateralAugmentedStandardModifier;
        this.nomenGerundConjugator = nomenGerundConjugator;
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
                var verbs = augmentedActivePresentConjugator.getEmphasizedConjugator().createVerbList(augmentedRoot, formula.getFormulaNo());
                var conjugationResult = augmentedTrilateralModifier.build(augmentedRoot, kov, formula.getFormulaNo(), verbs, SystemConstants.PRESENT_TENSE
                        , true, () -> true);
                printFinalResultPipeSeparated(augmentedRoot, conjugationResult.getFinalResult(), formula);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printImperativeAugmentedVerbs(String rootLetters) {
        try {
            var augmentedRoot = sarfDictionary.getAugmentedTrilateralRoot(rootLetters);
            var kov = kovRulesManager.getTrilateralKov(rootLetters.charAt(0), rootLetters.charAt(1), rootLetters.charAt(2));
            if(augmentedRoot == null || augmentedRoot.getAugmentationList() == null || augmentedRoot.getAugmentationList().isEmpty()){
                //System.err.println("No root or formulas for " + rootLetters);
                return;
            }
            for (var formula : augmentedRoot.getAugmentationList()) {
                var verbs = augmentedImperativeConjugatorFactory.getEmphasizedConjugator().createVerbList(augmentedRoot, formula.getFormulaNo());
                var conjugationResult = augmentedTrilateralModifier.build(augmentedRoot, kov, formula.getFormulaNo(), verbs, SystemConstants.EMPHASIZED_IMPERATIVE_TENSE
                        , true, () -> true);
                printFinalResultPipeSeparated(augmentedRoot, conjugationResult.getFinalResult(), formula);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printPassivePast(String rootLetters){
        AugmentedTrilateralRoot augmentedRoot;
        try {
            augmentedRoot = sarfDictionary.getAugmentedTrilateralRoot(rootLetters);

            var kov = kovRulesManager.getTrilateralKov(rootLetters.charAt(0), rootLetters.charAt(1), rootLetters.charAt(2));
            if(augmentedRoot == null || augmentedRoot.getAugmentationList() == null || augmentedRoot.getAugmentationList().isEmpty()){
                //System.err.println("No root or formulas for " + rootLetters);
                return;
            }
            for (var formula : augmentedRoot.getAugmentationList()) {
                var verbs = augmentedPassivePastConjugator.createVerbList(augmentedRoot, formula.getFormulaNo());
                var conjugationResult = augmentedTrilateralModifier.build(augmentedRoot, kov, formula.getFormulaNo(), verbs, SystemConstants.PAST_TENSE
                        , false, () -> true);
                printFinalResultPipeSeparated(augmentedRoot, conjugationResult.getFinalResult(), formula);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printActiveParticiple(String rootLetters){
        try {
            var augmentedRoot = sarfDictionary.getAugmentedTrilateralRoot(rootLetters);
            var kov = kovRulesManager.getTrilateralKov(rootLetters.charAt(0), rootLetters.charAt(1), rootLetters.charAt(2));
            if (augmentedRoot == null || augmentedRoot.getAugmentationList() == null || augmentedRoot.getAugmentationList().isEmpty()) {
                //System.err.println("No root or formulas for " + rootLetters);
                return;
            }
            for(var formula: augmentedRoot.getAugmentationList()){
                var nouns = augmentedTrilateralActiveParticipleConjugator.createNounList(augmentedRoot, formula.getFormulaNo(), new GenericNounSuffixContainer());
                var conjugationResult = activeParticipleModifier.build(augmentedRoot, kov, formula.getFormulaNo(), nouns, () -> true);
                printFinalResultPipeSeparated(augmentedRoot, conjugationResult.getFinalResult(), formula);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void printPassiveParticiple(String rootLetters){
        try {
            var augmentedRoot = sarfDictionary.getAugmentedTrilateralRoot(rootLetters);
            var kov = kovRulesManager.getTrilateralKov(rootLetters.charAt(0), rootLetters.charAt(1), rootLetters.charAt(2));
            if (augmentedRoot == null || augmentedRoot.getAugmentationList() == null || augmentedRoot.getAugmentationList().isEmpty()) {
                //System.err.println("No root or formulas for " + rootLetters);
                return;
            }
            for(var formula: augmentedRoot.getAugmentationList()){
                var nouns = augmentedTrilateralPassiveParticipleConjugator.createNounList(augmentedRoot, formula.getFormulaNo(), new GenericNounSuffixContainer());
                var conjugationResult = passiveParticipleModifier.build(augmentedRoot, kov, formula.getFormulaNo(), nouns, () -> true);
                printFinalResultPipeSeparated(augmentedRoot, conjugationResult.getFinalResult(), formula);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void printTimeAndPlace(String rootLetters){
        try {
            var augmentedRoot = sarfDictionary.getAugmentedTrilateralRoot(rootLetters);
            var kov = kovRulesManager.getTrilateralKov(rootLetters.charAt(0), rootLetters.charAt(1), rootLetters.charAt(2));
            if (augmentedRoot == null || augmentedRoot.getAugmentationList() == null || augmentedRoot.getAugmentationList().isEmpty()) {
                //System.err.println("No root or formulas for " + rootLetters);
                return;
            }
            for(var formula: augmentedRoot.getAugmentationList()){
                var nouns = augmentedTrilateralPassiveParticipleConjugator.createTimeAndPlaceNounList(augmentedRoot, formula.getFormulaNo(), new GenericNounSuffixContainer());
                var conjugationResult = passiveParticipleModifier.build(augmentedRoot, kov, formula.getFormulaNo(), nouns, () -> true);
                printFinalResultPipeSeparated(augmentedRoot, conjugationResult.getFinalResult(), formula);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void printGerund(String rootLetters){
        try {
            var augmentedRoot = sarfDictionary.getAugmentedTrilateralRoot(rootLetters);
            var kov = kovRulesManager.getTrilateralKov(rootLetters.charAt(0), rootLetters.charAt(1), rootLetters.charAt(2));
            if (augmentedRoot == null || augmentedRoot.getAugmentationList() == null || augmentedRoot.getAugmentationList().isEmpty()) {
                //System.err.println("No root or formulas for " + rootLetters);
                return;
            }
            for(var formula: augmentedRoot.getAugmentationList()){
                var nouns = gerundConjugator.createGerundList(augmentedRoot, formula.getFormulaNo(), new GenericNounSuffixContainer());
                var conjugationResult = trilateralAugmentedStandardModifier.build(augmentedRoot, kov, formula.getFormulaNo(), nouns, () -> true);
                printFinalResultPipeSeparated(augmentedRoot, conjugationResult.getFinalResult(), formula);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void printNomenGerund(String rootLetters){
        try {
            var augmentedRoot = sarfDictionary.getAugmentedTrilateralRoot(rootLetters);
            var kov = kovRulesManager.getTrilateralKov(rootLetters.charAt(0), rootLetters.charAt(1), rootLetters.charAt(2));
            if (augmentedRoot == null || augmentedRoot.getAugmentationList() == null || augmentedRoot.getAugmentationList().isEmpty()) {
                //System.err.println("No root or formulas for " + rootLetters);
                return;
            }
            for(var formula: augmentedRoot.getAugmentationList()){
                var nouns = nomenGerundConjugator.createGerundList(augmentedRoot, formula.getFormulaNo(), new GenericNounSuffixContainer());
                var conjugationResult = trilateralAugmentedStandardModifier.build(augmentedRoot, kov, formula.getFormulaNo(), nouns, () -> true);
                printFinalResultPipeSeparated(augmentedRoot, conjugationResult.getFinalResult(), formula);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void printMeemGerund(String rootLetters){
        try {
            var augmentedRoot = sarfDictionary.getAugmentedTrilateralRoot(rootLetters);
            var kov = kovRulesManager.getTrilateralKov(rootLetters.charAt(0), rootLetters.charAt(1), rootLetters.charAt(2));
            if (augmentedRoot == null || augmentedRoot.getAugmentationList() == null || augmentedRoot.getAugmentationList().isEmpty()) {
                //System.err.println("No root or formulas for " + rootLetters);
                return;
            }
            for(var formula: augmentedRoot.getAugmentationList()){
                var nouns = augmentedTrilateralPassiveParticipleConjugator.createMeemGerundNounList(augmentedRoot, formula.getFormulaNo(), new GenericNounSuffixContainer());
                var conjugationResult = passiveParticipleModifier.build(augmentedRoot, kov, formula.getFormulaNo(), nouns, () -> true);
                printFinalResultPipeSeparated(augmentedRoot, conjugationResult.getFinalResult(), formula);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void printFinalResultPipeSeparated(AugmentedTrilateralRoot root, List finalResult, AugmentationFormula augmentationFormula) {
        System.out.printf("| %c%c%c | %d |", root.getC1(), root.getC2(), root.getC3(), augmentationFormula.getFormulaNo());
        for (Object word : finalResult) {
            System.out.printf(" %s |", word == null ? "" : word);
        }
        System.out.println();
    }
}
