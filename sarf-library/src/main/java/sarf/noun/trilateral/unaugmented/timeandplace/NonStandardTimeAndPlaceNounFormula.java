package sarf.noun.trilateral.unaugmented.timeandplace;

import sarf.noun.GenericNounSuffixContainer;
import sarf.noun.NounFormula;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;

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
public abstract class NonStandardTimeAndPlaceNounFormula extends NounFormula {
    protected NonStandardTimeAndPlaceNounFormula() {
    }

    protected NonStandardTimeAndPlaceNounFormula(UnaugmentedTrilateralRoot root, String suffixNo, GenericNounSuffixContainer genericNounSuffixContainer) {
        super(root, suffixNo, genericNounSuffixContainer);
    }

    /**
     * Every non standard time and place has a symbol to be represented by
     *
     * @return String
     */
    public String getSymbol() {
        return "";
    }
}
