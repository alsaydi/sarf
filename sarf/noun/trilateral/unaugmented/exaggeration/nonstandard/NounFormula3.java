package sarf.noun.trilateral.unaugmented.exaggeration.nonstandard;

import sarf.noun.NounFormula;
import sarf.verb.trilateral.unaugmented.*;
import sarf.util.*;
import sarf.noun.trilateral.unaugmented.exaggeration.NonStandardExaggerationNounFormula;
import sarf.noun.GenericNounSuffixContainer;

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
public class NounFormula3 extends NonStandardExaggerationNounFormula{

    public NounFormula3(UnaugmentedTrilateralRoot root, String suffixNo) {
        super(root, suffixNo);

        if (this.suffixNo == 7 && GenericNounSuffixContainer.getInstance().isInDefiniteMode()) {
            suffix = "";
        }

    }

    //to be used in refection getting the formula name
    public NounFormula3() {
    }

    public String form() {
        switch (suffixNo) {
        case 1:
        case 7:
        case 13:
            return root.getC1()+ArabCharUtil.DAMMA+root.getC2()+ArabCharUtil.FATHA+root.getC3()+ArabCharUtil.FATHA+"…"+suffix;
        }

        return "";
    }

    public String getFormulaName() {
        return "›ı⁄Û·Û…";
    }

    public String getSymbol() {
        return "D";
    }


}
