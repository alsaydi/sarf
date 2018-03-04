package sarf.noun.trilateral.unaugmented.exaggeration.nonstandard;

import sarf.noun.NounFormula;
import sarf.verb.trilateral.unaugmented.*;
import sarf.util.*;
import sarf.noun.trilateral.unaugmented.exaggeration.NonStandardExaggerationNounFormula;

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
public class NounFormula4 extends NonStandardExaggerationNounFormula{

    public NounFormula4(UnaugmentedTrilateralRoot root, String suffixNo) {
        super(root, suffixNo);
    }

    //to be used in refection getting the formula name
    public NounFormula4() {
    }

    public String form() {
        return root.getC1()+ArabCharUtil.KASRA+root.getC2()+ArabCharUtil.SHADDA+ArabCharUtil.KASRA+"í"+root.getC3()+suffix;
    }

    public String getFormulaName() {
        return "ÝöÚøöíá";
    }

    public String getSymbol() {
        return "E";
    }

}
