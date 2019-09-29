package sarftests.noun.quad.unaugmented;

import com.google.inject.Inject;
import sarf.SarfDictionary;
import sarf.kov.KovRulesManager;
import sarf.noun.quadriliteral.modifier.activeparticiple.ActiveParticipleModifier;
import sarf.noun.quadriliteral.unaugmented.UnaugmentedQuadrilateralActiveParticipleConjugator;
import sarftests.noun.INounProvider;

import java.util.ArrayList;
import java.util.List;

public class QuadrilateralUnaugmentedActiveParticipleNounProvider implements INounProvider {

    private final SarfDictionary sarfDictionary;
    private final KovRulesManager kovRulesManager;
    private final UnaugmentedQuadrilateralActiveParticipleConjugator conjugator;
    private final ActiveParticipleModifier modifier;

    @Inject
    public QuadrilateralUnaugmentedActiveParticipleNounProvider(SarfDictionary sarfDictionary, KovRulesManager kovRulesManager
    , UnaugmentedQuadrilateralActiveParticipleConjugator conjugator, ActiveParticipleModifier modifier){
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
            var nouns = conjugator.createNounList(root);

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
