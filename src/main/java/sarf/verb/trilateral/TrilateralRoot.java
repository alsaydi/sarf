package sarf.verb.trilateral;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: الصف الأب للجذر الثلاثي المزيد والناقص     </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public abstract class TrilateralRoot {
    private char c1;
    private char c2;
    private char c3;

    public TrilateralRoot(){}

    public TrilateralRoot(char c1, char c2, char c3) {
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
}
