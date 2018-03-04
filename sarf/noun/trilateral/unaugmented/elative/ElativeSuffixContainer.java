package sarf.noun.trilateral.unaugmented.elative;

import java.util.*;
import sarf.noun.*;
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
 * @author Haytham Mohta\u00E6sseb Billah
 * @version 1.0
 */
public class ElativeSuffixContainer implements INounSuffixContainer{
    private static ElativeSuffixContainer instance = new ElativeSuffixContainer();
    //ÍÇáÉ ÇáãÚÑİÉ
    private ArrayList definiteSuffixList = new ArrayList(18);
    //ÌÏæá ÊÕÑíİ ÇÓã ÇáÊİÖíá ÇáãÖÇİ Åáì ãÚÑİÉ
    private ArrayList annexedDefiniteSuffixList = new ArrayList(18);

    // ÌÏæá ÊÕÑíİ ÇÓã ÇáÊİÖíá ÇáãÖÇİ Åáì äßÑÉ
    private ArrayList annexedIndefiniteSuffixList = new ArrayList(18);
    //ÌÏæá ÊÕÑíİ ÇÓã ÇáÊİÖíá ÛíÑ ÇáãÖÇİ
    //notAnnexedSuffixList is same as annexedIndefiniteSuffixList
    private ArrayList notAnnexedSuffixList = new ArrayList(18);

    //Êßæä áåÇ ŞíãÉ ÚäÏãÇ Êßæä ÇáÍÇáÉ åí ãÚÑİÉ
    private String prefix = "";
    //íãËá ÇáŞÇÆãÉ ÇáãÎÊÇÑÉ ÊÈÚÇğ ááÍÇáÉ
    private ArrayList currentSuffixList = annexedIndefiniteSuffixList ;

