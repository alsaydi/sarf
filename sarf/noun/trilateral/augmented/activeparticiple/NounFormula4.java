package sarf.noun.trilateral.augmented.activeparticiple;

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
public class NounFormula4 extends AugmentedTrilateralNoun {
    public NounFormula4(AugmentedTrilateralRoot root, String suffix) {
        super(root, suffix);
    }

    /**
     * form
     *
     * @return String
     * @todo Implement this sarf.noun.trilateral.TrilateralNoun method
     */
    public String form() {
        return "ã"+ArabCharUtil.DAMMA+"ä"+ArabCharUtil.SKOON+root.getC1()+ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.KASRA+root.getC3()+suffix;
    }
}
