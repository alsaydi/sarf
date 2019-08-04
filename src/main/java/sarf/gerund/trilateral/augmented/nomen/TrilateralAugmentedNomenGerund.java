package sarf.gerund.trilateral.augmented.nomen;

import sarf.noun.*;
import sarf.verb.trilateral.augmented.*;

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
public abstract class TrilateralAugmentedNomenGerund {
    private final GenericNounSuffixContainer genericNounSuffixContainer;
    protected AugmentedTrilateralRoot root;
    protected int suffixNo;
    protected String suffix;

    public TrilateralAugmentedNomenGerund(AugmentedTrilateralRoot root, String suffixNo
            , GenericNounSuffixContainer genericNounSuffixContainer) {
        this.genericNounSuffixContainer = genericNounSuffixContainer;
        this.root = root;
        this.suffixNo = Integer.parseInt(suffixNo);
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
