package sarftests.noun;

import java.util.List;

public interface INounProvider {
    List<String> getNouns(String rootLetters, String formula, int conjugation);
    default List<String> getNouns(String rootLetters, int conjugations){
        return getNouns(rootLetters, null, conjugations);
    }
}

