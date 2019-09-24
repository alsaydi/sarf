package sarf.noun.trilateral.unaugmented.instrumental.nonstandard;

import sarf.noun.GenericNounSuffixContainer;
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
public class NounFormula3 extends NonStandardInstrumentalNounFormula{

	//to be used in refection getting the formula name
    public NounFormula3() {
    }

    public NounFormula3(UnaugmentedTrilateralRoot root, String suffixNo, GenericNounSuffixContainer genericNounSuffixContainer) {
        super(root, suffixNo, genericNounSuffixContainer);
    }

    public String form() {
        switch (suffixNo) {
        case 2:
        case 4:
        case 8:
        case 10:
        case 14:
        case 16:
            return root.getC1()+ArabCharUtil.FATHA+"ا"+root.getC2()+ArabCharUtil.KASRA+root.getC3()+suffix;
        }
        return "";
    }

    public String getFormulaName() {
        return "فَاعِلَة";
    }

    public String getSymbol() {
        return "G";
    }

}
