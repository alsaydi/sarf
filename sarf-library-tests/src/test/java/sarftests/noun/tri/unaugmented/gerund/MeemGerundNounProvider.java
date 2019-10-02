package sarftests.noun.tri.unaugmented.gerund;

import com.google.inject.Inject;
import sarf.gerund.modifier.trilateral.unaugmented.meem.TrilateralUnaugmentedMeemModifier;
import sarf.gerund.trilateral.unaugmented.meem.MeemGerundConjugator;
import sarftests.noun.INounProvider;
import sarftests.verb.tri.Common;

import java.util.ArrayList;
import java.util.List;

public class MeemGerundNounProvider implements INounProvider {

    private final Common common;
    private final MeemGerundConjugator conjugator;
    private final TrilateralUnaugmentedMeemModifier modifier;

    @Inject
    public MeemGerundNounProvider(Common common, MeemGerundConjugator conjugator, TrilateralUnaugmentedMeemModifier modifier){

        this.common = common;
        this.conjugator = conjugator;
        this.modifier = modifier;
    }

    @Override
    public List<String> getNouns(String rootLetters, String formula, int conjugation) {
        var root = common.createRoot(rootLetters, conjugation);
        var kov = common.getKindOfVerb(rootLetters);
        try {
            var obj = conjugator.getAppliedFormulaList(root);
            if(obj == null) return new ArrayList<>();
        } catch (Exception e) {
            e.printStackTrace();
        }
        var rawNouns = conjugator.createGerundList(root, formula);
        var conjugationResult =  modifier.build(root, kov, rawNouns, formula).getFinalResult();
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
