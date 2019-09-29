package sarftests.noun.tri.unaugmented;

import com.google.inject.Inject;
import sarf.noun.trilateral.unaugmented.elative.ElativeNounConjugator;
import sarf.noun.trilateral.unaugmented.elative.ElativeSuffixContainer;
import sarf.noun.trilateral.unaugmented.modifier.elative.ElativeModifier;
import sarftests.noun.INounProvider;
import sarftests.verb.tri.Common;

import java.util.ArrayList;
import java.util.List;

public class ElativeNounProvider implements INounProvider {

    private final Common common;
    private final ElativeNounConjugator elativeNounConjugator;
    private final ElativeModifier elativeModifier;

    @Inject
    public ElativeNounProvider(Common common, ElativeNounConjugator elativeNounConjugator, ElativeModifier elativeModifier){
        this.common = common;
        this.elativeNounConjugator = elativeNounConjugator;
        this.elativeModifier = elativeModifier;
    }

    @Override
    public List<String> getNouns(String rootLetters, String formula, int conjugation) {
        var root = common.createRoot(rootLetters, conjugation);
        var kov = common.getKindOfVerb(rootLetters);
        ElativeSuffixContainer.getInstance().selectAnnexedMode();
        var rawNouns = elativeNounConjugator.createNounList(root, formula);
        var finalResult = elativeModifier.build(root, kov, rawNouns, formula).getFinalResult();
        var result = new ArrayList<String>();

        for(var n : finalResult){
            if(n == null){
                result.add("");
                continue;
            }
            result.add(n.toString());
        }
        return result;
    }
}
