package sarfwebservice.models;

import java.util.List;

public class DerivedNounConjugation {
    private String key;
    private List<String> indefiniteNouns;
    private List<String> annexedNouns;
    private List<String> definiteNouns;

    public DerivedNounConjugation() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<String> getIndefiniteNouns() {
        return indefiniteNouns;
    }

    public void setIndefiniteNouns(List<String> indefiniteNouns) {
        this.indefiniteNouns = indefiniteNouns;
    }

    public List<String> getAnnexedNouns() {
        return annexedNouns;
    }

    public void setAnnexedNouns(List<String> annexedNouns) {
        this.annexedNouns = annexedNouns;
    }

    public List<String> getDefiniteNouns() {
        return definiteNouns;
    }

    public void setDefiniteNouns(List<String> definiteNouns) {
        this.definiteNouns = definiteNouns;
    }
}
