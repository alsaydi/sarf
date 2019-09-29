package sarftests.noun.tri.unaugmented;

import com.google.inject.Inject;
import sarf.noun.trilateral.unaugmented.UnaugmentedTrilateralActiveParticipleConjugator;
import sarf.noun.trilateral.unaugmented.modifier.activeparticiple.ActiveParticipleModifier;
import sarftests.noun.INounProvider;
import sarftests.verb.tri.Common;

import java.util.ArrayList;
import java.util.List;

public class ActiveParticipleNounProvider implements INounProvider {

    private final Common common;
    private final UnaugmentedTrilateralActiveParticipleConjugator unaugmentedTrilateralActiveParticipleConjugator;
    private final ActiveParticipleModifier activeParticipleModifier;

    @Inject
    public ActiveParticipleNounProvider(Common common, UnaugmentedTrilateralActiveParticipleConjugator unaugmentedTrilateralActiveParticipleConjugator
    , ActiveParticipleModifier activeParticipleModifier){
        this.common = common;
        this.unaugmentedTrilateralActiveParticipleConjugator = unaugmentedTrilateralActiveParticipleConjugator;
        this.activeParticipleModifier = activeParticipleModifier;
    }

    @Override
    public List<String> getNouns(String rootLetters, String formula, int conjugation) {
        var kov = common.getKindOfVerb(rootLetters);
        var root = common.createRoot(rootLetters, conjugation);
        var rawNouns = unaugmentedTrilateralActiveParticipleConjugator.createNounList(root, null); /* there is only one formula */
        var conjugationResult = activeParticipleModifier.build(root, kov, rawNouns, null  );
        var nouns = new ArrayList<String>();
        for(var n : conjugationResult.getFinalResult()){
            nouns.add(n.toString());
        }
        return nouns;
    }
}
