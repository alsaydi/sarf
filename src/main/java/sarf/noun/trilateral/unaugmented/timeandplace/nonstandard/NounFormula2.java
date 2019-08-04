package sarf.noun.trilateral.unaugmented.timeandplace.nonstandard;

import sarf.noun.GenericNounSuffixContainer;
import sarf.verb.trilateral.unaugmented.*;
import sarf.util.*;
import sarf.noun.trilateral.unaugmented.timeandplace.NonStandardTimeAndPlaceNounFormula;

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
public class NounFormula2 extends NonStandardTimeAndPlaceNounFormula{
    public NounFormula2(){}
    public NounFormula2(UnaugmentedTrilateralRoot root, String suffixNo, GenericNounSuffixContainer genericNounSuffixContainer) {
        super(root, suffixNo, genericNounSuffixContainer);
    }
    public String form() {
        switch (suffixNo) {
        case 1:
        case 3:
        case 7:
        case 9:
        case 13:
        case 15:
            return "م"+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.KASRA+root.getC3()+suffix;
        }

        return "";
    }

    public String getFormulaName() {
        return "مَفْعِل";
    }

    public String getSymbol() {
        return "B";
    }


}
