package sarfwebservice.sarf.bridges;

import sarf.KindOfVerb;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;
import sarfwebservice.models.DerivedNounConjugation;

import java.util.List;

public interface TrilateralUnaugmentedDerivedNounBridge {
    List<DerivedNounConjugation> getActiveParticiple(UnaugmentedTrilateralRoot root, KindOfVerb kov);
    List<DerivedNounConjugation> getPassiveParticiple(UnaugmentedTrilateralRoot root, KindOfVerb kov);
    List<DerivedNounConjugation> getTimeAndPlaceNouns(UnaugmentedTrilateralRoot root, KindOfVerb kov);

    List<DerivedNounConjugation> getExaggeratedActiveParticiples(UnaugmentedTrilateralRoot root, KindOfVerb kov);

    List<DerivedNounConjugation> getInstrumentalNouns(UnaugmentedTrilateralRoot root, KindOfVerb kov);
    List<DerivedNounConjugation> getElatives(UnaugmentedTrilateralRoot root, KindOfVerb kov);
}
