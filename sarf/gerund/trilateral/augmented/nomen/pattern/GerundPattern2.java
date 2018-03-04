package sarf.gerund.trilateral.augmented.nomen.pattern;

import sarf.gerund.trilateral.augmented.*;
import sarf.verb.trilateral.augmented.*;
import sarf.util.*;
import sarf.gerund.trilateral.*;
import sarf.gerund.trilateral.augmented.nomen.*;

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
public class GerundPattern2 extends TrilateralAugmentedNomenGerund {
    public GerundPattern2() {

    }

    public GerundPattern2(AugmentedTrilateralRoot root, String suffixNo) {
        init(root, suffixNo);
    }

    /**
     * form
     *
     * @return String
     * @todo Implement this
     *   sarf.gerund.trilateral.augmented.TrilateralAugmentedNomenGerund method
     */
    public String form() {
//        if (root.getC3() == 'Ê' || root.getC3() == 'Ì')
//            return form2();
//        else if (root.getC3() == '¡')
//            return form3();
        return form1();

    }

    public String form1() {
        return " "+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.KASRA+"Ì"+root.getC3()+suffix;
    }

    public String form2() {
        return " "+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.KASRA+root.getC3()+suffix;
    }

    public String form3() {
        return " "+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.KASRA+"∆"+suffix;
    }

    /**
     * getPattern
     *
     * @return String
     * @todo Implement this
     *   sarf.gerund.trilateral.augmented.TrilateralAugmentedNomenGerund method
     */
    public String getPattern() {
        return " Û›˙⁄ˆÌ·…";
    }
}
