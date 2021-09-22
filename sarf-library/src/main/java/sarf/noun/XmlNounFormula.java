package sarf.noun;

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
public class XmlNounFormula {
    private char c1;
    private char c2;
    private char c3;
    private String example;
    private String pattern;

    public XmlNounFormula() {
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

    public String getExample() {
        return example;
    }

    public String getPattern() {
        return pattern;
    }

    public void setC1(char c1) {
        this.c1 = c1;
    }

    public void setC2(char c2) {
        this.c2 = c2;
    }

    public void setC3(char c3) {
        this.c3 = c3;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
