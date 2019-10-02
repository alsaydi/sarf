package sarfwebservice.services;

import sarf.verb.Root;

import java.util.List;

public interface SarfService {
    boolean isArabic(String letters);
    List<? extends Root> getRoot(String rootLetters) throws Exception;
}
