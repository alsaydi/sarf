package sarftests.noun.tri.unaugmented;

import com.google.inject.Inject;
import sarf.noun.trilateral.unaugmented.assimilate.AssimilateAdjectiveConjugator;
import sarf.noun.trilateral.unaugmented.modifier.assimilate.AssimilateModifier;
import sarftests.noun.INounProvider;
import sarftests.verb.tri.Common;

import java.util.ArrayList;
import java.util.List;

public class AssimilateNounProvider implements INounProvider {

    private final Common common;
    private final AssimilateAdjectiveConjugator conjugator;
    private final AssimilateModifier modifier;

    @Inject
    public AssimilateNounProvider(Common common, AssimilateAdjectiveConjugator conjugator, AssimilateModifier modifier) {
        this.common = common;
        this.conjugator = conjugator;
        this.modifier = modifier;
    }

    @Override
    public List<String> getNouns(String rootLetters, String formula, int conjugation) {
        var root = common.createRoot(rootLetters, conjugation);
        var kov = common.getKindOfVerb(rootLetters);
        var rawNouns = conjugator.createNounList(root, formula);
        var finalResult = modifier.build(root, kov, rawNouns, formula).getFinalResult();
        var result = new ArrayList<String>();

        for (var n : finalResult) {
            if (n == null) {
                result.add("");
                continue;
            }
            result.add(n.toString());
        }
        return result;
    }
}
