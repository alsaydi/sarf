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
    protected String suffix;

    QuadrilateralAugmentedNomenGerund() {}

    public QuadrilateralAugmentedNomenGerund(AugmentedQuadrilateralRoot root, String suffixNo) {
        this.root = root;
        this.suffixNo = Integer.parseInt(suffixNo);

        suffix = GenericNounSuffixContainer.getInstance().get(this.suffixNo);
    }

    public abstract String form();
    public abstract String getPattern();

    public String toString() {
        String result = form();
        if (result != null && !result.equals(""))
            return GenericNounSuffixContainer.getInstance().getPrefix()+result;
        return "";
    }
}
