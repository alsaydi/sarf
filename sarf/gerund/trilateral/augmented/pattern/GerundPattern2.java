package sarf.gerund.trilateral.augmented.pattern;

import sarf.gerund.trilateral.augmented.*;
import sarf.verb.trilateral.augmented.*;
import sarf.util.*;
import sarf.gerund.trilateral.*;

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
public class GerundPattern2 extends TrilateralAugmentedGerund {
    public GerundPattern2() {

    }

    private boolean form2Applied = false;
    private boolean form3Applied = false;
    public GerundPattern2(AugmentedTrilateralRoot root, String suffixNo) {
        init(root, suffixNo);
        //”Ì „ «Œ Ì«— √Õœ «·ﬁ«‰Ê‰Ì‰
        if (root.getC3() == '¡') {
            form3Applied = TrilateralAugmentedGerundConjugator.getInstance().selectPatternFormNo(2) == 2;
        }
        //⁄—÷ ›Ì «·„ƒ‰À ··‰«ﬁ’
        else if (root.getC3() == 'Ê' || root.getC3() == 'Ì')
            form2Applied = true;

    }

    /**
     * form
     *
     * @return String
     * @todo Implement this
     *   sarf.gerund.trilateral.augmented.TrilateralAugmentedGerund method
     */
    public String form() {
        if (form2Applied)
            return form2();
        if (form3Applied)
            return form3();
        return form1();

    }

    //‰›” «·ﬁ«‰Ê‰ Ê·ﬂ‰ ÌŒ ·› „Ê«ﬁ⁄ «·÷„«∆—
    private String generateForm() {
        return " "+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.KASRA+"Ì"+root.getC3()+suffix;
    }

    public String form1() {
        switch (suffixNo) {
        case 1:
        case 3:
        case 6:
        case 7:
        case 9:
        case 12:
        case 13:
        case 15:
        case 18:
            return generateForm();
        }
        return "";

    }

    public String form2() {
        if (suffixNo%2 == 0)
            return generateForm();
        return "";
    }

    public String form3() {
        if (suffixNo%2 == 0)
            return " "+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.KASRA+root.getC3()+suffix;
        return "";
    }

    /**
     * getPattern
     *
     * @return String
     * @todo Implement this
     *   sarf.gerund.trilateral.augmented.TrilateralAugmentedGerund method
     */
    public String getPattern() {
        return " Û›˙⁄ˆÌ·";
    }
}
