package sarfwebservice.services;

import sarfwebservice.models.RootResult;

public interface SarfServiceQuad extends SarfService {
    RootResult getRoots(String rootLetters) throws Exception;
}
