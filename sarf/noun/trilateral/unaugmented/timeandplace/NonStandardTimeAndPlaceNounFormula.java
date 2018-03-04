package sarf.noun.trilateral.unaugmented.timeandplace;

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

    public NonStandardTimeAndPlaceNounFormula() {
    }

    public NonStandardTimeAndPlaceNounFormula(UnaugmentedTrilateralRoot root, String suffixNo) {
        super(root, suffixNo);
    }

    /**
     * Every non standard time and place has a symbol to be represented by
     * @return String
     */
    public abstract String getSymbol();
}
