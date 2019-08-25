package sarf.noun;

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
public abstract class NounFormula {
    protected UnaugmentedTrilateralRoot root;
    protected int suffixNo;
    protected String suffix;
    private INounSuffixContainer genericNounSuffixContainer;

    //to be used in refection getting the formula name
    public NounFormula() {
    }

    public NounFormula(UnaugmentedTrilateralRoot root, String suffixNo, INounSuffixContainer genericNounSuffixContainer) {
        this.genericNounSuffixContainer = genericNounSuffixContainer;
        this.root = root;
        this.suffixNo = Integer.parseInt(suffixNo)+1;
        suffix = genericNounSuffixContainer.get(this.suffixNo-1);
    }

    public abstract String form();

    public abstract String getFormulaName();

    public String toString() {
        String result = form();
        if (result != null && !result.equals("") && genericNounSuffixContainer != null)
            return genericNounSuffixContainer.getPrefix()+result;
        return "";
    }
}
