package sarfwebservice.models;

import java.util.List;

public class RootResult {
    private String root;
    private String kindOfVerb;
    private List<TriRootDisplay> unaugmentedRoots;
    private List<ConjugationResultDisplay> conjugationResults;

    public List<TriRootDisplay> getUnaugmentedRoots() {
        return unaugmentedRoots;
    }

    public List<ConjugationResultDisplay> getConjugationResults() {
        return conjugationResults;
    }

    public void setUnaugmentedRoots(List<TriRootDisplay> unaugmentedRoots) {
        this.unaugmentedRoots = unaugmentedRoots;
    }

    public void setConjugationResults(List<ConjugationResultDisplay> conjugationResults) {
        this.conjugationResults = conjugationResults;
    }

    public boolean isEmpty() {
        return unaugmentedRoots.isEmpty() && conjugationResults.isEmpty();
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getKindOfVerb() {
        return kindOfVerb;
    }

    public void setKindOfVerb(String kindOfVerb) {
        this.kindOfVerb = kindOfVerb;
    }
}
