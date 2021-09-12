package sarfwebservice.models;

import sarf.ConjugationResult;
import sarf.verb.Root;

import java.util.List;

public class RootResult {
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
}
