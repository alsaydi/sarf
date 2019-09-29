package sarftests.noun.tri.unaugmented;

import com.google.inject.Inject;
import sarf.noun.trilateral.unaugmented.UnaugmentedTrilateralPassiveParticipleConjugator;
import sarf.noun.trilateral.unaugmented.modifier.passiveparticiple.PassiveParticipleModifier;
import sarftests.noun.INounProvider;
import sarftests.verb.tri.Common;

import java.util.ArrayList;
import java.util.List;

public class PassiveParticipleNounProvider implements INounProvider {

    private final Common common;
    private final UnaugmentedTrilateralPassiveParticipleConjugator conjugator;
    private final PassiveParticipleModifier passiveParticipleModifier;

    @Inject
    public PassiveParticipleNounProvider(Common common, UnaugmentedTrilateralPassiveParticipleConjugator conjugator
    , sarf.noun.trilateral.unaugmented.modifier.passiveparticiple.PassiveParticipleModifier passiveParticipleModifier){
        this.common = common;
        this.conjugator = conjugator;
        this.passiveParticipleModifier = passiveParticipleModifier;
    }

    @Override
    public List<String> getNouns(String rootLetters, String formula, int conjugations) {
        var root = common.createRoot(rootLetters, conjugations);
        var rawNouns = this.conjugator.createNounList(root, null);
        var conjugationResult = this.passiveParticipleModifier.build(root, common.getKindOfVerb(rootLetters), rawNouns, null);
        var result = new ArrayList<String>();
        for(var n: conjugationResult.getFinalResult()){
            result.add(n.toString());
        }
        return result;
    }
}
