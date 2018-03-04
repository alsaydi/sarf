package sarf.gerund.quadrilateral.augmented.pattern;

import sarf.util.*;
import sarf.verb.quadriliteral.augmented.*;
import sarf.gerund.quadrilateral.augmented.QuadriliteralAugmentedGerund;

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
public class GerundPattern1 extends QuadriliteralAugmentedGerund {
    public GerundPattern1() {
    }

    public GerundPattern1(AugmentedQuadriliteralRoot root, String suffixNo) {
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
        return " "+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.SKOON+root.getC3()+ArabCharUtil.DAMMA+root.getC4()+suffix;
    }


    /**
     * getPattern
     *
     * @return String
     * @todo Implement this
     *   sarf.gerund.trilateral.augmented.TrilateralAugmentedGerund method
     */
    public String getPattern() {
        return " Û›Û⁄˙·ı·";
    }

}
