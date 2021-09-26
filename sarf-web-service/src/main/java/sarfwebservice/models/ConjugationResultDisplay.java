package sarfwebservice.models;

import sarf.ConjugationResult;

public class ConjugationResultDisplay {
    private ConjugationResult conjugationResult;
    private String display;
    private char transitivity;

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

    public char getTransitivity() {
        return transitivity;
    }

    public void setTransitivity(char transitivity) {
        this.transitivity = transitivity;
    }
}
