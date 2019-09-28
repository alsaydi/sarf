package sarf.verb;

import sarf.Conjugation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Root {
    private char c1;
    private char c2;
    private char c3;
    private Conjugation conjugation;

    public Root(){}

    public Root(char c1, char c2, char c3) {
        this.setC1(c1);
        this.setC2(c2);
        this.setC3(c3);
    }

    public char getC1() {
        return c1;
    }

    public char getC2() {
        return c2;
    }

    public char getC3() {
        return c3;
    }

    public void setC3(char c3) {
        this.c3 = c3;
    }

    public void setC2(char c2) {
        this.c2 = c2;
    }

    public void setC1(char c1) {
        this.c1 = c1;
    }

    public abstract List<RootLetter> getCharacters();

    public Conjugation getConjugation() {
        return conjugation;
    }

    public void setConjugation(Conjugation conjugation) {
        this.conjugation = conjugation;
    }

    @Override
    public String toString() {
        List<Character> arr = getCharacters().stream().map(RootLetter::getValue).collect(Collectors.toList());
        return String.valueOf(arr);
    }
}

