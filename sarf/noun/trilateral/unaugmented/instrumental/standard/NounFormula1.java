package sarf.noun.trilateral.unaugmented.instrumental.standard;

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
public class NounFormula1 extends NounFormula {

    public NounFormula1(UnaugmentedTrilateralRoot root, String suffixNo) {
        super(root, suffixNo);
    }

    public String form() {
        switch (suffixNo) {
        case 1:
        case 3:
        case 7:
        case 9:
        case 13:
        case 15:
            return "ã" + ArabCharUtil.KASRA + root.getC1() + ArabCharUtil.SKOON + root.getC2() + ArabCharUtil.FATHA + root.getC3() + suffix;
        }

        return "";
    }

    public String getFormulaName() {
        return "ãöÝúÚóá";
    }

}
