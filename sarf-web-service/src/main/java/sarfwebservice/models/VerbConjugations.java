package sarfwebservice.models;

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
