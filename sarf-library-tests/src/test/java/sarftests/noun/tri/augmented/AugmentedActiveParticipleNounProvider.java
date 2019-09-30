package sarftests.noun.tri.augmented;

import com.google.inject.Inject;
import sarf.SarfDictionary;
import sarf.noun.trilateral.augmented.AugmentedTrilateralActiveParticipleConjugator;
import sarf.noun.trilateral.augmented.modifier.activeparticiple.ActiveParticipleModifier;
import sarftests.noun.INounProvider;
import sarftests.verb.tri.Common;

import java.util.ArrayList;
import java.util.List;

public class AugmentedActiveParticipleNounProvider implements INounProvider {

    private final SarfDictionary sarfDictionary;
    private final AugmentedTrilateralActiveParticipleConjugator conjugator;
    private final ActiveParticipleModifier modifier;
    private final Common common;

    @Inject
    public AugmentedActiveParticipleNounProvider(SarfDictionary sarfDictionary
            , AugmentedTrilateralActiveParticipleConjugator conjugator
            , ActiveParticipleModifier modifier, Common common) {
        this.sarfDictionary = sarfDictionary;
        this.conjugator = conjugator;
        this.modifier = modifier;
        this.common = common;
    }

    @Override
    public List<String> getNouns(String rootLetters, String formula, int conjugation) {
        return null;
    }

    @Override
    public List<String> getNouns(String rootLetters, int formula) {
        try {
            var augmentedRoot = sarfDictionary.getAugmentedTrilateralRoot(rootLetters);
            var kov = common.getKindOfVerb(rootLetters);
            var nouns = conjugator.createNounList(augmentedRoot, formula);
            var conjugationResult = modifier.build(augmentedRoot, kov, formula, nouns, () -> true).getFinalResult();
            var result = new ArrayList<String>();

            for (var n : conjugationResult) {
                result.add(n.toString());
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
