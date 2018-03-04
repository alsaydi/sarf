package sarf.noun.quadriliteral.augmented.activeparticiple;

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
public class NounFormula1 extends AugmentedQuadriliteralNoun {
    public NounFormula1(AugmentedQuadriliteralRoot root, String suffix) {
        super(root, suffix);
    }

    /**
     * form
     *
     * @return String
     * @todo Implement this sarf.noun.quadriliteral.QuadriliteralNoun method
     */
    public String form() {
        return "ã"+ArabCharUtil.DAMMA+"Ê"+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.SKOON+root.getC3()+ArabCharUtil.KASRA+root.getC4()+suffix;
    }
}
