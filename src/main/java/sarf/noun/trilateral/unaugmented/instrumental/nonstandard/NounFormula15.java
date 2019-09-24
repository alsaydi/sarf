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
public class NounFormula15 extends NonStandardInstrumentalNounFormula{

    public NounFormula15(UnaugmentedTrilateralRoot root, String suffixNo, GenericNounSuffixContainer genericNounSuffixContainer) {
        super(root, suffixNo, genericNounSuffixContainer);
    }

    //to be used in refection getting the formula name
    public NounFormula15() {
    }

    public String form() {
        if (suffixNo % 2 == 0)
            return "م"+ArabCharUtil.DAMMA+root.getC1()+ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.SHADDA+ArabCharUtil.KASRA+root.getC3()+suffix;
        return "";
    }

    public String getFormulaName() {
        return "مُفَعِّلَة";
    }

    public String getSymbol() {
        return "S";
    }


}
