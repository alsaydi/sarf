package sarf.noun.trilateral.unaugmented.exaggeration.nonstandard;

import sarf.verb.trilateral.unaugmented.*;
import sarf.util.*;
import sarf.noun.trilateral.unaugmented.exaggeration.NonStandardExaggerationNounFormula;
import sarf.noun.*;

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
public class NounFormula8 extends NonStandardExaggerationNounFormula {

    public NounFormula8(UnaugmentedTrilateralRoot root, String suffixNo, GenericNounSuffixContainer genericNounSuffixContainer) {
        super(root, suffixNo, genericNounSuffixContainer);
        if (this.suffixNo == 7 && genericNounSuffixContainer.isIndefinite()) {
            suffix = "ً";
        }
    }

    //to be used in refection getting the formula name
    public NounFormula8() {
    }

    public String form() {
        switch (suffixNo) {
        case 1:
        case 7:
        case 13:
            return root.getC1() + ArabCharUtil.FATHA + "ا" + root.getC2() + ArabCharUtil.KASRA + root.getC3() + ArabCharUtil.FATHA + "ة" + suffix;
        }

        return "";
    }

    public String getFormulaName() {
        return "فَاعِلَة";
    }

    public String getSymbol() {
        return "J";
    }
}
