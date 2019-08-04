package sarf.noun.trilateral.unaugmented.exaggeration.nonstandard;

import sarf.Gerund;
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
public class NounFormula1 extends NonStandardExaggerationNounFormula{

    public NounFormula1(UnaugmentedTrilateralRoot root, String suffixNo, GenericNounSuffixContainer genericNounSuffixContainer) {
        super(root, suffixNo, genericNounSuffixContainer);
    }

    //to be used in refection getting the formula name
    public NounFormula1() {
    }

    public String form() {
        return root.getC1()+ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.DAMMA+"و"+root.getC3()+suffix;
    }

    public String getFormulaName() {
        return "فَعُول";
    }

    public String getSymbol() {
        return "B";
    }


}
