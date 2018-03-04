package sarf.verb.quadriliteral.unaugmented;

import sarf.verb.quadriliteral.QuadrilateralRoot;

/**
 * <p>Title: Sarf</p>
 *
 * <p>Description: «·Ã–— «·—»«⁄Ì «·„Ã—œ
 * „ ÷„‰« «·√Õ—› «·√—»⁄… Ê«··“Ê„ √Ê «· ⁄œÌ…               </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class UnaugmentedQuadriliteralRoot implements QuadrilateralRoot{

    private char c1;
    private char c2;
    private char c3;
    private char c4;
    private String transitive;


    public UnaugmentedQuadriliteralRoot() {
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

    public String getTransitive() {
        return transitive;
    }

    public char getC4() {
        return c4;
    }


    public void setTransitive(String transitive) {
        this.transitive = transitive;
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

    public void setC4(char c4) {
        this.c4 = c4;
    }


    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param obj the reference object with which to compare.
     * @return <code>true</code> if this object is the same as the obj
     *   argument; <code>false</code> otherwise.
     * @todo Implement this java.lang.Object method
     */
    public boolean equals(Object obj) {
        UnaugmentedQuadriliteralRoot root = (UnaugmentedQuadriliteralRoot) obj;
        return root.c1 == c1 && root.c2 == c2 && root.c3 == c3 && root.c4 == c4;
    }
}


