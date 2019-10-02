package sarf.gerund.trilateral.augmented.pattern;

import sarf.gerund.trilateral.augmented.*;
import sarf.noun.GenericNounSuffixContainer;
import sarf.util.*;
import sarf.verb.trilateral.augmented.*;

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
public class GerundPattern1 extends TrilateralAugmentedGerund implements IChangedGerundPattern {
    private boolean forcedForm1Applying = false;

    public GerundPattern1(AugmentedTrilateralRoot root, String suffixNo, GenericNounSuffixContainer genericNounSuffixContainer) {
        super(root, suffixNo, genericNounSuffixContainer);
    }

    /**
     * form
     *
     * @return String
     * @todo Implement this
     * sarf.gerund.trilateral.augmented.TrilateralAugmentedGerund method
     */
    public String form() {
        if (forcedForm1Applying)
            return form1();

        if ((root.getC2() == 'و' || root.getC2() == 'ي') && (root.getC3() != 'و' && root.getC3() != 'ي')) {
            return form2();
        }
        return form1();
    }

    private String form1() {
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
                return generateForm();
        }
        return "";
    }

    private String form2() {
        if (suffixNo % 2 == 0)
            return generateForm();
        return "";
    }

    private String generateForm() {
        return "إ" + ArabCharUtil.KASRA + root.getC1() + ArabCharUtil.SKOON + root.getC2() + ArabCharUtil.FATHA + "ا" + root.getC3() + suffix;
    }

    /**
     * getPattern
     *
     * @return String
     * @todo Implement this
     * sarf.gerund.trilateral.augmented.TrilateralAugmentedGerund method
     */
    public String getPattern() {
        return "إفْعَال";
    }

    public void setForcedForm1Applying(boolean forcedForm1Applying) {
        this.forcedForm1Applying = forcedForm1Applying;
    }
}
