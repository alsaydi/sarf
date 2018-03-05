package sarf.verb.quadriliteral.augmented.passive.present.formula;

import sarf.util.*;
import sarf.verb.quadriliteral.augmented.*;
import sarf.verb.quadriliteral.augmented.*;

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
public class AugmentedPresentVerb3 extends AugmentedPresentVerb {

    public AugmentedPresentVerb3(AugmentedQuadriliteralRoot root, String cp, String lastDpr, String connectedPronoun) {
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
        return cp+ArabCharUtil.DAMMA+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.FATHA+root.getC3()+ArabCharUtil.SKOON+root.getC4()+ArabCharUtil.FATHA+root.getC4()+lastDpr+connectedPronoun;
    }
}
