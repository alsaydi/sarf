package sarfwebservice.models;

import java.util.List;

public class NounConjugations {

    private List<DerivedNounConjugation> activeParticiples;

    public List<DerivedNounConjugation> getActiveParticiples() {
        return activeParticiples;
    }

    public void setActiveParticiples(List<DerivedNounConjugation> activeParticiples) {
        this.activeParticiples = activeParticiples;
    }
}
