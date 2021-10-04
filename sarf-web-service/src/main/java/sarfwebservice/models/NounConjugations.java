package sarfwebservice.models;

import java.util.List;

public class NounConjugations {

    public static final String ACTIVE_PARTICIPLE_KEY = "فَاعِل";
    public static final String PASSIVE_PARTICIPLE_KEY = "مَفْعُول";

    private List<DerivedNounConjugation> activeParticiples;
    private List<DerivedNounConjugation> passiveParticiples;
    private List<DerivedNounConjugation> timeAndPlaceNouns;
    private List<DerivedNounConjugation> exaggeratedActiveParticiples;
    private List<DerivedNounConjugation> instrumentalNouns;
    private List<DerivedNounConjugation> elatives;

    public List<DerivedNounConjugation> getActiveParticiples() {
        return activeParticiples;
    }

    public void setActiveParticiples(List<DerivedNounConjugation> activeParticiples) {
        this.activeParticiples = activeParticiples;
    }

    public List<DerivedNounConjugation> getPassiveParticiples() {
        return passiveParticiples;
    }

    public void setPassiveParticiples(List<DerivedNounConjugation> passiveParticiples) {
        this.passiveParticiples = passiveParticiples;
    }

    public List<DerivedNounConjugation> getTimeAndPlaceNouns() {
        return timeAndPlaceNouns;
    }

    public void setTimeAndPlaceNouns(List<DerivedNounConjugation> timeAndPlaceNouns) {
        this.timeAndPlaceNouns = timeAndPlaceNouns;
    }

    public void setExaggeratedActiveParticiples(List<DerivedNounConjugation> exaggeratedActiveParticiples) {
        this.exaggeratedActiveParticiples = exaggeratedActiveParticiples;
    }

    public List<DerivedNounConjugation> getExaggeratedActiveParticiples() {
        return exaggeratedActiveParticiples;
    }

    public List<DerivedNounConjugation> getInstrumentalNouns() {
        return instrumentalNouns;
    }

    public void setInstrumentalNouns(List<DerivedNounConjugation> instrumentalNouns) {
        this.instrumentalNouns = instrumentalNouns;
    }

    public void setElatives(List<DerivedNounConjugation> elatives) {
        this.elatives = elatives;
    }

    public List<DerivedNounConjugation> getElatives() {
        return elatives;
    }
}
