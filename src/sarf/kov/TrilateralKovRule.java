package sarf.kov;

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
public class TrilateralKovRule {

    private String c1;
    private String c2;
    private String c3;
    private int kov;
    private String desc;
    private String example;

    public TrilateralKovRule() {
    }

    public String getDesc() {

        return desc;
    }

    public String getExample() {
        return example;
    }

    public int getKov() {
        return kov;
    }

    public void setKov(int kov) {
        this.kov = kov;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public void setDesc(String desc) {

        this.desc = desc;
    }

    public void setC3(String c3) {
        this.c3 = c3;
    }

    public void setC2(String c2) {
        this.c2 = c2;
    }

    public void setC1(String c1) {
        this.c1 = c1;
    }

    public boolean check(char verbC1, char verbC2, char verbC3) {
        boolean b1 = (c1.equals("?")) || c1.equals("null") || (c1.equals(verbC1+""));

        boolean b2 = false, b3 = false;
        if (c2.equalsIgnoreCase("c3") && c3.equalsIgnoreCase("c2")) {
            b2 = b3= (verbC2 == verbC3);
        }
        else {
            b2 = (c2.equals("?")) || c2.equals("null") || (c2.equals(verbC2+""));
            b3 = (c3.equals("?")) || c3.equals("null") || (c3.equals(verbC3+""));
        }
        return b1 && b2 && b3;
    }
}
