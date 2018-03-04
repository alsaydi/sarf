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
public class NounFormula14 extends NonStandardInstrumentalNounFormula{

    public NounFormula14(UnaugmentedTrilateralRoot root, String suffixNo) {
        super(root, suffixNo);
    }

    //to be used in refection getting the formula name
    public NounFormula14() {
    }

    public String form() {
        switch (suffixNo) {
        case 1:
        case 3:
        case 7:
        case 9:
        case 13:
        case 15:
            return "Å"+ArabCharUtil.KASRA+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.KASRA+"í"+root.getC3()+suffix;
        }

        return "";
    }

    public String getFormulaName() {
        return "ÅöÝúÚöíá";
    }

    public String getSymbol() {
        return "R";
    }


}
