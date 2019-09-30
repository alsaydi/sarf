package sarf;

import java.util.*;
import sarf.util.*;

/**
 *  يحتوي على  المعلومات  الصرفية المطلوبة لتصريف الأفعال  في الأمر
 * <p>Title: Sarf</p>
 * <p>Description: برنامج التصريف</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public final class ImperativeConjugationDataContainer {

    //قائمة حركات عين الفعل حسب باب التصريف
    //الأمر غير المؤكد
    private static final List<String> lastDimList = new ArrayList<>(SystemConstants.PRONOUN_RANGE_END);
    //الأمر المؤكد
    private static final List<String> emphasizedLastDimList = new ArrayList<>(SystemConstants.PRONOUN_RANGE_END);

    //قائمة ضمائر الرفع المتصلة
    //الأمر غير المؤكد
    private static final List<String> connectedPronounList = new ArrayList<>(SystemConstants.PRONOUN_RANGE_END);
    //الأمر المؤكد
    private static final List<String> emphasizedConnectedPronounList = new ArrayList<>(SystemConstants.PRONOUN_RANGE_END);

    public static List<String> getEmphasizedConnectedPronounList() {
        return Collections.unmodifiableList(emphasizedConnectedPronounList);
    }

    public static List<String> getEmphasizedLastDimList() {
        return Collections.unmodifiableList(emphasizedLastDimList);
    }

    public static List<String> getConnectedPronounList() {
        return Collections.unmodifiableList(connectedPronounList);
    }

    public static List<String> getLastDimList() {
        return Collections.unmodifiableList(lastDimList);
    }

    static {
        lastDimList.add("");
        lastDimList.add("");
        lastDimList.add(ArabCharUtil.SKOON);
        lastDimList.add(ArabCharUtil.KASRA);
        lastDimList.add(ArabCharUtil.FATHA);
        lastDimList.add(ArabCharUtil.DAMMA);
        lastDimList.add(ArabCharUtil.SKOON);
        lastDimList.add("");
        lastDimList.add("");
        lastDimList.add("");
        lastDimList.add("");
        lastDimList.add("");
        lastDimList.add("");

        connectedPronounList.add("");
        connectedPronounList.add("");
        connectedPronounList.add("");
        connectedPronounList.add("ي");
        connectedPronounList.add("ا");
        connectedPronounList.add("وا");
        connectedPronounList.add("نَ");
        connectedPronounList.add("");
        connectedPronounList.add("");
        connectedPronounList.add("");
        connectedPronounList.add("");
        connectedPronounList.add("");
        connectedPronounList.add("");

        emphasizedLastDimList.add("");
        emphasizedLastDimList.add("");
        emphasizedLastDimList.add(ArabCharUtil.FATHA);
        emphasizedLastDimList.add(ArabCharUtil.KASRA);
        emphasizedLastDimList.add(ArabCharUtil.FATHA);
        emphasizedLastDimList.add(ArabCharUtil.DAMMA);
        emphasizedLastDimList.add(ArabCharUtil.SKOON);
        emphasizedLastDimList.add("");
        emphasizedLastDimList.add("");
        emphasizedLastDimList.add("");
        emphasizedLastDimList.add("");
        emphasizedLastDimList.add("");
        emphasizedLastDimList.add("");

        emphasizedConnectedPronounList.add("");
        emphasizedConnectedPronounList.add("");
        emphasizedConnectedPronounList.add("نَّ");
        emphasizedConnectedPronounList.add("نَّ");
        emphasizedConnectedPronounList.add("انِّ");
        emphasizedConnectedPronounList.add("نَّ");
        emphasizedConnectedPronounList.add("نَانِّ");
        emphasizedConnectedPronounList.add("");
        emphasizedConnectedPronounList.add("");
        emphasizedConnectedPronounList.add("");
        emphasizedConnectedPronounList.add("");
        emphasizedConnectedPronounList.add("");
        emphasizedConnectedPronounList.add("");
    }

    /**
     *  الحصول  على  حركة لام الفعل حسب الضمير
     * الأمر غير المؤكد
     * @param pronounIndex int
     * @return String
     */
    public static String getLastDim(int pronounIndex) {
        return lastDimList.get(pronounIndex);
    }

    /**
     *  الحصول  على  حركة لام الفعل حسب الضمير
     * الأمر  المؤكد
     * @param pronounIndex int
     * @return String
     */
    public static String getEmphasizedLastDim(int pronounIndex) {
        return emphasizedLastDimList.get(pronounIndex);
    }

    /**
     *الحصول على ضمائر الرفع المتصلة
     * الأمر غير المؤكد
     * @param pronounIndex int
     * @return String
     */
    public static String getConnectedPronoun(int pronounIndex) {
        return connectedPronounList.get(pronounIndex);
    }

    /**
     *الحصول على ضمائر الرفع المتصلة
     * الأمر  المؤكد
     * @param pronounIndex int
     * @return String
     */
    public static String getEmphasizedConnectedPronoun(int pronounIndex) {
        return emphasizedConnectedPronounList.get(pronounIndex);
    }
}
