package sarfwebservice.sarf.bridges;

import sarf.KindOfVerb;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;
import sarfwebservice.models.DerivedNounConjugation;

import java.util.List;

public interface TrilateralAugmentedDerivedNounBridge {
    List<DerivedNounConjugation> getActiveParticiple(AugmentedTrilateralRoot root, KindOfVerb kov, int formulaNo);
    List<DerivedNounConjugation> getPassiveParticiple(AugmentedTrilateralRoot root, KindOfVerb kov, int formulaNo);
    List<DerivedNounConjugation> getTimeAndPlaceNouns(AugmentedTrilateralRoot root, KindOfVerb kov, int formulaNo);
}
