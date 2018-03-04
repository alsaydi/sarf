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
public class GerundPattern9 extends TrilateralAugmentedNomenGerund {
    public GerundPattern9() {
        super();
    }

    public GerundPattern9(AugmentedTrilateralRoot root, String suffixNo) {
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
//        if (root.getC2() == 'Ê' || root.getC2() == 'Ì')
//            return form2();
        return form1();

    }

    public String form1() {
        return "«”"+ArabCharUtil.SKOON+" "+ArabCharUtil.KASRA+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.FATHA+"«"+root.getC3()+suffix;
    }

    public String form2() {
        return "«”"+ArabCharUtil.SKOON+" "+ArabCharUtil.KASRA+root.getC1()+ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.SKOON+root.getC3()+suffix;
    }



    /**
     * getPattern
     *
     * @return String
     * @todo Implement this
     *   sarf.gerund.trilateral.augmented.TrilateralAugmentedNomenGerund method
     */
    public String getPattern() {
        return "«”˙ ˆ›˙⁄Û«·…";
    }
}
