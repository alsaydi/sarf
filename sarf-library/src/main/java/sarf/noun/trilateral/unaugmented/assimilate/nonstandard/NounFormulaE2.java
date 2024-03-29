package sarf.noun.trilateral.unaugmented.assimilate.nonstandard;

import sarf.noun.INounSuffixContainer;
import sarf.noun.NounFormula;
import sarf.verb.trilateral.unaugmented.*;
import sarf.util.*;
import sarf.noun.trilateral.unaugmented.assimilate.*;

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
    private final INounSuffixContainer nounSuffixContainer;

    public NounFormulaE2(){
        nounSuffixContainer = AssimilateFormulaE2SuffixContainer.getInstance();
    }

    public NounFormulaE2(UnaugmentedTrilateralRoot root, String suffixNo, INounSuffixContainer nounSuffixContainer) {
        super(root, suffixNo, nounSuffixContainer);
        this.nounSuffixContainer = nounSuffixContainer;
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

    //فَعْلَى
    private String form1() {
        suffix = nounSuffixContainer.get(this.suffixNo-1).replaceAll(" ","");
        return root.getC1()+ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.SKOON+root.getC3()+suffix;
    }

    //فَعْلان
    private String form2() {
        suffix = AssimilateFormulaE1SuffixContainer.getInstance().get(this.suffixNo-1).replaceAll(" ","");
        return root.getC1()+ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.SKOON+root.getC3()+ArabCharUtil.FATHA+"ان"+suffix;
    }


    public String getFormulaName() {
        return "فَعْلان / فَعْلَى" ;
    }
}
