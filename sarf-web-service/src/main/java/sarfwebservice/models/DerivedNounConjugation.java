package sarfwebservice.models;

import java.util.List;

public class DerivedNounConjugation {
    private String key;
    private List<String> indefiniteNouns;
    private List<String> definiteNouns;
    private List<String> annexedNouns;

    /* for elative nouns: يخص إسم التفضيل */
    private List<String> annexedToIndefinite;
    private List<String> annexedToDefinite;

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

    public List<String> getAnnexedToIndefinite() {
        return annexedToIndefinite;
    }

    public void setAnnexedToIndefinite(List<String> annexedToIndefinite) {
        this.annexedToIndefinite = annexedToIndefinite;
    }

    public List<String> getAnnexedToDefinite() {
        return annexedToDefinite;
    }

    public void setAnnexedToDefinite(List<String> annexedToDefinite) {
        this.annexedToDefinite = annexedToDefinite;
    }
}
