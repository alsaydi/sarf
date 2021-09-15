package sarfwebservice.services;

import sarfwebservice.models.RootResult;

import java.util.List;

public interface SarfServiceQuad extends SarfService {
    List<RootResult> getRoots(String rootLetters) throws Exception;
}
