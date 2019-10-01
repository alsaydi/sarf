package sarfwebservice.services;

import sarf.verb.Root;

import java.util.List;

public interface SarfService {
    List<? extends Root> getRoot(String rootLetters) throws Exception;
}
