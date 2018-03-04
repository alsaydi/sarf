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
public class GerundPattern3 extends TrilateralAugmentedNomenGerund {
    public GerundPattern3() {
        super();
    }


    public GerundPattern3(AugmentedTrilateralRoot root, String suffixNo) {
        init(root, suffixNo);
    }



    public String form() {
        return "„"+ArabCharUtil.DAMMA+root.getC1()+ArabCharUtil.FATHA+"«"+root.getC2()+ArabCharUtil.FATHA+root.getC3()+suffix;
    }



    /**
     * getPattern
     *
     * @return String
     * @todo Implement this
     *   sarf.gerund.trilateral.augmented.TrilateralAugmentedNomenGerund method
     */
    public String getPattern() {
        return "„ı›Û«⁄Û·Û…";
    }
}
