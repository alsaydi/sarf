package sarf.ui.testhelpers;

import com.google.inject.Inject;
import sarf.SarfDictionary;
import sarf.SystemConstants;
import sarf.gerund.modifier.quadrilateral.QuadrilateralStandardModifier;
import sarf.gerund.quadrilateral.unaugmented.QuadrilateralUnaugmentedGerundConjugator;
import sarf.kov.KovRulesManager;
import sarf.noun.quadriliteral.modifier.activeparticiple.ActiveParticipleModifier;
import sarf.noun.quadriliteral.modifier.passiveparticiple.PassiveParticipleModifier;
import sarf.noun.quadriliteral.unaugmented.UnaugmentedQuadrilateralActiveParticipleConjugator;
import sarf.noun.quadriliteral.unaugmented.UnaugmentedQuadrilateralPassiveParticipleConjugator;
import sarf.verb.quadriliteral.QuadrilateralRoot;
import sarf.verb.quadriliteral.modifier.QuadrilateralModifier;
import sarf.verb.quadriliteral.unaugmented.UnaugmentedImperativeConjugator;
import sarf.verb.quadriliteral.unaugmented.active.ActivePresentConjugator;
import sarf.verb.quadriliteral.unaugmented.active.QuadriActivePastConjugator;
import sarf.verb.quadriliteral.unaugmented.passive.PassivePresentConjugator;
import sarf.verb.quadriliteral.unaugmented.passive.QuadriUnaugmentedPassivePastConjugator;

import java.util.List;

public class QuadrilateralUnaugmentedHelper {

    private final SarfDictionary sarfDictionary;
    private final KovRulesManager kovRulesManager;
    private final QuadriActivePastConjugator quadriActivePastConjugator;
    private final QuadriUnaugmentedPassivePastConjugator quadriPassivePastConjugator;
    private final UnaugmentedQuadrilateralActiveParticipleConjugator activeParticipleConjugator;
    private final ActiveParticipleModifier activeParticipleModifier;

    private final UnaugmentedQuadrilateralPassiveParticipleConjugator passiveParticipleConjugator;
    private final PassiveParticipleModifier passiveParticipleModifier;
    private final QuadrilateralUnaugmentedGerundConjugator gerundConjugator;
    private final QuadrilateralStandardModifier standardModifier;

    @Inject
    public QuadrilateralUnaugmentedHelper(SarfDictionary sarfDictionary
            , KovRulesManager kovRulesManager
            , QuadriActivePastConjugator quadriActivePastConjugator
            , QuadriUnaugmentedPassivePastConjugator quadriPassivePastConjugator
            , UnaugmentedQuadrilateralActiveParticipleConjugator activeParticipleConjugator
            , ActiveParticipleModifier activeParticipleModifier
            , UnaugmentedQuadrilateralPassiveParticipleConjugator passiveParticipleConjugator
            , PassiveParticipleModifier passiveParticipleModifier
            , QuadrilateralUnaugmentedGerundConjugator gerundConjugator
            , QuadrilateralStandardModifier standardModifier){
        this.sarfDictionary = sarfDictionary;
        this.kovRulesManager = kovRulesManager;
        this.quadriActivePastConjugator = quadriActivePastConjugator;
        this.quadriPassivePastConjugator = quadriPassivePastConjugator;
        this.activeParticipleConjugator = activeParticipleConjugator;
        this.activeParticipleModifier = activeParticipleModifier;
        this.passiveParticipleConjugator = passiveParticipleConjugator;
        this.passiveParticipleModifier = passiveParticipleModifier;
        this.gerundConjugator = gerundConjugator;
        this.standardModifier = standardModifier;
    }