    private ElativeSuffixContainer() {
        annexedIndefiniteSuffixList.add(ArabCharUtil.DAMMA);
        annexedIndefiniteSuffixList.add(ArabCharUtil.DAMMA);
        annexedIndefiniteSuffixList.add(ArabCharUtil.DAMMA);
        annexedIndefiniteSuffixList.add(ArabCharUtil.DAMMA);
        annexedIndefiniteSuffixList.add(ArabCharUtil.DAMMA);
        annexedIndefiniteSuffixList.add(ArabCharUtil.DAMMA);
        annexedIndefiniteSuffixList.add(ArabCharUtil.FATHA);
        annexedIndefiniteSuffixList.add(ArabCharUtil.FATHA);
        annexedIndefiniteSuffixList.add(ArabCharUtil.FATHA);
        annexedIndefiniteSuffixList.add(ArabCharUtil.FATHA);
        annexedIndefiniteSuffixList.add(ArabCharUtil.FATHA);
        annexedIndefiniteSuffixList.add(ArabCharUtil.FATHA);
        annexedIndefiniteSuffixList.add(ArabCharUtil.KASRA);
        annexedIndefiniteSuffixList.add(ArabCharUtil.KASRA);
        annexedIndefiniteSuffixList.add(ArabCharUtil.KASRA);
        annexedIndefiniteSuffixList.add(ArabCharUtil.KASRA);
        annexedIndefiniteSuffixList.add(ArabCharUtil.KASRA);
        annexedIndefiniteSuffixList.add(ArabCharUtil.KASRA);

        definiteSuffixList.add("õ");
        definiteSuffixList.add("óì");
        definiteSuffixList.add("óÇäö");
        definiteSuffixList.add("óíóÇäö");
        definiteSuffixList.add("õæäó");
        definiteSuffixList.add("óíóÇÊõ");
        definiteSuffixList.add("ó");
        definiteSuffixList.add("óì");
        definiteSuffixList.add("óíúäö");
        definiteSuffixList.add("óíóíúäö");
        definiteSuffixList.add("öíäó");
        definiteSuffixList.add("óíóÇÊö");
        definiteSuffixList.add("ö");
        definiteSuffixList.add("óì");
        definiteSuffixList.add("óíúäö");
        definiteSuffixList.add("óíóíúäö");
        definiteSuffixList.add("öíäó");
        definiteSuffixList.add("óíóÇÊö");


        annexedDefiniteSuffixList.add(ArabCharUtil.DAMMA);
        annexedDefiniteSuffixList.add("óì");
        annexedDefiniteSuffixList.add("óÇ");
        annexedDefiniteSuffixList.add("óíóÇ");
        annexedDefiniteSuffixList.add("õæ");
        annexedDefiniteSuffixList.add("óíóÇÊõ");
        annexedDefiniteSuffixList.add(ArabCharUtil.FATHA);
        annexedDefiniteSuffixList.add("óì");
        annexedDefiniteSuffixList.add("óíú");
        annexedDefiniteSuffixList.add("óíóíú");
        annexedDefiniteSuffixList.add("öí");
        annexedDefiniteSuffixList.add("óíóÇÊö");
        annexedDefiniteSuffixList.add(ArabCharUtil.KASRA);
        annexedDefiniteSuffixList.add("óì");
        annexedDefiniteSuffixList.add("óíú");
        annexedDefiniteSuffixList.add("óíóíú");
        annexedDefiniteSuffixList.add("öí");
        annexedDefiniteSuffixList.add("óíóÇÊö");

        notAnnexedSuffixList.add(ArabCharUtil.DAMMA);
        notAnnexedSuffixList.add(ArabCharUtil.DAMMA);
        notAnnexedSuffixList.add(ArabCharUtil.DAMMA);
        notAnnexedSuffixList.add(ArabCharUtil.DAMMA);
        notAnnexedSuffixList.add(ArabCharUtil.DAMMA);
        notAnnexedSuffixList.add(ArabCharUtil.DAMMA);
        notAnnexedSuffixList.add(ArabCharUtil.FATHA);
        notAnnexedSuffixList.add(ArabCharUtil.FATHA);
        notAnnexedSuffixList.add(ArabCharUtil.FATHA);
        notAnnexedSuffixList.add(ArabCharUtil.FATHA);
        notAnnexedSuffixList.add(ArabCharUtil.FATHA);
        notAnnexedSuffixList.add(ArabCharUtil.FATHA);
        notAnnexedSuffixList.add(ArabCharUtil.FATHA);
        notAnnexedSuffixList.add(ArabCharUtil.FATHA);
        notAnnexedSuffixList.add(ArabCharUtil.FATHA);
        notAnnexedSuffixList.add(ArabCharUtil.FATHA);
        notAnnexedSuffixList.add(ArabCharUtil.FATHA);
        notAnnexedSuffixList.add(ArabCharUtil.FATHA);
    }

    /**
     * ÇÎÊíÇÑ ÇáãÚÑİ ÈÃá
     */
    public void selectDefiniteMode() {
        prefix = "Çá";
        currentSuffixList = definiteSuffixList;
    }

    /**
     * ÇÎÊíÇÑ ÇáãÖÇİ Åáì äßÑÉ
     */
    public void selectInDefiniteMode() {
        prefix = "";
        currentSuffixList = annexedIndefiniteSuffixList;
    }

    /**
     * ÇÎÊíÇÑ ÇáÛíÑ ãÖÇİ
     */
    public void selectNotAnnexedMode() {
        prefix = "";
        currentSuffixList = notAnnexedSuffixList;
    }


    /**
     * ÇÎÊíÇÑ ÇáãÖÇİ Åáì ãÚÑİÉ
     */
    public void selectAnnexedMode() {
        prefix = "";
        currentSuffixList = annexedDefiniteSuffixList;
    }

    public static ElativeSuffixContainer getInstance() {
        return instance;
    }

    public String getPrefix() {
        return prefix;
    }

    public String get(int index) {
        return (String) currentSuffixList.get(index);
    }

    public boolean isAnnexed() {
        return currentSuffixList == annexedDefiniteSuffixList;
    }

    public boolean isDefinite() {
        return currentSuffixList == definiteSuffixList;
    }

    public boolean isIndefinite() {
        return currentSuffixList == annexedIndefiniteSuffixList;
    }

    public boolean isNotAnnexed() {
        return currentSuffixList == notAnnexedSuffixList;
    }

}
