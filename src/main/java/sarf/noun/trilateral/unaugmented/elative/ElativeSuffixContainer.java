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
    private static final ElativeSuffixContainer instance = new ElativeSuffixContainer();
    //حالة المعرفة
    private final ArrayList definiteSuffixList = new ArrayList(18);
    //جدول تصريف اسم التفضيل المضاف إلى معرفة
    private final ArrayList annexedDefiniteSuffixList = new ArrayList(18);

    // جدول تصريف اسم التفضيل المضاف إلى نكرة
    private final ArrayList annexedIndefiniteSuffixList = new ArrayList(18);
    //جدول تصريف اسم التفضيل غير المضاف
    //notAnnexedSuffixList is same as annexedIndefiniteSuffixList
    private final ArrayList notAnnexedSuffixList = new ArrayList(18);

    //تكون لها قيمة عندما تكون الحالة هي معرفة
    private String prefix = "";
    //يمثل القائمة المختارة تبعاً للحالة
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

        definiteSuffixList.add("ُ");
        definiteSuffixList.add("َى");
        definiteSuffixList.add("َانِ");
        definiteSuffixList.add("َيَانِ");
        definiteSuffixList.add("ُونَ");
        definiteSuffixList.add("َيَاتُ");
        definiteSuffixList.add("َ");
        definiteSuffixList.add("َى");
        definiteSuffixList.add("َيْنِ");
        definiteSuffixList.add("َيَيْنِ");
        definiteSuffixList.add("ِينَ");
        definiteSuffixList.add("َيَاتِ");
        definiteSuffixList.add("ِ");
        definiteSuffixList.add("َى");
        definiteSuffixList.add("َيْنِ");
        definiteSuffixList.add("َيَيْنِ");
        definiteSuffixList.add("ِينَ");
        definiteSuffixList.add("َيَاتِ");


        annexedDefiniteSuffixList.add(ArabCharUtil.DAMMA);
        annexedDefiniteSuffixList.add("َى");
        annexedDefiniteSuffixList.add("َا");
        annexedDefiniteSuffixList.add("َيَا");
        annexedDefiniteSuffixList.add("ُو");
        annexedDefiniteSuffixList.add("َيَاتُ");
        annexedDefiniteSuffixList.add(ArabCharUtil.FATHA);
        annexedDefiniteSuffixList.add("َى");
        annexedDefiniteSuffixList.add("َيْ");
        annexedDefiniteSuffixList.add("َيَيْ");
        annexedDefiniteSuffixList.add("ِي");
        annexedDefiniteSuffixList.add("َيَاتِ");
        annexedDefiniteSuffixList.add(ArabCharUtil.KASRA);
        annexedDefiniteSuffixList.add("َى");
        annexedDefiniteSuffixList.add("َيْ");
        annexedDefiniteSuffixList.add("َيَيْ");
        annexedDefiniteSuffixList.add("ِي");
        annexedDefiniteSuffixList.add("َيَاتِ");

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
     * اختيار المعرف بأل
     */
    public void selectDefiniteMode() {
        prefix = "ال";
        currentSuffixList = definiteSuffixList;
    }

    /**
     * اختيار المضاف إلى نكرة
     */
    public void selectInDefiniteMode() {
        prefix = "";
        currentSuffixList = annexedIndefiniteSuffixList;
    }

    /**
     * اختيار الغير مضاف
     */
    public void selectNotAnnexedMode() {
        prefix = "";
        currentSuffixList = notAnnexedSuffixList;
    }


    /**
     * اختيار المضاف إلى معرفة
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
