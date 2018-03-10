package sarf.noun.trilateral.unaugmented.assimilate;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class AssimilateAdjectiveFormula {
    private char c1;
    private char c2;
    private char c3;
    private String conjugation;
    private String adj1;
    private String adj2;
    private String adj3;

    public AssimilateAdjectiveFormula() {
    }

    public String getAdj1() {
        return adj1;
    }

    public String getAdj2() {
        return adj2;
    }

    public String getAdj3() {
        return adj3;
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

    public String getConjugation() {
        return conjugation;
    }

    public void setConjugation(String conjugation) {
        this.conjugation = conjugation;
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

    public void setAdj3(String adj3) {
        this.adj3 = adj3;
    }

    public void setAdj2(String adj2) {
        this.adj2 = adj2;
    }

    public void setAdj1(String adj1) {
        this.adj1 = adj1;
    }
}
