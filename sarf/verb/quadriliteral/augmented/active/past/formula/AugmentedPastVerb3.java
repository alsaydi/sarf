package sarf.verb.quadriliteral.augmented.active.past.formula;

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
public class AugmentedPastVerb3 extends AugmentedPastVerb {

    public AugmentedPastVerb3(AugmentedQuadriliteralRoot root, String lastDpa, String connectedPronoun) {
        super(root, lastDpa, connectedPronoun);
    }

    /**
     * form
     *
     * @return String
     * @todo Implement this sarf.trilingual.augmented.past.AugmentedPastVerb
     *   method
     */
    public String form() {
        return "Ç"+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.FATHA+root.getC3()+ArabCharUtil.SKOON+root.getC4()+ArabCharUtil.FATHA+root.getC4()+lastDpa+connectedPronoun;
    }
}