    public void printPastActive(String rootLetters){
        try {
            var root = sarfDictionary.getUnaugmentedQuadrilateralRoot(rootLetters);
            var kovRule = kovRulesManager.getQuadrilateralKovRule(root.getC1(), root.getC2(), root.getC3(), root.getC4());
            var verbs = quadriActivePastConjugator.createVerbList(root);

            var conjugationResult = QuadrilateralModifier.getInstance().build(root, 0,  kovRule.getKov(), verbs, SystemConstants.PAST_TENSE, true, true)
                    .getFinalResult();
            printFinalResultPipeSeparated(root, conjugationResult);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void printPresentActive(String rootLetters){
        try {
            var root = sarfDictionary.getUnaugmentedQuadrilateralRoot(rootLetters);
            var kovRule = kovRulesManager.getQuadrilateralKovRule(root.getC1(), root.getC2(), root.getC3(), root.getC4());
            var verbs = ActivePresentConjugator.getInstance().createEmphasizedVerbList(root);

            var conjugationResult = QuadrilateralModifier.getInstance().build(root, 0,  kovRule.getKov(), verbs, SystemConstants.PRESENT_TENSE, true, true)
                    .getFinalResult();
            printFinalResultPipeSeparated(root, conjugationResult);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void printImperative(String rootLetters){
        try {
            var root = sarfDictionary.getUnaugmentedQuadrilateralRoot(rootLetters);
            var kovRule = kovRulesManager.getQuadrilateralKovRule(root.getC1(), root.getC2(), root.getC3(), root.getC4());
            var verbs = UnaugmentedImperativeConjugator.getInstance().createEmphasizedVerbList(root);

            var conjugationResult = QuadrilateralModifier.getInstance().build(root, 0,  kovRule.getKov(), verbs, SystemConstants.PRESENT_TENSE, true, true)
                    .getFinalResult();
            printFinalResultPipeSeparated(root, conjugationResult);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void printPassivePast(String rootLetters){
        try {
            var root = sarfDictionary.getUnaugmentedQuadrilateralRoot(rootLetters);
            var kovRule = kovRulesManager.getQuadrilateralKovRule(root.getC1(), root.getC2(), root.getC3(), root.getC4());
            var verbs = quadriPassivePastConjugator.createVerbList(root);

            var conjugationResult = QuadrilateralModifier.getInstance().build(root, 0,  kovRule.getKov(), verbs, SystemConstants.PAST_TENSE
                    , false
                    , true)
                    .getFinalResult();
            printFinalResultPipeSeparated(root, conjugationResult);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void printPassivePresent(String rootLetters){
        try {
            var root = sarfDictionary.getUnaugmentedQuadrilateralRoot(rootLetters);
            var kovRule = kovRulesManager.getQuadrilateralKovRule(root.getC1(), root.getC2(), root.getC3(), root.getC4());
            var verbs = PassivePresentConjugator.getInstance().createEmphasizedVerbList(root);

            var conjugationResult = QuadrilateralModifier.getInstance().build(root, 0,  kovRule.getKov()
                    , verbs, SystemConstants.PRESENT_TENSE
                    , false
                    , true)
                    .getFinalResult();
            printFinalResultPipeSeparated(root, conjugationResult);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void printActiveParticiple(String rootLetters){
        try {
            var root = sarfDictionary.getUnaugmentedQuadrilateralRoot(rootLetters);
            var kovRule = kovRulesManager.getQuadrilateralKovRule(root.getC1(), root.getC2(), root.getC3(), root.getC4());
            List nouns; //TODO: fix the typing in the modifier build function so we don't have to do this trick.
            nouns = activeParticipleConjugator.createNounList(root);

            var conjugationResult =  activeParticipleModifier.build(root, 0, kovRule.getKov(), nouns).getFinalResult();
            printFinalResultPipeSeparated(root, conjugationResult);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void printPassiveParticiple(String rootLetters){
        try {
            var root = sarfDictionary.getUnaugmentedQuadrilateralRoot(rootLetters);
            var kovRule = kovRulesManager.getQuadrilateralKovRule(root.getC1(), root.getC2(), root.getC3(), root.getC4());
            List nouns; //TODO: fix the typing in the modifier build function so we don't have to do this trick.
            nouns = passiveParticipleConjugator.createNounList(root);

            var conjugationResult =  passiveParticipleModifier.build(root, 0, kovRule.getKov(), nouns).getFinalResult();
            printFinalResultPipeSeparated(root, conjugationResult);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void printTimeAndPlace(String rootLetters){
        try {
            var root = sarfDictionary.getUnaugmentedQuadrilateralRoot(rootLetters);
            var kovRule = kovRulesManager.getQuadrilateralKovRule(root.getC1(), root.getC2(), root.getC3(), root.getC4());
            List nouns; //TODO: fix the typing in the modifier build function so we don't have to do this trick.
            nouns = passiveParticipleConjugator.createTimeAndPlaceNounList(root);

            var conjugationResult =  passiveParticipleModifier.build(root, 0, kovRule.getKov(), nouns).getFinalResult();
            printFinalResultPipeSeparated(root, conjugationResult);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void printGerund(String rootLetters){
        try {
            var root = sarfDictionary.getUnaugmentedQuadrilateralRoot(rootLetters);
            var kovRule = kovRulesManager.getQuadrilateralKovRule(root.getC1(), root.getC2(), root.getC3(), root.getC4());
            gerundConjugator.setListener(() -> 1);
            List nouns; //TODO: fix the typing in the modifier build function so we don't have to do this trick.
            nouns = gerundConjugator.createGerundList(root);

            var conjugationResult =  standardModifier.build(root, 0, kovRule.getKov(), nouns).getFinalResult();
            printFinalResultPipeSeparated(root, conjugationResult);
        }catch (Exception e){
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
