package sarftests.noun.tri.unaugmented.gerund;

import com.google.inject.Inject;
import sarf.gerund.modifier.trilateral.unaugmented.nomen.TrilateralUnaugmentedNomenModifier;
import sarf.gerund.trilateral.unaugmented.TrilateralUnaugmentedNomenGerundConjugator;
import sarftests.noun.INounProvider;
import sarftests.verb.tri.Common;

import java.util.ArrayList;
import java.util.List;

public class NomenGerundNounProvider implements INounProvider {

    private final Common common;
    private final TrilateralUnaugmentedNomenGerundConjugator conjugator;
    private final TrilateralUnaugmentedNomenModifier modifier;

    @Inject
    public NomenGerundNounProvider(Common common, TrilateralUnaugmentedNomenGerundConjugator conjugator
    , TrilateralUnaugmentedNomenModifier modifier){
        this.common = common;
        this.conjugator = conjugator;
        this.modifier = modifier;
    }

    @Override
    public List<String> getNouns(String rootLetters, String formula, int conjugation) {
        var root = common.createRoot(rootLetters, conjugation);
        var kov = common.getKindOfVerb(rootLetters);
        var rawNouns = conjugator.createGerundList(root, formula);
        var conjugationResult = modifier.build(root, kov, rawNouns, formula).getFinalResult();
        var result = new ArrayList<String>();
        for (var g : conjugationResult) {
            if (g == null) {
                result.add("");
                continue;
            }
            result.add(g.toString());
        }
        return result;
    }
}
