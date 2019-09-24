package sarf.gerund.quadrilateral.augmented.nomen;

import sarf.noun.*;
import sarf.verb.quadriliteral.augmented.*;

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
public abstract class QuadrilateralAugmentedNomenGerund {
    protected AugmentedQuadrilateralRoot root;
    protected int suffixNo;
    private final GenericNounSuffixContainer genericNounSuffixContainer;
    protected String suffix;

    QuadrilateralAugmentedNomenGerund() {
        genericNounSuffixContainer = null;
    }

    public QuadrilateralAugmentedNomenGerund(AugmentedQuadrilateralRoot root, String suffixNo, GenericNounSuffixContainer genericNounSuffixContainer) {
        this.root = root;
        this.suffixNo = Integer.parseInt(suffixNo);
        this.genericNounSuffixContainer = genericNounSuffixContainer;

        suffix = genericNounSuffixContainer.get(this.suffixNo);
    }

    public abstract String form();
    public abstract String getPattern();

    public String toString() {
        String result = form();
        if (result != null && !result.equals(""))
            return genericNounSuffixContainer.getPrefix()+result;
        return "";
    }
}
