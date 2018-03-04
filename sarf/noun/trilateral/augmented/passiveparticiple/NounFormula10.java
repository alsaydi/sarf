package sarf.noun.trilateral.augmented.passiveparticiple;

import sarf.noun.trilateral.*;
import sarf.verb.trilateral.augmented.*;
import sarf.util.ArabCharUtil;
import sarf.noun.trilateral.augmented.*;

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
public class NounFormula10 extends AugmentedTrilateralNoun {
    public NounFormula10(AugmentedTrilateralRoot root, String suffix) {
        super(root, suffix);
    }

    /**
     * form
     *
     * @return String
     * @todo Implement this sarf.noun.trilateral.TrilateralNoun method
     */
    public String form() {
        return "ã"+ArabCharUtil.DAMMA+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.FATHA+"æ"+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.FATHA+root.getC3()+suffix;
    }
}
