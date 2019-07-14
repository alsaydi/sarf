package sarf.gerund.trilateral.augmented.nomen.pattern;

import sarf.gerund.trilateral.augmented.nomen.*;
import sarf.util.*;
import sarf.verb.trilateral.augmented.*;

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
public class GerundPattern1 extends TrilateralAugmentedNomenGerund {
    public GerundPattern1() {
    }

    public GerundPattern1(AugmentedTrilateralRoot root, String suffixNo) {
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
//        if (root.getC2() == 'و' || root.getC2() == 'ي')
//            return form2();
        return form1();
    }

    public String form1() {
        return "إ"+ArabCharUtil.KASRA+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.FATHA+"ا"+root.getC3()+suffix;
    }
//
//    public String form2() {
//        return "إ"+ArabCharUtil.KASRA+root.getC1()+ArabCharUtil.FATHA+"ا"+root.getC3()+suffix;
//    }



    /**
     * getPattern
     *
     * @return String
     * @todo Implement this
     *   sarf.gerund.trilateral.augmented.TrilateralAugmentedNomenGerund method
     */
    public String getPattern() {
        return "إفْعَالة";
    }
}
