package sarfwebservice.sarf.bridges;

import sarf.KindOfVerb;
import sarf.WordPresenter;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;

import java.util.List;

public interface TrilateralUnaugmentedBridge {
    //active and passive verbs
    List<WordPresenter> retrieveActivePastConjugations(UnaugmentedTrilateralRoot root, KindOfVerb kov, boolean active);
    List<WordPresenter> retrieveActiveNominativePresent(UnaugmentedTrilateralRoot root, KindOfVerb kov, boolean active);
    List<WordPresenter> retrieveActiveAccusativePresent(UnaugmentedTrilateralRoot root, KindOfVerb kov, boolean active);
    List<WordPresenter> retrieveActiveJussivePresent(UnaugmentedTrilateralRoot root, KindOfVerb kov, boolean active);
    List<WordPresenter> retrieveActiveEmphasizedPresent(UnaugmentedTrilateralRoot root, KindOfVerb kov, boolean active);
    List<WordPresenter> retrieveImperative(UnaugmentedTrilateralRoot root, KindOfVerb kov);
    List<WordPresenter> retrieveEmphasizedImperative(UnaugmentedTrilateralRoot root, KindOfVerb kov);
}
