package sarfwebservice.sarf.bridges;

import sarf.KindOfVerb;
import sarf.WordPresenter;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;

import java.util.List;

public interface TrilateralUnaugmentedDerivedNounBridge {
    List<WordPresenter> getActiveParticiple(UnaugmentedTrilateralRoot root, KindOfVerb kov);
}
