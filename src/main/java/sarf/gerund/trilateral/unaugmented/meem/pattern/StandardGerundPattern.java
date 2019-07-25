package sarf.gerund.trilateral.unaugmented.meem.pattern;

import sarf.Conjugation;
import sarf.KindOfVerb;
import sarf.util.*;
import sarf.verb.trilateral.augmented.*;
import sarf.gerund.trilateral.unaugmented.meem.*;
import sarf.verb.trilateral.unaugmented.*;
import sarf.kov.*;

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
public class StandardGerundPattern extends MeemGerund {

    private boolean form1;

    public StandardGerundPattern(UnaugmentedTrilateralRoot root, String suffixNo) {
        init(root, suffixNo);
        KindOfVerb kov = KovRulesManager.getInstance().getTrilateralKov(root.getC1(), root.getC2(), root.getC3());
        var noc = root.getConjugation();
        //try first state
        form1 = (kov >= 8 &&  kov <= 11 && (noc == Conjugation.Second || noc == Conjugation.Third ||noc == Conjugation.Sixth));
        //if not check the second state
        if (!form1)
            form1 = (kov >= 18 &&  kov <= 20 && noc == Conjugation.Second);
        //else we have to show form2
    }

    /**
     * form
     *
     * @return String
     * @todo Implement this
     *   sarf.gerund.trilateral.augmented.TrilateralAugmentedNomenGerund method
     */
    public String form() {
        if (form1)
            return form1();
        return form2();
    }

    public String form1() {
        return "م"+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.KASRA+root.getC3()+suffix;
    }

    public String form2() {
        return "م"+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.FATHA+root.getC3()+suffix;
    }



    /**
     * getPattern
     *
     * @return String
     * @todo Implement this
     *   sarf.gerund.trilateral.augmented.TrilateralAugmentedNomenGerund method
     */
    public String getPattern() {
        return form1? "مَفْعِل" : "مَفْعَل";
    }
}
