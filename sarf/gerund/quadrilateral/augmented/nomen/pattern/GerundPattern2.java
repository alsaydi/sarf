package sarf.gerund.quadrilateral.augmented.nomen.pattern;

import sarf.util.*;
import sarf.verb.quadriliteral.augmented.*;
import sarf.gerund.quadrilateral.augmented.nomen.QuadriliteralAugmentedNomenGerund;

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
public class GerundPattern2 extends QuadriliteralAugmentedNomenGerund {
    public GerundPattern2() {
    }

    public GerundPattern2(AugmentedQuadriliteralRoot root, String suffixNo) {
        init(root, suffixNo);
    }

    /**
     * form
     *
     * @return String
     * @todo Implement this
     *   sarf.gerund.trilateral.augmented.TrilateralAugmentedGerund method
     */
    public String form() {
        return "«"+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.KASRA+"‰"+ArabCharUtil.SKOON+root.getC3()+ArabCharUtil.FATHA+"«"+root.getC4()+suffix;
    }


    /**
     * getPattern
     *
     * @return String
     * @todo Implement this
     *   sarf.gerund.trilateral.augmented.TrilateralAugmentedGerund method
     */
    public String getPattern() {
        return "«›˙⁄ˆ‰˙·«·…";
    }

}
