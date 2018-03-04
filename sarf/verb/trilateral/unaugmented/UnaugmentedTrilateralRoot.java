package sarf.verb.trilateral.unaugmented;

import java.util.*;
import sarf.*;
import sarf.verb.trilateral.TrilateralRoot;
import sarf.util.OrderedMap;

/**
 * <p>Title: </p>
 *
 * <p>Description: «·Ã–— «·À·«ÀÌ «·„Ã—œ
 * „ ÷„‰« «·√Õ—› «·À·«À… Ê»«» «· ’—Ì›  Ê«··“Ê„ √Ê «· ⁄œÌ… „⁄ —„Ê“ «·„’«œ—              </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class UnaugmentedTrilateralRoot implements TrilateralRoot{

    private char c1;
    private char c2;
    private char c3;
    private String conjugation;
    private String transitive;

    private OrderedMap gerundes = new OrderedMap();

    public UnaugmentedTrilateralRoot() {
    }

    public char getC1() {
        return c1;
    }

    public char getC2() {
        return c2;
    }

    public String getConjugation() {
        return conjugation;
    }

    public char getC3() {
        return c3;
    }

    public String getTransitive() {
        return transitive;
    }

    public Collection getGerundsSymbols() {
        return gerundes.getOrderedKeys();
    }

    public Gerund getGerund(String symbol) {
        return (Gerund) gerundes.get(symbol);
    }


    public void setTransitive(String transitive) {
        this.transitive = transitive;
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

    public void addGerund(Gerund gerund) {
        gerundes.put(gerund.getSymbol(), gerund);
    }

    public boolean equals(Object obj) {
        UnaugmentedTrilateralRoot root = (UnaugmentedTrilateralRoot) obj;
        return root.c1 == c1 && root.c2 == c2 && root.c3 == c3;
    }
}
