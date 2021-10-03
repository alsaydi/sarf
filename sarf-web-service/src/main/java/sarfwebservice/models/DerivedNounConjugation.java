package sarfwebservice.models;

import java.util.List;

public class DerivedNounConjugation {
    private String key;
    private List<String> nouns;

    public DerivedNounConjugation() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<String> getNouns() {
        return nouns;
    }

    public void setNouns(List<String> nouns) {
        this.nouns = nouns;
    }
}
