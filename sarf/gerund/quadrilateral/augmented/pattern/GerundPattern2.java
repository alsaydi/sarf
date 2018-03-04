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
public class GerundPattern2 extends QuadriliteralAugmentedGerund {
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
        return "Ç"+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.KASRA+"ä"+ArabCharUtil.SKOON+root.getC3()+ArabCharUtil.FATHA+"Ç"+root.getC4()+suffix;
    }


    /**
     * getPattern
     *
     * @return String
     * @todo Implement this
     *   sarf.gerund.trilateral.augmented.TrilateralAugmentedGerund method
     */
    public String getPattern() {
        return "ÇÝúÚöäúáÇá";
    }

}
