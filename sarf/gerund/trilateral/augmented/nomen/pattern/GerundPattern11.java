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
public class GerundPattern11 extends TrilateralAugmentedNomenGerund {
    public GerundPattern11() {
        super();
    }

    public GerundPattern11(AugmentedTrilateralRoot root, String suffixNo) {
        super(root, suffixNo);
    }

    /**
     * form
     *
     * @return String
     * @todo Implement this
     *   sarf.gerund.trilateral.augmented.TrilateralAugmentedNomenGerund method
     */
    public String form() {
        return "Ç"+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.KASRA+"æ"+ArabCharUtil.SHADDA+ArabCharUtil.FATHA+"Ç"+root.getC3()+suffix;
    }

    /**
     * getPattern
     *
     * @return String
     * @todo Implement this
     *   sarf.gerund.trilateral.augmented.TrilateralAugmentedNomenGerund method
     */
    public String getPattern() {
        return "ÇÝúÚöæøóÇáÉ";
    }
}
