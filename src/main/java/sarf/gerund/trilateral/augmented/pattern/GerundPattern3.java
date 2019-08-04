package sarf.gerund.trilateral.augmented.pattern;

import sarf.gerund.trilateral.augmented.*;
import sarf.verb.trilateral.augmented.*;
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
public class GerundPattern3 extends TrilateralAugmentedGerund {
    public GerundPattern3() {
        super();
    }

    private boolean form2Applied = false;

    public GerundPattern3(AugmentedTrilateralRoot root, String suffixNo, boolean applyForm2) {
        this.form2Applied = applyForm2;
        init(root, suffixNo);
    }
    public GerundPattern3(AugmentedTrilateralRoot root, String suffixNo) {
        this(root, suffixNo, false);
    }

    /**
     * form
     *
     * @return String
     * @todo Implement this
     *   sarf.gerund.trilateral.augmented.TrilateralAugmentedGerund method
     */
    public String form() {
        return form2Applied ? form2() : form1();
    }

    public String form1() {
        if (suffixNo % 2 == 0) {
            return "م" + ArabCharUtil.DAMMA + root.getC1() + ArabCharUtil.FATHA + "ا" + root.getC2() + ArabCharUtil.FATHA + root.getC3() + suffix;
        }
        return "";
    }

    public String form2() {
        switch (suffixNo) {
        case 1:
        case 3:
        case 6:
        case 7:
        case 9:
        case 12:
        case 13:
        case 15:
        case 18:
            return root.getC1() + ArabCharUtil.KASRA + root.getC2() + ArabCharUtil.FATHA + "ا" + root.getC3() + suffix;
        }
        return "";
    }


    /**
     * getPattern
     *
     * @return String
     * @todo Implement this
     *   sarf.gerund.trilateral.augmented.TrilateralAugmentedGerund method
     */
    public String getPattern() {
        return "مُفَاعَلَة";
    }

}
