package models;/*
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

public class DerivedNounResult {
    private List<Noun> activeParticiples;
    private List<Noun> passiveParticiples;
    private List<Noun> timeAndPlaceNouns;
    private List<Noun> exaggeratedActiveParticiples;
    private List<Noun> instrumentalNouns;
    private List<Noun> elatives;
    private List<Noun> assimilates;

    public List<Noun> getActiveParticiples() {
        return activeParticiples;
    }

    public void setActiveParticiples(List<Noun> activeParticiples) {
        this.activeParticiples = activeParticiples;
    }

    public List<Noun> getPassiveParticiples() {
        return passiveParticiples;
    }

    public void setPassiveParticiples(List<Noun> passiveParticiples) {
        this.passiveParticiples = passiveParticiples;
    }

    public List<Noun> getTimeAndPlaceNouns() {
        return timeAndPlaceNouns;
    }

    public void setTimeAndPlaceNouns(List<Noun> timeAndPlaceNouns) {
        this.timeAndPlaceNouns = timeAndPlaceNouns;
    }

    public List<Noun> getExaggeratedActiveParticiples() {
        return exaggeratedActiveParticiples;
    }

    public void setExaggeratedActiveParticiples(List<Noun> exaggeratedActiveParticiples) {
        this.exaggeratedActiveParticiples = exaggeratedActiveParticiples;
    }

    public List<Noun> getInstrumentalNouns() {
        return instrumentalNouns;
    }

    public void setInstrumentalNouns(List<Noun> instrumentalNouns) {
        this.instrumentalNouns = instrumentalNouns;
    }

    public List<Noun> getElatives() {
        return elatives;
    }

    public void setElatives(List<Noun> elatives) {
        this.elatives = elatives;
    }

    public List<Noun> getAssimilates() {
        return assimilates;
    }

    public void setAssimilates(List<Noun> assimilates) {
        this.assimilates = assimilates;
    }
}
