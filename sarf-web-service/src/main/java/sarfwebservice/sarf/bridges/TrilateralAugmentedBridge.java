package sarfwebservice.sarf.bridges;

import sarf.WordPresenter;

import java.util.List;

public interface TrilateralAugmentedBridge {
    List<WordPresenter> retrieveActivePastConjugations(String rootLetters, int formulaNo) throws Exception;
    List<WordPresenter> retrieveActiveNominativePresent(String rootLetters, int formulaNo) throws Exception;
    List<WordPresenter> retrieveActiveAccusativePresent(String rootLetters, int formulaNo) throws Exception;
    List<WordPresenter> retrieveActiveJussivePresent(String rootLetters, int formulaNo) throws Exception;
    List<WordPresenter> retrieveActiveEmphasizedPresent(String rootLetters, int formulaNo) throws Exception;
    List<WordPresenter> retrieveImperative(String rootLetters, int formulaNo) throws Exception;
    List<WordPresenter> retrieveEmphasizedImperative(String rootLetters, int formulaNo) throws Exception;
}
