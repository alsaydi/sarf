package sarftests.noun.tri.unaugmented;

import com.google.inject.Inject;
import sarf.noun.trilateral.unaugmented.modifier.timeandplace.TimeAndPlaceModifier;
import sarf.noun.trilateral.unaugmented.timeandplace.TimeAndPlaceConjugator;
import sarftests.noun.INounProvider;
import sarftests.verb.tri.Common;

import java.util.ArrayList;
import java.util.List;

public class TimeAndPlaceNounProvider implements INounProvider {

    private final Common common;
    private final TimeAndPlaceConjugator conjugator;
    private final TimeAndPlaceModifier modifier;

    @Inject
    public TimeAndPlaceNounProvider(Common common, TimeAndPlaceConjugator conjugator, TimeAndPlaceModifier modifier){
        this.common = common;
        this.conjugator = conjugator;
        this.modifier = modifier;
    }

    @Override
    public List<String> getNouns(String rootLetters, String formula, int conjugation) {
        var root = common.createRoot(rootLetters, conjugation);
        var kov = common.getKindOfVerb(rootLetters);
        var rawNouns = conjugator.createNounList(root, formula);
        if(rawNouns == null){
            return new ArrayList<String>();
        }
        var finalResult = modifier.build(root, kov, rawNouns, formula).getFinalResult();
        var result = new ArrayList<String>();
        for(Object n : finalResult){
            if(n == null){
                result.add("");
                continue;
            }
            result.add(n.toString());
        }
        return result;
    }
}
