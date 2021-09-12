package sarfwebservice.services;

import sarfwebservice.models.RootResult;

public interface SarfServiceTri extends SarfService {
    RootResult getRoots(String rootLetters) throws Exception;
}
