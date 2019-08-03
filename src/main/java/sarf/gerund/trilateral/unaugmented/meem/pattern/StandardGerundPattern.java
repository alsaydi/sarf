package sarf.gerund.trilateral.unaugmented.meem.pattern;

import sarf.Conjugation;
import sarf.KindOfVerb;
import sarf.util.*;
import sarf.gerund.trilateral.unaugmented.meem.*;
import sarf.verb.trilateral.unaugmented.*;
import sarf.kov.*;
import java.util.stream.Stream;

import static sarf.KindOfVerb.*;

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
    public static StandardGerundPattern Empty = new StandardGerundPattern();
    public StandardGerundPattern(UnaugmentedTrilateralRoot root, String suffixNo, KindOfVerb kov) {
        init(root, suffixNo);
        var noc = root.getConjugation();
        //try first state
        form1 = (isMithalWawi(kov) && (noc == Conjugation.Second || noc == Conjugation.Third ||noc == Conjugation.Sixth));
        //if not check the second state
        if (!form1)
            form1 = (isAjwafYaee(kov) && noc == Conjugation.Second);
        //else we have to show form2
    }

    private StandardGerundPattern() {
        init(new UnaugmentedTrilateralRoot(), "");
    }

    private static boolean isMithalWawi(KindOfVerb kov) {
        var list = Stream.of(Mithal_Wawi_Mudaaf, /* مثال واوي مضعف -- ودَّ */
                Mithal_Wawi_Mahmouz_Ain, /* مثال واوي مهموز العين -- وأل (بمعنى لجأ) */
                Mithal_Wawi_Mahmouz_Laam, /* مثال واوي مهموز اللام -- وجأ */
                Mithal_Wawi /* مثال واوي -- وثب */);

        return list.anyMatch(k -> k.equals(kov));
    }

    private static boolean isAjwafYaee(KindOfVerb kov) {
        var list = Stream.of(Ajwaf_Yaee_Mahmouz_Faa, /* أجوف يائي مهموز الفاء -- آن */
                Ajwaf_Yaee_Mahmouz_Laam, /* أجوف يائي مهموز اللام -- شاء */
                Ajwaf_Yaee /* أجوف يائي --  كال */);

        return  list.anyMatch(k -> k.equals(kov));
    }

    /**
     * form
     *
     * @return String
     * @todo Implement this
     *   sarf.gerund.trilateral.augmented.TrilateralAugmentedNomenGerund method
     */
    public String form() {
        if(this == Empty)
            return "";

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
