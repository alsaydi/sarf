package sarfwebservice.services;

import sarfwebservice.models.RootResult;
import sarfwebservice.models.VerbConjugations;

import java.util.List;

public interface SarfServiceTri extends SarfService {
    List<RootResult> getRoots(String rootLetters) throws Exception;

    VerbConjugations getActiveVerbConjugationsTri(String rootLetters, boolean augmented, int cclass, int formula) throws Exception;

    VerbConjugations getPassiveVerbConjugationsTri(String rootLetters, boolean augmented, int cclass, int formula) throws Exception;
}
