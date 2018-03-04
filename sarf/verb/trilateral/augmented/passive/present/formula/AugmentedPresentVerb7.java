package sarf.verb.trilateral.augmented.passive.present.formula;

import sarf.verb.trilateral.augmented.*;
import sarf.util.*;
import sarf.verb.trilateral.augmented.*;

/**
 * <p>Title: Sarf</p>
 *
 * <p>Description: ?????? ???????</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class AugmentedPresentVerb7 extends AugmentedPresentVerb {

    public AugmentedPresentVerb7(AugmentedTrilateralRoot root, String cp, String lastDpr, String connectedPronoun) {
        super(root, cp, lastDpr, connectedPronoun);
    }

    /**
     * form
     *
     * @return String
     * @todo Implement this sarf.trilingual.augmented.present.AugmentedPresentVerb
     *   method
     */
    public String form() {
        return cp+ArabCharUtil.DAMMA+"Ê"+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.FATHA+"Ç"+root.getC2()+ArabCharUtil.FATHA+root.getC3()+lastDpr+connectedPronoun;
    }
}
