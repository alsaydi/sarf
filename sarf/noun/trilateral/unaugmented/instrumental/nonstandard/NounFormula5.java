package sarf.noun.trilateral.unaugmented.instrumental.nonstandard;

import sarf.noun.NounFormula;
import sarf.verb.trilateral.unaugmented.*;
import sarf.util.*;
import sarf.noun.trilateral.unaugmented.instrumental.*;

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
public class NounFormula5 extends NonStandardInstrumentalNounFormula {

    public NounFormula5(UnaugmentedTrilateralRoot root, String suffixNo) {
        super(root, suffixNo);
    }

    //to be used in refection getting the formula name
    public NounFormula5() {
    }

    public String form() {
        switch (suffixNo) {
        case 1:
        case 3:
        case 7:
        case 9:
        case 13:
        case 15:
        case 6:
        case 12:
        case 18:
            return "„" + ArabCharUtil.DAMMA + root.getC1() + ArabCharUtil.FATHA + root.getC2() + ArabCharUtil.SHADDA + ArabCharUtil.KASRA + root.getC3() + suffix;
        }

        return "";
    }

    public String getFormulaName() {
        return "„ı›Û⁄¯ˆ·";
    }

    public String getSymbol() {
        return "I";
    }


}
