package sarf.kov;

import sarf.KindOfVerb;

import java.util.Arrays;
import java.util.List;

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
    private KindOfVerb kov;
    private String desc;
    private String example;
    private static List<Character> vowels = Arrays.asList('ء', 'و', 'ي');

    public TrilateralKovRule() {
    }

    public String getDesc() {
        return desc;
    }

    public String getExample() {
        return example;
    }

    public KindOfVerb getKov() {
        return kov;
    }

    public void setKov(KindOfVerb kov) {
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

    /**
     * This check function can return true to multiple patterns. So the order in which the TrilateralKindOfVerb rules are checked matters.
     * @param verbC1 the first character of the verb
     * @param verbC2 the second character of the verb
     * @param verbC3 the third character of the verb
     * @return true if the passed in verb falls under the rule covered by the pattern "c1+c2+c3" of this rule.
     */
    public boolean check(char verbC1, char verbC2, char verbC3) {
        boolean b1 = (c1.equals("?") || c1.equals("null") && isConsonant(verbC1)) || (c1.equals(verbC1+""));

        boolean b2, b3;
        if (c2.equalsIgnoreCase("c3") && c3.equalsIgnoreCase("c2")) {
            b2 = b3 = (verbC2 == verbC3);
        }
        else {
            b2 = (c2.equals("?") || c2.equals("null") && isConsonant(verbC2)) || (c2.equals(verbC2+""));
            b3 = (c3.equals("?") || c3.equals("null") && isConsonant(verbC3)) || (c3.equals(verbC3+""));
        }
        return b1 && b2 && b3;
    }

    private static boolean isConsonant(char verbC1) {
        return !vowels.contains(verbC1);
    }

    @Override
    public String toString() {
        return String.format("KoV - Index: %s -  %d", getDesc(), getKov());
    }
}
