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

public class GerundConjugations {

    public static final String ACTIVE_PARTICIPLE_KEY = "فَاعِل";
    public static final String PASSIVE_PARTICIPLE_KEY = "مَفْعُول";

    private List<DerivedNounConjugation> standards;
    private List<DerivedNounConjugation> meems;
    private List<DerivedNounConjugation> nomens;
    private List<DerivedNounConjugation> qualityGerunds;

    public List<DerivedNounConjugation> getQualityGerunds() {
        return qualityGerunds;
    }

    public void setQualityGerunds(List<DerivedNounConjugation> qualityGerunds) {
        this.qualityGerunds = qualityGerunds;
    }

    public List<DerivedNounConjugation> getNomens() {
        return nomens;
    }

    public void setNomens(List<DerivedNounConjugation> nomens) {
        this.nomens = nomens;
    }

    public List<DerivedNounConjugation> getMeems() {
        return meems;
    }

    public void setMeems(List<DerivedNounConjugation> meems) {
        this.meems = meems;
    }

    public List<DerivedNounConjugation> getStandards() {
        return standards;
    }

    public void setStandards(List<DerivedNounConjugation> standards) {
        this.standards = standards;
    }
}
