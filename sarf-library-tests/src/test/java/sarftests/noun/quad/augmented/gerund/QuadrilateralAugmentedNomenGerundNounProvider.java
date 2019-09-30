package sarftests.noun.quad.augmented.gerund;

import com.google.inject.Inject;
import sarf.SarfDictionary;
import sarf.gerund.modifier.quadrilateral.QuadrilateralStandardModifier;
import sarf.gerund.quadrilateral.augmented.nomen.QuadrilateralAugmentedNomenGerundConjugator;
import sarf.kov.KovRulesManager;
import sarftests.noun.INounProvider;

import java.util.ArrayList;
import java.util.List;

public class QuadrilateralAugmentedNomenGerundNounProvider implements INounProvider {

    private final SarfDictionary sarfDictionary;
    private final KovRulesManager kovRulesManager;
    private final QuadrilateralAugmentedNomenGerundConjugator conjugator;
    private final QuadrilateralStandardModifier modifier;

    @Inject
    public QuadrilateralAugmentedNomenGerundNounProvider(SarfDictionary sarfDictionary, KovRulesManager kovRulesManager
    , QuadrilateralAugmentedNomenGerundConjugator conjugator, QuadrilateralStandardModifier modifier){
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
    public List<String> getNouns(String rootLetters, int formula) {
        try {
            var root = sarfDictionary.getAugmentedQuadrilateralRoot(rootLetters);
            var kovRule = kovRulesManager.getQuadrilateralKovRule(root.getC1(), root.getC2(), root.getC3(), root.getC4());
            var nouns = conjugator.createGerundList(root, formula);
            var conjugationResult =  modifier.build(root, formula, kovRule.getKov(), nouns).getFinalResult();
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
