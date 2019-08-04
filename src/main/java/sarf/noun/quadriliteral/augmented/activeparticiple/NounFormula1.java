package sarf.noun.quadriliteral.augmented.activeparticiple;

import sarf.noun.GenericNounSuffixContainer;
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
public class NounFormula1 extends AugmentedQuadrilateralNoun {
    public NounFormula1(AugmentedQuadrilateralRoot root, String suffix, GenericNounSuffixContainer genericNounSuffixContainer) {
        super(root, suffix, genericNounSuffixContainer);
    }

    /**
     * form
     *
     * @return String
     * @todo Implement this sarf.noun.quadriliteral.QuadriliteralNoun method
     */
    public String form() {
        return "م" + ArabCharUtil.DAMMA + "ت" + ArabCharUtil.FATHA + root.getC1() + ArabCharUtil.FATHA + root.getC2() + ArabCharUtil.SKOON + root.getC3() + ArabCharUtil.KASRA + root.getC4() + suffix;
    }
}