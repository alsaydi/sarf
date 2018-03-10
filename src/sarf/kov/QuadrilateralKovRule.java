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
public class QuadrilateralKovRule {

    private String c1;
    private String c2;
    private String c3;
    private String c4;
    private int kov;
    private String desc;
    private String example;

    public QuadrilateralKovRule() {
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

    public void setC4(String c4) {
        this.c4 = c4;
    }

    public boolean check(char verbC1, char verbC2, char verbC3, char verbC4) {
        boolean b1 = (c1.equals("?")) || c1.equals("null") || (c1.equals(verbC1+""));
        boolean b2 = (c2.equals("?")) || c2.equals("null") || (c2.equals(verbC2+""));
        boolean b3 = (c3.equals("?")) || c3.equals("null") || (c3.equals(verbC3+""));
        boolean b4 = (c4.equals("?")) || c4.equals("null") || (c4.equals(verbC4+""));


        if (c1.equalsIgnoreCase("c3") && c3.equalsIgnoreCase("c1")) {
            b1 = b3= (verbC1 == verbC3);
        }
        if (c2.equalsIgnoreCase("c4") && c4.equalsIgnoreCase("c2")) {
            b2 = b4= (verbC2 == verbC4);
        }

        return b1 && b2 && b3 && b4;
    }
}
