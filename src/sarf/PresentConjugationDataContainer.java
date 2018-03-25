package sarf;

import java.util.*;

import sarf.util.*;
import sarf.verb.trilateral.*;
import sarf.verb.trilateral.unaugmented.*;

/**
 * يحتوي على  المعلومات  الصرفية المطلوبة لتصريف الأفعال  في المضارع
 * <p>Title: Sarf</p>
 * <p>Description: برنامج التصريف</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class PresentConjugationDataContainer {
    //أحرف المضارعة حسب الضمير
    private List<String> cpList = new ArrayList<>(13);
    //قائمة حركات عين الفعل حسب باب التصريف
    private List<String> dpr2List = new ArrayList<>(6);

    //قائمة  حركات لام الفعل حسب ضمير الرفع
    //مرفوع
    private List<String> nominativeLastDprList = new ArrayList<>(13);
    //منصوب
    private List<String> accusativeLastDprList = new ArrayList<>(13);
    //مجزوم
    private List<String> jussiveLastDprList = new ArrayList<>(13);
    //مؤكد
    private List<String> emphasizedLastDprList = new ArrayList<>(13);

    //قائمة ضمائر الرفع المتصلة
    //مرفوع
    private List<String> nominativeConnectedPronounList = new ArrayList<>(13);
    //منصوب
    private List<String> accusativeConnectedPronounList = new ArrayList<>(13);
    //مجزوم
    private List<String> jussiveConnectedPronounList = new ArrayList<>(13);
    //مؤكد
    private List<String> emphasizedConnectedPronounList = new ArrayList<>(13);

    private static PresentConjugationDataContainer instance = new PresentConjugationDataContainer();

    public static PresentConjugationDataContainer getInstance() {
        return instance;
    }

    public List<String> getNominativeLastDprList() {
        return nominativeLastDprList;
    }

    public List<String> getNominativeConnectedPronounList() {
        return nominativeConnectedPronounList;
    }

    public List<String> getEmphasizedLastDprList() {
        return emphasizedLastDprList;
    }

    public List<String> getEmphasizedConnectedPronounList() {
        return emphasizedConnectedPronounList;
    }

    public List<String> getJussiveLastDprList() {
        return jussiveLastDprList;
    }

    public List<String> getJussiveConnectedPronounList() {
        return jussiveConnectedPronounList;
    }

    public List<String> getAccusativeLastDprList() {
        return accusativeLastDprList;
    }

    public List<String> getAccusativeConnectedPronounList() {
        return accusativeConnectedPronounList;
    }

    private PresentConjugationDataContainer() {
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
     * @param root TripleVerb
     * @return String
     */
    public String getDpr2(UnaugmentedTrilateralRoot root) {
        //بسبب أن ترقيم الباب التصريفي يبدأ من الواحد على حين أن القائمة تبدأ من الصفر جرى طرح العدد واحد
        return (String) dpr2List.get((Integer.parseInt(root.getConjugation()) - 1));
    }


    /**
     * الحصول  على حرف المضارع حسب الضمير
     * @param pronounIndex int
     * @return String
     */
    public String getCp(int pronounIndex) {
        return cpList.get(pronounIndex);
    }
}
