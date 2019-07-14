package sarf.gerund.trilateral.augmented.nomen.pattern;

import sarf.gerund.trilateral.augmented.nomen.TrilateralAugmentedNomenGerund;
import sarf.util.ArabCharUtil;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;

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
public class GerundPattern7 extends TrilateralAugmentedNomenGerund {
    public GerundPattern7() {
        super();
    }

    public GerundPattern7(AugmentedTrilateralRoot root, String suffixNo) {
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
        return "ت"+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.FATHA+"ا"+root.getC2()+ArabCharUtil.DAMMA+root.getC3()+suffix;
    }

    /**
     * getPattern
     *
     * @return String
     * @todo Implement this
     *   sarf.gerund.trilateral.augmented.TrilateralAugmentedNomenGerund method
     */
    public String getPattern() {
        return "تَفَاعُلة";
    }
}
