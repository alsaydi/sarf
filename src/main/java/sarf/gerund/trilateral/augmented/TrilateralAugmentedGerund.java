package sarf.gerund.trilateral.augmented;

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
public abstract class TrilateralAugmentedGerund {
    private final GenericNounSuffixContainer genericNounSuffixContainer;
    protected final AugmentedTrilateralRoot root;
    protected final int suffixNo;
    protected final String suffix;

    public TrilateralAugmentedGerund(AugmentedTrilateralRoot root, String suffixNo, GenericNounSuffixContainer genericNounSuffixContainer) {
        this.suffixNo = Integer.parseInt(suffixNo) + 1;
        this.root = root;
        this.genericNounSuffixContainer = genericNounSuffixContainer;

        suffix = genericNounSuffixContainer.get(this.suffixNo - 1);
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
