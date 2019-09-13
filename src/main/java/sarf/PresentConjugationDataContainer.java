package sarf;

import sarf.util.ArabCharUtil;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;

import java.util.ArrayList;
import java.util.List;

/**
 * يحتوي على  المعلومات  الصرفية المطلوبة لتصريف الأفعال  في المضارع
 * <p>Title: Sarf</p>
 * <p>Description: برنامج التصريف</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public final class PresentConjugationDataContainer {
    //أحرف المضارعة حسب الضمير
    private static final List<String> cpList = new ArrayList<>(SystemConstants.PRONOUN_RANGE_END);
    //قائمة حركات عين الفعل حسب باب التصريف
    private static final List<String> dpr2List = new ArrayList<>(6);

    //قائمة  حركات لام الفعل حسب ضمير الرفع
    //مرفوع
    private static final List<String> nominativeLastDprList = new ArrayList<>(SystemConstants.PRONOUN_RANGE_END);
    //منصوب
    private static final List<String> accusativeLastDprList = new ArrayList<>(SystemConstants.PRONOUN_RANGE_END);
    //مجزوم
    private static final List<String> jussiveLastDprList = new ArrayList<>(SystemConstants.PRONOUN_RANGE_END);
    //مؤكد
    private static final List<String> emphasizedLastDprList = new ArrayList<>(SystemConstants.PRONOUN_RANGE_END);

    //قائمة ضمائر الرفع المتصلة
    //مرفوع
    private static final List<String> nominativeConnectedPronounList = new ArrayList<>(SystemConstants.PRONOUN_RANGE_END);
    //منصوب
    private static final List<String> accusativeConnectedPronounList = new ArrayList<>(SystemConstants.PRONOUN_RANGE_END);
    //مجزوم
    private static final List<String> jussiveConnectedPronounList = new ArrayList<>(SystemConstants.PRONOUN_RANGE_END);
    //مؤكد
    private static final List<String> emphasizedConnectedPronounList = new ArrayList<>(SystemConstants.PRONOUN_RANGE_END);

    public static List<String> getNominativeLastDprList() {
        return nominativeLastDprList;
    }

    public static List<String> getNominativeConnectedPronounList() {
        return nominativeConnectedPronounList;
    }

    public static List<String> getEmphasizedLastDprList() {
        return emphasizedLastDprList;
    }

    public static List<String> getEmphasizedConnectedPronounList() {
        return emphasizedConnectedPronounList;
    }

    public static List<String> getJussiveLastDprList() {
        return jussiveLastDprList;
    }

    public static List<String> getJussiveConnectedPronounList() {
        return jussiveConnectedPronounList;
    }

    public static List<String> getAccusativeLastDprList() {
        return accusativeLastDprList;
    }

    public static List<String> getAccusativeConnectedPronounList() {
        return accusativeConnectedPronounList;
    }

    static {
        //تهيئة القيم
        dpr2List.add(ArabCharUtil.DAMMA);
        dpr2List.add(ArabCharUtil.KASRA);
        dpr2List.add(ArabCharUtil.FATHA);
        dpr2List.add(ArabCharUtil.FATHA);
        dpr2List.add(ArabCharUtil.DAMMA);
        dpr2List.add(ArabCharUtil.KASRA);

        cpList.add("أ");
        cpList.add("ن");
        cpList.add("ت");
        cpList.add("ت");
        cpList.add("ت");
        cpList.add("ت");
        cpList.add("ت");
        cpList.add("ي");
        cpList.add("ت");
        cpList.add("ي");
        cpList.add("ت");
        cpList.add("ي");
        cpList.add("ي");

        nominativeLastDprList.add(ArabCharUtil.DAMMA);
        nominativeLastDprList.add(ArabCharUtil.DAMMA);
        nominativeLastDprList.add(ArabCharUtil.DAMMA);
        nominativeLastDprList.add(ArabCharUtil.KASRA);
        nominativeLastDprList.add(ArabCharUtil.FATHA);
        nominativeLastDprList.add(ArabCharUtil.DAMMA);
        nominativeLastDprList.add(ArabCharUtil.SKOON);
        nominativeLastDprList.add(ArabCharUtil.DAMMA);
        nominativeLastDprList.add(ArabCharUtil.DAMMA);
        nominativeLastDprList.add(ArabCharUtil.FATHA);
        nominativeLastDprList.add(ArabCharUtil.FATHA);
        nominativeLastDprList.add(ArabCharUtil.DAMMA);
        nominativeLastDprList.add(ArabCharUtil.SKOON);

        nominativeConnectedPronounList.add("");
        nominativeConnectedPronounList.add("");
        nominativeConnectedPronounList.add("");
        nominativeConnectedPronounList.add("ينَ");
        nominativeConnectedPronounList.add("انِ");
        nominativeConnectedPronounList.add("ونَ");
        nominativeConnectedPronounList.add("نَ");
        nominativeConnectedPronounList.add("");
        nominativeConnectedPronounList.add("");
        nominativeConnectedPronounList.add("انِ");
        nominativeConnectedPronounList.add("انِ");
        nominativeConnectedPronounList.add("ونَ");
        nominativeConnectedPronounList.add("نَ");

        accusativeLastDprList.add(ArabCharUtil.FATHA);
        accusativeLastDprList.add(ArabCharUtil.FATHA);
        accusativeLastDprList.add(ArabCharUtil.FATHA);
        accusativeLastDprList.add(ArabCharUtil.KASRA);
        accusativeLastDprList.add(ArabCharUtil.FATHA);
        accusativeLastDprList.add(ArabCharUtil.DAMMA);
        accusativeLastDprList.add(ArabCharUtil.SKOON);
        accusativeLastDprList.add(ArabCharUtil.FATHA);
        accusativeLastDprList.add(ArabCharUtil.FATHA);
        accusativeLastDprList.add(ArabCharUtil.FATHA);
        accusativeLastDprList.add(ArabCharUtil.FATHA);
        accusativeLastDprList.add(ArabCharUtil.DAMMA);
        accusativeLastDprList.add(ArabCharUtil.SKOON);

        accusativeConnectedPronounList.add("");
        accusativeConnectedPronounList.add("");
        accusativeConnectedPronounList.add("");
        accusativeConnectedPronounList.add("ي");
        accusativeConnectedPronounList.add("ا");
        accusativeConnectedPronounList.add("وا");
        accusativeConnectedPronounList.add("نَ");
        accusativeConnectedPronounList.add("");
        accusativeConnectedPronounList.add("");
        accusativeConnectedPronounList.add("ا");
        accusativeConnectedPronounList.add("ا");
        accusativeConnectedPronounList.add("وا");
        accusativeConnectedPronounList.add("نَ");

        jussiveLastDprList.add(ArabCharUtil.SKOON);
        jussiveLastDprList.add(ArabCharUtil.SKOON);
        jussiveLastDprList.add(ArabCharUtil.SKOON);
        jussiveLastDprList.add(ArabCharUtil.KASRA);
        jussiveLastDprList.add(ArabCharUtil.FATHA);
        jussiveLastDprList.add(ArabCharUtil.DAMMA);
        jussiveLastDprList.add(ArabCharUtil.SKOON);
        jussiveLastDprList.add(ArabCharUtil.SKOON);
        jussiveLastDprList.add(ArabCharUtil.SKOON);
        jussiveLastDprList.add(ArabCharUtil.FATHA);
        jussiveLastDprList.add(ArabCharUtil.FATHA);
        jussiveLastDprList.add(ArabCharUtil.DAMMA);
        jussiveLastDprList.add(ArabCharUtil.SKOON);

        jussiveConnectedPronounList.add("");
        jussiveConnectedPronounList.add("");
        jussiveConnectedPronounList.add("");
        jussiveConnectedPronounList.add("ي");
        jussiveConnectedPronounList.add("ا");
        jussiveConnectedPronounList.add("وا");
        jussiveConnectedPronounList.add("نَ");
        jussiveConnectedPronounList.add("");
        jussiveConnectedPronounList.add("");
        jussiveConnectedPronounList.add("ا");
        jussiveConnectedPronounList.add("ا");
        jussiveConnectedPronounList.add("وا");
        jussiveConnectedPronounList.add("نَ");

        emphasizedLastDprList.add(ArabCharUtil.FATHA);
        emphasizedLastDprList.add(ArabCharUtil.FATHA);
        emphasizedLastDprList.add(ArabCharUtil.FATHA);
        emphasizedLastDprList.add(ArabCharUtil.KASRA);
        emphasizedLastDprList.add(ArabCharUtil.FATHA);
        emphasizedLastDprList.add(ArabCharUtil.DAMMA);
        emphasizedLastDprList.add(ArabCharUtil.SKOON);
        emphasizedLastDprList.add(ArabCharUtil.FATHA);
        emphasizedLastDprList.add(ArabCharUtil.FATHA);
        emphasizedLastDprList.add(ArabCharUtil.FATHA);
        emphasizedLastDprList.add(ArabCharUtil.FATHA);
        emphasizedLastDprList.add(ArabCharUtil.DAMMA);
        emphasizedLastDprList.add(ArabCharUtil.SKOON);

        emphasizedConnectedPronounList.add("نَّ");
        emphasizedConnectedPronounList.add("نَّ");
        emphasizedConnectedPronounList.add("نَّ");
        emphasizedConnectedPronounList.add("نَّ");
        emphasizedConnectedPronounList.add("انِّ");
        emphasizedConnectedPronounList.add("نَّ");
        emphasizedConnectedPronounList.add("نَانِّ");
        emphasizedConnectedPronounList.add("نَّ");
        emphasizedConnectedPronounList.add("نَّ");
        emphasizedConnectedPronounList.add("انِّ");
        emphasizedConnectedPronounList.add("انِّ");
        emphasizedConnectedPronounList.add("نَّ");
        emphasizedConnectedPronounList.add("نَانِّ");
    }

    /**
     * الحصول  على حركة عين الفعل حسب باب تصريف الفعل
     *
     * @param root TripleVerb
     * @return String
     */
    public static String getDpr2(UnaugmentedTrilateralRoot root) {
        //بسبب أن ترقيم الباب التصريفي يبدأ من الواحد على حين أن القائمة تبدأ من الصفر جرى طرح العدد واحد
        return dpr2List.get(root.getConjugation().getValue() - 1);
    }

    /**
     * الحصول  على حرف المضارع حسب الضمير
     *
     * @param pronounIndex int
     * @return String
     */
    public static String getCp(int pronounIndex) {
        return cpList.get(pronounIndex);
    }
}
