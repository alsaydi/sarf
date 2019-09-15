package sarf.ui.testhelpers;

import com.google.inject.Inject;
import sarf.SarfDictionary;
import sarf.SystemConstants;
import sarf.kov.KovRulesManager;
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

    @Inject
    public QuadrilateralUnaugmentedHelper(SarfDictionary sarfDictionary, KovRulesManager kovRulesManager
            , QuadriActivePastConjugator quadriActivePastConjugator, QuadriUnaugmentedPassivePastConjugator quadriPassivePastConjugator
            ){
        this.sarfDictionary = sarfDictionary;
        this.kovRulesManager = kovRulesManager;
        this.quadriActivePastConjugator = quadriActivePastConjugator;
        this.quadriPassivePastConjugator = quadriPassivePastConjugator;
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
            var verbs = PassivePresentConjugator.getInstance().createNominativeVerbList(root);

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

    private static void printFinalResultPipeSeparated(QuadrilateralRoot root, List finalResult) {
        System.out.printf("| %c%c%c%c |", root.getC1(), root.getC2(), root.getC3(), root.getC4());
        for (Object word : finalResult) {
            System.out.printf(" %s |", word == null ? "" : word);
        }
        System.out.println("");
    }
}
