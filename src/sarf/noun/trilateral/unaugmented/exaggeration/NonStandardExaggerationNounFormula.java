package sarf.noun.trilateral.unaugmented.exaggeration;

import sarf.noun.*;
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
public abstract class NonStandardExaggerationNounFormula extends NounFormula {
    public NonStandardExaggerationNounFormula() {
    }

    public NonStandardExaggerationNounFormula(UnaugmentedTrilateralRoot root, String suffixNo) {
        super(root, suffixNo);
    }

    /**
     * Every non standard instrumental has a symbol to be represented by
     * @return String
     */
    public abstract String getSymbol();

}
