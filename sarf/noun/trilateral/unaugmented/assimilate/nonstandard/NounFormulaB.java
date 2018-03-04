package sarf.noun.trilateral.unaugmented.assimilate.nonstandard;

import sarf.noun.NounFormula;
import sarf.verb.trilateral.unaugmented.*;
import sarf.util.*;

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
public class NounFormulaB extends NounFormula{

    public NounFormulaB(UnaugmentedTrilateralRoot root, String suffixNo) {
        super(root, suffixNo);
    }

    //to be used in refection getting the formula name
    public NounFormulaB() {
    }

    public String form() {
        return root.getC1()+ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.KASRA+root.getC3()+suffix;
    }

    public String getFormulaName() {
        return "έσΪφα";
    }
}
