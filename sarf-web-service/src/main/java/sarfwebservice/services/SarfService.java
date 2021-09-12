package sarfwebservice.services;

import sarfwebservice.models.RootResult;

public interface SarfService {
    boolean isArabic(String letters);
    RootResult getRoots(String rootLetters) throws Exception;
}
