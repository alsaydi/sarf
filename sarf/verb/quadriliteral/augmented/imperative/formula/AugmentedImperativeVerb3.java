package sarf.verb.quadriliteral.augmented.imperative.formula;

import sarf.util.*;
import sarf.verb.quadriliteral.augmented.*;
import sarf.verb.quadriliteral.augmented.*;
import sarf.verb.quadriliteral.augmented.*;
import sarf.verb.quadriliteral.augmented.imperative.*;

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
public class AugmentedImperativeVerb3 extends AugmentedImperativeVerb {

    public AugmentedImperativeVerb3(AugmentedQuadriliteralRoot root,  String lastDim, String connectedPronoun) {
        super(root, lastDim, connectedPronoun);
    }

    public String form() {
        return "Ç"+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.FATHA+root.getC3()+ArabCharUtil.SKOON+root.getC4()+ArabCharUtil.KASRA+root.getC4()+lastDim+connectedPronoun;
    }
}
