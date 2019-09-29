package sarftests.noun.quad.unaugmented.gerund;

import com.google.inject.Inject;
import sarf.SarfDictionary;
import sarf.gerund.modifier.quadrilateral.QuadrilateralStandardModifier;
import sarf.gerund.quadrilateral.unaugmented.QuadrilateralUnaugmentedGerundConjugator;
import sarf.kov.KovRulesManager;
import sarftests.noun.INounProvider;

import java.util.ArrayList;
import java.util.List;

public class QuadrilateralUnaugmentedGerundNounProvider implements INounProvider {

    private final SarfDictionary sarfDictionary;
    private final KovRulesManager kovRulesManager;
    private final QuadrilateralUnaugmentedGerundConjugator conjugator;
    private final QuadrilateralStandardModifier modifier;

    @Inject
    public QuadrilateralUnaugmentedGerundNounProvider(SarfDictionary sarfDictionary, KovRulesManager kovRulesManager
    , QuadrilateralUnaugmentedGerundConjugator conjugator, QuadrilateralStandardModifier modifier){
        this.sarfDictionary = sarfDictionary;
        this.kovRulesManager = kovRulesManager;
        this.conjugator = conjugator;
        this.modifier = modifier;
    }

    @Override
    public List<String> getNouns(String rootLetters, String formula, int conjugation) {
        return null;
    }

    @Override
    public List<String> getNouns(String rootLetters, int conjugations) {
        try {
            var root = sarfDictionary.getUnaugmentedQuadrilateralRoot(rootLetters);
            var kovRule = kovRulesManager.getQuadrilateralKovRule(root.getC1(), root.getC2(), root.getC3(), root.getC4());
            conjugator.setListener(() -> 1);
            List nouns; //TODO: fix the typing in the modifier build function so we don't have to do this trick.
            nouns = conjugator.createGerundList(root);

            var conjugationResult =  modifier.build(root, 0, kovRule.getKov(), nouns).getFinalResult();
            var result = new ArrayList<String>();
            for(var n : conjugationResult){
                result.add(n.toString());
            }
            return result;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
