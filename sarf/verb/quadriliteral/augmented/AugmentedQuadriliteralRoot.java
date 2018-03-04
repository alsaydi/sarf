package sarf.verb.quadriliteral.augmented;

import java.util.*;

import sarf.*;
import sarf.verb.quadriliteral.*;

/**
 * <p>Title: Sarf</p>
 *
 * <p>Description: «·Ã–— «·—»«⁄Ì «·„“Ìœ
 * „ ÷„‰« «·√Õ—› «·√—»⁄…                </p>
 *

 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class AugmentedQuadriliteralRoot implements QuadrilateralRoot{
    private char c1;
    private char c2;
    private char c3;
    private char c4;

    //ﬁ«∆„… ’Ì€ «·„“Ìœ «·„„ﬂ‰… ·Â–« «·Ã–—
    private Map augmentations = new HashMap();

    public AugmentedQuadriliteralRoot() {
    }

    public void addAugmentationFormula(AugmentationFormula formula) {
        augmentations.put(formula.getFormulaNo()+"",formula);
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

    public Collection getAugmentationList() {
        return augmentations.values();
    }

    public AugmentationFormula getAugmentationFormula(int formulaNo) {
        return (AugmentationFormula) augmentations.get(formulaNo+"");
    }


    public char getC4() {
        return c4;
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
}
