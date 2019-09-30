package sarftests.noun.tri.unaugmented.gerund;

import com.google.inject.Inject;
import sarf.gerund.modifier.trilateral.unaugmented.quality.TrilateralUnaugmentedQualityModifier;
import sarf.gerund.trilateral.unaugmented.QualityGerundConjugator;
import sarftests.noun.INounProvider;
import sarftests.verb.tri.Common;

import java.util.ArrayList;
import java.util.List;

public class QualityGerundNounProvider implements INounProvider {

    private final Common common;
    private final QualityGerundConjugator conjugator;
    private final TrilateralUnaugmentedQualityModifier modifier;

    @Inject
    public QualityGerundNounProvider(Common common, QualityGerundConjugator conjugator, TrilateralUnaugmentedQualityModifier modifier){
        this.common = common;
        this.conjugator = conjugator;
        this.modifier = modifier;
    }

    @Override
    public List<String> getNouns(String rootLetters, String formula, int conjugation) {
        var root = common.createRoot(rootLetters, conjugation);
        var kov = common.getKindOfVerb(rootLetters);
        var rawNouns = conjugator.createGerundList(root, null);
        var conjugationResult = modifier.build(root, kov, rawNouns, null).getFinalResult();
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
