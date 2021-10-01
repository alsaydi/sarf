package sarfwebservice.sarf.bridges;

import sarf.WordPresenter;

import java.util.List;

public interface TrilateralAugmentedBridge {
    List<WordPresenter> retrievePastConjugations(String rootLetters, int formulaNo, boolean active) throws Exception;
    List<WordPresenter> retrieveNominativePresent(String rootLetters, int formulaNo, boolean active) throws Exception;
    List<WordPresenter> retrieveAccusativePresent(String rootLetters, int formulaNo, boolean active) throws Exception;
    List<WordPresenter> retrieveJussivePresent(String rootLetters, int formulaNo, boolean active) throws Exception;
    List<WordPresenter> retrieveEmphasizedPresent(String rootLetters, int formulaNo, boolean active) throws Exception;
    List<WordPresenter> retrieveImperative(String rootLetters, int formulaNo) throws Exception;
    List<WordPresenter> retrieveEmphasizedImperative(String rootLetters, int formulaNo) throws Exception;
}
