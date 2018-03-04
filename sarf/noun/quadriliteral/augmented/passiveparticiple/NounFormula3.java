package sarf.noun.quadriliteral.augmented.passiveparticiple;

import sarf.noun.quadriliteral.*;
import sarf.verb.quadriliteral.augmented.*;
import sarf.util.ArabCharUtil;
import sarf.noun.quadriliteral.augmented.*;

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
public class NounFormula3 extends AugmentedQuadriliteralNoun {
    public NounFormula3(AugmentedQuadriliteralRoot root, String suffix) {
        super(root, suffix);
    }

    /**
     * form
     *
     * @return String
     * @todo Implement this sarf.noun.quadriliteral.QuadriliteralNoun method
     */
    public String form() {
        return "ã"+ArabCharUtil.DAMMA+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.FATHA+root.getC3()+ArabCharUtil.SKOON+root.getC4()+ArabCharUtil.FATHA+root.getC4()+suffix;
    }
}
