package sarfwebservice.models;
/*
 *
 * MIT License
 *
 * Copyright (c) 2021 Abdalaziz Alsaydi
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
import java.util.List;

public class NounConjugations {

    public static final String ACTIVE_PARTICIPLE_KEY_TRI = "فَاعِل";
    public static final String PASSIVE_PARTICIPLE_KEY_TRI = "مَفْعُول";

    public static final String ACTIVE_PARTICIPLE_KEY_QUAD = "مفعلل";
    public static final String PASSIVE_PARTICIPLE_KEY_QUAD = "مفعلَل";

    private List<DerivedNounConjugation> activeParticiples;
    private List<DerivedNounConjugation> passiveParticiples;
    private List<DerivedNounConjugation> timeAndPlaceNouns;
    private List<DerivedNounConjugation> exaggeratedActiveParticiples;
    private List<DerivedNounConjugation> instrumentalNouns;
    private List<DerivedNounConjugation> elatives;
    private List<DerivedNounConjugation> assimilates;

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

    public void setAssimilates(List<DerivedNounConjugation> assimilates) {
        this.assimilates = assimilates;
    }

    public List<DerivedNounConjugation> getAssimilates() {
        return assimilates;
    }
}
