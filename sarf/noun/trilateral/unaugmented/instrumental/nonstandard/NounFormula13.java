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
public class NounFormula13 extends NonStandardInstrumentalNounFormula{

    public NounFormula13(UnaugmentedTrilateralRoot root, String suffixNo) {
        super(root, suffixNo);
    }

    //to be used in refection getting the formula name
    public NounFormula13() {
    }

    public String form() {
        switch (suffixNo) {
        case 2:
        case 4:
        case 8:
        case 10:
        case 14:
        case 16:
            return "√" + ArabCharUtil.DAMMA + root.getC1() + ArabCharUtil.SKOON + root.getC2() + ArabCharUtil.DAMMA + "Ê" + root.getC3() + suffix;
        }
        return "";
    }

    public String getFormulaName() {
        return "√ı›˙⁄ıÊ·Û…";
    }

    public String getSymbol() {
        return "Q";
    }


}
