package sarf.noun.trilateral.unaugmented.exaggeration.standard;

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
public class NounFormula1 extends NounFormula{

    public NounFormula1(UnaugmentedTrilateralRoot root, String suffixNo) {
        super(root, suffixNo);
    }

    public String form() {
        return root.getC1()+ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.SHADDA+ArabCharUtil.FATHA+"«"+root.getC3()+suffix;
    }

    public String getFormulaName() {
        return "›Û⁄¯Û«·";
    }


}
