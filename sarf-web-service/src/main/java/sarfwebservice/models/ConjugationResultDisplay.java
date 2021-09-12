package sarfwebservice.models;

import sarf.ConjugationResult;

public class ConjugationResultDisplay {
    private ConjugationResult conjugationResult;
    private String display;

    public ConjugationResult getConjugationResult() {
        return conjugationResult;
    }

    public String getDisplay() {
        return display;
    }

    public void setConjugationResult(ConjugationResult conjugationResult) {
        this.conjugationResult = conjugationResult;
    }

    public void setDisplay(String display) {
        this.display = display;
    }
}
