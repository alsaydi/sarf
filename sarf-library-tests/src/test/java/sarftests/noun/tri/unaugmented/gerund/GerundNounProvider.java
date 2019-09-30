package sarftests.noun.tri.unaugmented.gerund;

import com.google.inject.Inject;
import sarf.gerund.modifier.trilateral.unaugmented.standard.UnaugmentedTrilateralStandardGerundModifier;
import sarf.gerund.trilateral.unaugmented.TrilateralUnaugmentedGerundConjugator;
import sarftests.noun.INounProvider;
import sarftests.verb.tri.Common;

import java.util.ArrayList;
import java.util.List;

public class GerundNounProvider implements INounProvider {

    private final Common common;
    private final TrilateralUnaugmentedGerundConjugator conjugator;
    private final UnaugmentedTrilateralStandardGerundModifier modifier;

    @Inject
    public GerundNounProvider(Common common, TrilateralUnaugmentedGerundConjugator conjugator
            , UnaugmentedTrilateralStandardGerundModifier modifier) {
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
