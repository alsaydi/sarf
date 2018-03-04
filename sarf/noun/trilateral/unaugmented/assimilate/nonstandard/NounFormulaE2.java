package sarf.noun.trilateral.unaugmented.assimilate.nonstandard;

import sarf.noun.NounFormula;
import sarf.verb.trilateral.unaugmented.*;
import sarf.util.*;
import sarf.noun.trilateral.unaugmented.assimilate.AssimilateFormulaE1SuffixContainer;
import sarf.noun.trilateral.unaugmented.assimilate.*;
import sarf.noun.INounSuffixContainer;

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
public class NounFormulaE2 extends NounFormula {

    public NounFormulaE2(UnaugmentedTrilateralRoot root, String suffixNo) {
        super(root, suffixNo);
    }

    //to be used in refection getting the formula name
    public NounFormulaE2() {
    }

    public String form() {
        switch (suffixNo) {
        case 1:
        case 3:
        case 7:
        case 9:
        case 13:
        case 15:
            return form2();

        case 2:
        case 4:
        case 8:
        case 10:
        case 14:
        case 16:
            return form1();
        }

        return "";
    }

    //›Û⁄˙·ÛÏ
    public String form1() {
        suffix = AssimilateFormulaE2SuffixContainer.getInstance().get(this.suffixNo-1).replaceAll(" ","");
        return root.getC1()+ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.SKOON+root.getC3()+suffix;
    }

    //›Û⁄˙·«‰
    public String form2() {
        suffix = AssimilateFormulaE1SuffixContainer.getInstance().get(this.suffixNo-1).replaceAll(" ","");
        return root.getC1()+ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.SKOON+root.getC3()+ArabCharUtil.FATHA+"«‰"+suffix;
    }


    public String getFormulaName() {
        return "›Û⁄˙·«‰ / ›Û⁄˙·ÛÏ" ;
    }

    protected INounSuffixContainer getNounSuffixContainer() {
        switch (suffixNo) {
        case 1:
        case 3:
        case 7:
        case 9:
        case 13:
        case 15:
            return AssimilateFormulaE1SuffixContainer.getInstance();
        }
        return AssimilateFormulaE2SuffixContainer.getInstance();
    }

}
