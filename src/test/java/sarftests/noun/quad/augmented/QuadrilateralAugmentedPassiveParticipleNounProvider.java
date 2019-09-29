package sarftests.noun.quad.augmented;

import com.google.inject.Inject;
import sarf.SarfDictionary;
import sarf.kov.KovRulesManager;
import sarf.noun.quadriliteral.augmented.AugmentedQuadrilateralPassiveParticipleConjugator;
import sarf.noun.quadriliteral.modifier.passiveparticiple.PassiveParticipleModifier;
import sarftests.noun.INounProvider;

import java.util.ArrayList;
import java.util.List;

public class QuadrilateralAugmentedPassiveParticipleNounProvider implements INounProvider {

    private final SarfDictionary sarfDictionary;
    private final KovRulesManager kovRulesManager;
    private final AugmentedQuadrilateralPassiveParticipleConjugator conjugator;
    private final PassiveParticipleModifier modifier;

    @Inject
    public QuadrilateralAugmentedPassiveParticipleNounProvider(SarfDictionary sarfDictionary, KovRulesManager kovRulesManager
    , AugmentedQuadrilateralPassiveParticipleConjugator conjugator, PassiveParticipleModifier modifier){
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
            List nouns; //TODO: fix the typing in the modifier build function so we don't have to do this trick.
            nouns = conjugator.createNounList(root, formula);

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
