package sarf;

import java.util.*;

import com.google.inject.Singleton;
import sarf.util.ArabCharUtil;
import sarf.verb.trilateral.unaugmented.*;

/**
 * يحتوي على  المعلومات  الصرفية المطلوبة لتصريف الأفعال  في الماضي
 * <p>Title: Sarf</p>
 * <p>Description: برنامج التصريف</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */

@Singleton
public class PastConjugationDataContainer {
    //قائمة حركات عين الفعل حسب باب التصريف
    private final List<String> dpa2List = new ArrayList<>(6);
    //قائمة  حركات لام الفعل حسب ضمير الرفع
    private final List<String> lastDpaList = new ArrayList<>(SystemConstants.PRONOUN_RANGE_END);
    //قائمة ضمائر الرفع المتصلة
    private final List<String> connectedPronounsList = new ArrayList<>(SystemConstants.PRONOUN_RANGE_END);

    public PastConjugationDataContainer() {
        //تهيئة القيم
        dpa2List.add(ArabCharUtil.FATHA);
        dpa2List.add(ArabCharUtil.FATHA);
        dpa2List.add(ArabCharUtil.FATHA);
        dpa2List.add(ArabCharUtil.KASRA);
        dpa2List.add(ArabCharUtil.DAMMA);
        dpa2List.add(ArabCharUtil.KASRA);

        lastDpaList.add(ArabCharUtil.SKOON);
        lastDpaList.add(ArabCharUtil.SKOON);
        lastDpaList.add(ArabCharUtil.SKOON);
        lastDpaList.add(ArabCharUtil.SKOON);
        lastDpaList.add(ArabCharUtil.SKOON);
        lastDpaList.add(ArabCharUtil.SKOON);
        lastDpaList.add(ArabCharUtil.SKOON);
        lastDpaList.add(ArabCharUtil.FATHA);
        lastDpaList.add(ArabCharUtil.FATHA);
        lastDpaList.add(ArabCharUtil.FATHA);
        lastDpaList.add(ArabCharUtil.FATHA);
        lastDpaList.add(ArabCharUtil.DAMMA);
        lastDpaList.add(ArabCharUtil.SKOON);

        connectedPronounsList.add("تُ");
        connectedPronounsList.add("نَا");
        connectedPronounsList.add("تَ");
        connectedPronounsList.add("تِ");
        connectedPronounsList.add("تُمَا");
        connectedPronounsList.add("تُمْ");
        connectedPronounsList.add("تُنَّ");
        connectedPronounsList.add("");
        connectedPronounsList.add("تْ");
        connectedPronounsList.add("ا");
        connectedPronounsList.add("تَا");
        connectedPronounsList.add("وا");
        connectedPronounsList.add("نَ");
        connectedPronounsList.add("تُ");
    }

    /**
     * الحصول  على حركة عين الفعل حسب باب تصريف الفعل
     * @param root TripleVerb
     * @return String
     */
    public String getDpa2(UnaugmentedTrilateralRoot root) {
        //بسبب أن ترقيم الباب التصريفي يبدأ من الواحد على حين أن القائمة تبدأ من الصفر جرى طرح العدد واحد
        return dpa2List.get(root.getConjugation().getValue()-1);
    }

    /**
     *  الحصول  على  حركة لام الفعل حسب الضمير
     * @param pronounIndex int
     * @return String
     */
    public String getLastDpa(int pronounIndex) {
        return lastDpaList.get(pronounIndex);
    }

    /**
     *الحصول على ضمائر الرفع المتصلة
     * @param pronounIndex int
     * @return String
     */
    public String getConnectedPronoun(int pronounIndex) {
        return connectedPronounsList.get(pronounIndex);
    }
}
