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
public abstract class QuadriliteralAugmentedNomenGerund {
    protected AugmentedQuadriliteralRoot root;
    protected int suffixNo;
    protected String suffix;

    public QuadriliteralAugmentedNomenGerund() {}

    public QuadriliteralAugmentedNomenGerund(AugmentedQuadriliteralRoot root, String suffixNo) {
        init(root, suffixNo);
    }

    protected void init(AugmentedQuadriliteralRoot root, String suffixNo) {
        this.root = root;
        this.suffixNo = Integer.parseInt(suffixNo);

        suffix = GenericNounSuffixContainer.getInstance().get(this.suffixNo);
    }

    public abstract String form();
    public abstract String getPattern();

    public String toString() {
        String result = form();
        if (result != null && result != "")
            return GenericNounSuffixContainer.getInstance().getPrefix()+result;
        return "";
    }


}
