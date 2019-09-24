package sarf.gerund.trilateral.augmented.pattern;

import sarf.gerund.trilateral.augmented.TrilateralAugmentedGerund;
import sarf.noun.GenericNounSuffixContainer;
import sarf.util.ArabCharUtil;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;

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
public class GerundPattern2 extends TrilateralAugmentedGerund {
    private boolean form2Applied;
    private boolean form3Applied;
    public GerundPattern2(AugmentedTrilateralRoot root, String suffixNo, GenericNounSuffixContainer genericNounSuffixContainer) {
        this(root, suffixNo, genericNounSuffixContainer, false, false);
    }

    public GerundPattern2(AugmentedTrilateralRoot root, String suffixNo, GenericNounSuffixContainer genericNounSuffixContainer, boolean applyForm2, boolean applForm3){
        super(root, suffixNo, genericNounSuffixContainer);
        this.form2Applied = applyForm2;
        this.form3Applied = applForm3;
    }

    /**
     * form
     *
     * @return String
     * @todo Implement this
     *   sarf.gerund.trilateral.augmented.TrilateralAugmentedGerund method
     */
    public String form() {
        if (form2Applied)
            return form2();
        if (form3Applied)
            return form3();
        return form1();

    }

    //نفس القانون ولكن يختلف مواقع الضمائر
    private String generateForm() {
        return "ت"+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.KASRA+"ي"+root.getC3()+suffix;
    }

    public String form1() {
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

    public String form2() {
        if (suffixNo%2 == 0)
            return generateForm();
        return "";
    }

    public String form3() {
        if (suffixNo%2 == 0)
            return "ت"+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.KASRA+root.getC3()+suffix;
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
        return "تَفْعِيل";
    }
}
