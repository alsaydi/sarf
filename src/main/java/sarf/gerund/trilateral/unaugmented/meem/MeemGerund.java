package sarf.gerund.trilateral.unaugmented.meem;

import sarf.noun.*;
import sarf.verb.trilateral.unaugmented.*;

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
public abstract class MeemGerund {
    private final GenericNounSuffixContainer genericNounSuffixContainer;
    protected UnaugmentedTrilateralRoot root;
    protected int suffixNo;
    protected String suffix;


    public MeemGerund() {
        genericNounSuffixContainer = null;
    }

    public MeemGerund(UnaugmentedTrilateralRoot root, String suffixNo, GenericNounSuffixContainer genericNounSuffixContainer) {
        this.genericNounSuffixContainer = genericNounSuffixContainer;
        init(root, suffixNo);
    }

    protected void init(UnaugmentedTrilateralRoot root, String suffixNo) {
        this.root = root;
        this.suffixNo = "".equals(suffixNo) ? 0 : Integer.parseInt(suffixNo);

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
