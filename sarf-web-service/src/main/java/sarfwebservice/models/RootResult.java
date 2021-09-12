package sarfwebservice.models;

import sarf.ConjugationResult;
import sarf.verb.Root;

import java.util.List;

public class RootResult {
    private List<TriRootDisplay> unaugmentedRoots;
    private List<ConjugationResult> conjugationResults;

    public List<TriRootDisplay> getUnaugmentedRoots() {
        return unaugmentedRoots;
    }

    public void setUnaugmentedRoots(List<TriRootDisplay> unaugmentedRoots) {
        this.unaugmentedRoots = unaugmentedRoots;
    }

    public List<ConjugationResult> getConjugationResults() {
        return conjugationResults;
    }

    public void setConjugationResults(List<ConjugationResult> conjugationResults) {
        this.conjugationResults = conjugationResults;
    }

    public boolean isEmpty() {
        return unaugmentedRoots.isEmpty() && conjugationResults.isEmpty();
    }
}
