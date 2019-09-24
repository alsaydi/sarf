package sarf.noun.trilateral.unaugmented.exaggeration.nonstandard;

import sarf.noun.GenericNounSuffixContainer;
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
public class NounFormula9 extends NonStandardExaggerationNounFormula{

    public NounFormula9(UnaugmentedTrilateralRoot root, String suffixNo, GenericNounSuffixContainer genericNounSuffixContainer) {
        super(root, suffixNo, genericNounSuffixContainer);
    }

    //to be used in refection getting the formula name
    public NounFormula9() {
    }

    public String form() {
        return "م"+ArabCharUtil.KASRA+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.KASRA+"ي"+root.getC3()+suffix;
    }

    public String getFormulaName() {
        return "مِفْعِيل";
    }

    public String getSymbol() {
        return "K";
    }


}
