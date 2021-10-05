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

public class VerbConjugations {
    private List<String> past;
    private List<String> nominativePresent; //مضارع مرفوع
    private List<String> accusativePresent; //مضارع منصوب
    private List<String> jussivePresent; //مضارع مجزوم
    private List<String> emphasizedPresent; //مضارع مؤكد
    private List<String> imperative;// أمر
    private List<String> emphasizedImperative; //أمر مؤكد

    public List<String> getNominativePresent() {
        return nominativePresent;
    }

    public void setNominativePresent(List<String> nominativePresent) {
        this.nominativePresent = nominativePresent;
    }

    public List<String> getAccusativePresent() {
        return accusativePresent;
    }

    public void setAccusativePresent(List<String> accusativePresent) {
        this.accusativePresent = accusativePresent;
    }

    public List<String> getJussivePresent() {
        return jussivePresent;
    }

    public void setJussivePresent(List<String> jussivePresent) {
        this.jussivePresent = jussivePresent;
    }

    public List<String> getEmphasizedPresent() {
        return emphasizedPresent;
    }

    public void setEmphasizedPresent(List<String> emphasizedPresent) {
        this.emphasizedPresent = emphasizedPresent;
    }

    public List<String> getImperative() {
        return imperative;
    }

    public void setImperative(List<String> imperative) {
        this.imperative = imperative;
    }

    public List<String> getEmphasizedImperative() {
        return emphasizedImperative;
    }

    public void setEmphasizedImperative(List<String> emphasizedImperative) {
        this.emphasizedImperative = emphasizedImperative;
    }

    public List<String> getPast() {
        return past;
    }

    public void setPast(List<String> past) {
        this.past = past;
    }
}
