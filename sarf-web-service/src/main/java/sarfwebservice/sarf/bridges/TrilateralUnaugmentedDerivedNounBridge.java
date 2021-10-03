package sarfwebservice.sarf.bridges;

import sarf.KindOfVerb;
import sarf.WordPresenter;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;
import sarfwebservice.models.DerivedNounConjugation;

import java.util.List;

public interface TrilateralUnaugmentedDerivedNounBridge {
    List<List<WordPresenter>> getActiveParticiple(UnaugmentedTrilateralRoot root, KindOfVerb kov);
    List<List<WordPresenter>> getPassiveParticiple(UnaugmentedTrilateralRoot root, KindOfVerb kov);
    List<DerivedNounConjugation> getTimeAndPlaceNouns(UnaugmentedTrilateralRoot root, KindOfVerb kov);
}
