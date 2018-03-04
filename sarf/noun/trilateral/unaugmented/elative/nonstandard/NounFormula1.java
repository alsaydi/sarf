package sarf.noun.trilateral.unaugmented.elative.nonstandard;

import sarf.noun.NounFormula;
import sarf.verb.trilateral.unaugmented.*;
import sarf.util.*;
import sarf.noun.trilateral.unaugmented.elative.*;
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
public class NounFormula1 extends NounFormula {

    public NounFormula1(UnaugmentedTrilateralRoot root, String suffixNo) {
        this.root = root;
        this.suffixNo = Integer.parseInt(suffixNo) + 1;
        suffix = ElativeSuffixContainer.getInstance().get(this.suffixNo - 1).replaceAll(" ", "");
    }

    //to be used in refection getting the formula name
    public NounFormula1() {
    }

    public String form() {
        return "√" + ArabCharUtil.FATHA + root.getC1() + ArabCharUtil.SKOON + root.getC2() + ArabCharUtil.FATHA + root.getC3() + suffix;
    }

    public String getFormulaName() {
        return "√Û›˙⁄Û·";
    }

    protected INounSuffixContainer getNounSuffixContainer() {
        return ElativeSuffixContainer.getInstance();
    }


}
