package sarf;

import java.util.*;
import java.util.stream.IntStream;

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
    private final String arabicLetters = "حخدذرزسشصطظعغفضقكلمنهويءبتثجىا";
    private final String hamzaString = "أؤئإ";

    public Validator() {
    }

    /**
     * فحص الطول 3  أو 4
     * @param root String
     * @return boolean
     */
    public boolean checkLength(String root) {
        return root != null && (root.length() == 3 || root.length() == 4);
    }

    /**
     * فحص اذا كانت احرف الجذر هي أحرف صحيحة
     * @param root String
     * @return boolean
     */
    public boolean checkArabicLetters(String root) {
    	if(root == null)
    		return false;

        return IntStream.range(0, root.length())
                .noneMatch(i -> arabicLetters.indexOf(root.charAt(i)) == -1);
    }

    /**
     * فحص اذا كان الجذر يبدأ بألف
     * @param root String
     * @return boolean
     */
    public boolean checkStartedWithAlef(String root) {
        return root != null && root.length() > 0 && root.charAt(0) == 'ا';
    }

    /**
     * فحص اذا كان الجذر يحتوي ألف ممدودة
     * @param root String
     * @return boolean
     */
    public boolean checkAlefMamdoda(String root) {
        return root != null && root.contains("آ");
    }

    /**
     * فحص اذا كان الجذر يحتوي علامات تشكيل
     * @param root String
     * @return boolean
     */
    public boolean checkTashkil(String root) {
        if (root == null)
            return false;

        return
                root.contains(ArabCharUtil.FATHA) ||
                        root.contains(ArabCharUtil.DAMMA) ||
                        root.contains(ArabCharUtil.KASRA) ||
                        root.contains(ArabCharUtil.SKOON) ||
                        root.contains(ArabCharUtil.SHADDA);
    }


    /**
     * رد الهمزة إلى أصلها حسب أوجهها الخمسة
     * @param root String
     * @return String
     */
    public String correctHamza(String root) {
    	if(root == null)
    		return null;
    	
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
        boolean endsInAlefOrYa = root.charAt(2) == 'ا' || root.charAt(2) == 'ى';
        if (root.charAt(1) == 'ا' && (endsInAlefOrYa)) {
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
            if (endsInAlefOrYa) {
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
    public List<String> getQuadrilateralAlefAlternatives(String root) {
        List<String> result = new LinkedList<>();
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
