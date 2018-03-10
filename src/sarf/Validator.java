package sarf;

import java.util.*;
import sarf.util.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: فحص الجذر اذا كان ممكنا معالجته     </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class Validator {
    private String arabicLetters = "حخدذرزسشصطظعغفضقكلمنهويءبتثجىا";
    private String hamzaString = "أؤئإ";

    private Validator() {
    }

    private static Validator instance = new Validator();

    public static Validator getInstance() {
        return instance;
    }

    /**
     * فحص الطول 3  أو 4
     * @param root String
     * @return boolean
     */
    public boolean checkLength(String root) {
        return root.length() == 3 || root.length() == 4;
    }

    /**
     * فحص اذا كانت احرف الجذر هي أحرف صحيحة
     * @param root String
     * @return boolean
     */
    public boolean checkArabicLetters(String root) {
        for (int i = 0; i < root.length(); i++) {
            if (arabicLetters.indexOf(root.charAt(i)) == -1) {
                return false;
            }
        }
        return true;
    }

    /**
     * فحص اذا كان الجذر يبدأ بألف
     * @param root String
     * @return boolean
     */
    public boolean checkStartedWithAlef(String root) {
        return root.charAt(0) == 'ا';
    }

    /**
     * فحص اذا كان الجذر يحتوي ألف ممدودة
     * @param root String
     * @return boolean
     */
    public boolean checkAlefMamdoda(String root) {
        return root.indexOf("آ") != -1;
    }

    /**
     * فحص اذا كان الجذر يحتوي علامات تشكيل
     * @param root String
     * @return boolean
     */
    public boolean checkTashkil(String root) {
        return
                root.indexOf(ArabCharUtil.FATHA) != -1 ||
                root.indexOf(ArabCharUtil.DAMMA) != -1 ||
                root.indexOf(ArabCharUtil.KASRA) != -1 ||
                root.indexOf(ArabCharUtil.SKOON) != -1 ||
                root.indexOf(ArabCharUtil.SHADDA) != -1;
    }


    /**
     * رد الهمزة إلى أصلها حسب أوجهها الخمسة
     * @param root String
     * @return String
     */
    public String correctHamza(String root) {
        char[] rootArray = root.toCharArray();
        for (int i = 0; i < rootArray.length; i++) {
            if (hamzaString.indexOf(rootArray[i]) != -1) {
                rootArray[i] = 'ء';
            }
        }
        return new String(rootArray);
    }

    /**
     * فحص اذا اكنت الألف ضمن الجذر في الحرف الثاني أو الثالث
     * فترد اللأف إلى أصلها في الواو أو الياء
     * @param root String
     * @return List
     */
    public List<String> getTrilateralAlefAlternatives(String root) {
        List<String> result = new LinkedList<>();
        if (root.charAt(1) == 'ا' && (root.charAt(2) == 'ا' || root.charAt(2) == 'ى')) {
            result.add(root.charAt(0) + "و" + "و");
            result.add(root.charAt(0) + "و" + "ي");
            result.add(root.charAt(0) + "ي" + "و");
            result.add(root.charAt(0) + "ي" + "ي");
        }
        else {
            if (root.charAt(1) == 'ا') {
                result.add(root.charAt(0) + "و" + root.charAt(2));
                result.add(root.charAt(0) + "ي" + root.charAt(2));
            }
            if (root.charAt(2) == 'ا' || root.charAt(2) == 'ى') {
                result.add(root.charAt(0) + "" + root.charAt(1) + "و");
                result.add(root.charAt(0) + "" + root.charAt(1) + "ي");
            }
        }
        return result;
    }


    /**
     * فحص اذا اكنت الألف ضمن الجذر في الحرف الثاني أو الثالث
     * فترد اللأف إلى أصلها في الواو أو الياء
     * واذا كانت في الرابع تفرد إلى ياء
     * @param root String
     * @return List
     */
    public List getQuadrilateralAlefAlternatives(String root) {
        List result = new LinkedList();
        if (root.charAt(1) == 'ا') {
            result.add(root.charAt(0) + "و" + root.charAt(2) + root.charAt(3));
            result.add(root.charAt(0) + "ي" + root.charAt(2) + root.charAt(3));
        }
        if (root.charAt(2) == 'ا') {
            result.add(root.charAt(0) + "" + root.charAt(1) + "و" + root.charAt(3));
            result.add(root.charAt(0) + "" + root.charAt(1) + "ي" + root.charAt(3));
        }

        if (root.charAt(3) == 'ا' || root.charAt(3) == 'ى') {
            result.add(root.charAt(0) + "" + root.charAt(1) + "" + root.charAt(2) + "ي");
        }
        return result;
    }
}
