package sarftests.noun.tri.augmented;

import com.google.inject.Inject;
import sarf.SarfDictionary;
import sarf.noun.GenericNounSuffixContainer;
import sarf.noun.trilateral.augmented.AugmentedTrilateralPassiveParticipleConjugator;
import sarf.noun.trilateral.augmented.modifier.passiveparticiple.PassiveParticipleModifier;
import sarftests.noun.INounProvider;
import sarftests.verb.tri.Common;

import java.util.ArrayList;
import java.util.List;

public class AugmentedPassiveParticipleNounProvider implements INounProvider {

    private final SarfDictionary sarfDictionary;
    private final AugmentedTrilateralPassiveParticipleConjugator conjugator;
    private final PassiveParticipleModifier modifier;
    private final Common common;

    @Inject
    public AugmentedPassiveParticipleNounProvider(SarfDictionary sarfDictionary
            , AugmentedTrilateralPassiveParticipleConjugator conjugator
            , PassiveParticipleModifier modifier, Common common) {
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
            var nouns = conjugator.createNounList(augmentedRoot, formula, new GenericNounSuffixContainer());
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
