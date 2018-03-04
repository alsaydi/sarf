package sarf;

import java.util.*;
import sarf.util.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: İÍÕ ÇáÌĞÑ ÇĞÇ ßÇä ããßäÇ ãÚÇáÌÊå     </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class Validator {
    private String arabicLetters = "ÍÎÏĞÑÒÓÔÕØÙÚÛİÖŞßáãäåæíÁÈÊËÌìÇ";
    private String hamzaString = "ÃÄÆÅ";

    private Validator() {
    }

    private static Validator instance = new Validator();

    public static Validator getInstance() {
        return instance;
    }

    /**
     * İÍÕ ÇáØæá 3  Ãæ 4
     * @param root String
     * @return boolean
     */
    public boolean checkLength(String root) {
        return root.length() == 3 || root.length() == 4;
    }

    /**
     * İÍÕ ÇĞÇ ßÇäÊ ÇÍÑİ ÇáÌĞÑ åí ÃÍÑİ ÕÍíÍÉ
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
     * İÍÕ ÇĞÇ ßÇä ÇáÌĞÑ íÈÏÃ ÈÃáİ
     * @param root String
     * @return boolean
     */
    public boolean checkStartedWithAlef(String root) {
        return root.charAt(0) == 'Ç';
    }

    /**
     * İÍÕ ÇĞÇ ßÇä ÇáÌĞÑ íÍÊæí Ãáİ ããÏæÏÉ
     * @param root String
     * @return boolean
     */
    public boolean checkAlefMamdoda(String root) {
        return root.indexOf("Â") != -1;
    }

    /**
     * İÍÕ ÇĞÇ ßÇä ÇáÌĞÑ íÍÊæí ÚáÇãÇÊ ÊÔßíá
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
     * ÑÏ ÇáåãÒÉ Åáì ÃÕáåÇ ÍÓÈ ÃæÌååÇ ÇáÎãÓÉ
     * @param root String
     * @return String
     */
    public String correctHamza(String root) {
        char[] rootArray = root.toCharArray();
        for (int i = 0; i < rootArray.length; i++) {
            if (hamzaString.indexOf(rootArray[i]) != -1) {
                rootArray[i] = 'Á';
            }
        }
        return new String(rootArray);
    }

    /**
     * İÍÕ ÇĞÇ ÇßäÊ ÇáÃáİ Öãä ÇáÌĞÑ İí ÇáÍÑİ ÇáËÇäí Ãæ ÇáËÇáË
     * İÊÑÏ ÇááÃİ Åáì ÃÕáåÇ İí ÇáæÇæ Ãæ ÇáíÇÁ
     * @param root String
     * @return List
     */
    public List getTrilateralAlefAlternatives(String root) {
        List result = new LinkedList();
        if (root.charAt(1) == 'Ç' && (root.charAt(2) == 'Ç' || root.charAt(2) == 'ì')) {
            result.add(root.charAt(0) + "æ" + "æ");
            result.add(root.charAt(0) + "æ" + "í");
            result.add(root.charAt(0) + "í" + "æ");
            result.add(root.charAt(0) + "í" + "í");
        }
        else {
            if (root.charAt(1) == 'Ç') {
                result.add(root.charAt(0) + "æ" + root.charAt(2));
                result.add(root.charAt(0) + "í" + root.charAt(2));
            }
            if (root.charAt(2) == 'Ç' || root.charAt(2) == 'ì') {
                result.add(root.charAt(0) + "" + root.charAt(1) + "æ");
                result.add(root.charAt(0) + "" + root.charAt(1) + "í");
            }
        }
        return result;
    }


    /**
     * İÍÕ ÇĞÇ ÇßäÊ ÇáÃáİ Öãä ÇáÌĞÑ İí ÇáÍÑİ ÇáËÇäí Ãæ ÇáËÇáË
     * İÊÑÏ ÇááÃİ Åáì ÃÕáåÇ İí ÇáæÇæ Ãæ ÇáíÇÁ
     * æÇĞÇ ßÇäÊ İí ÇáÑÇÈÚ ÊİÑÏ Åáì íÇÁ
     * @param root String
     * @return List
     */
    public List getQuadrilateralAlefAlternatives(String root) {
        List result = new LinkedList();
        if (root.charAt(1) == 'Ç') {
            result.add(root.charAt(0) + "æ" + root.charAt(2) + root.charAt(3));
            result.add(root.charAt(0) + "í" + root.charAt(2) + root.charAt(3));
        }
        if (root.charAt(2) == 'Ç') {
            result.add(root.charAt(0) + "" + root.charAt(1) + "æ" + root.charAt(3));
            result.add(root.charAt(0) + "" + root.charAt(1) + "í" + root.charAt(3));
        }

        if (root.charAt(3) == 'Ç' || root.charAt(3) == 'ì') {
            result.add(root.charAt(0) + "" + root.charAt(1) + "" + root.charAt(2) + "í");
        }
        return result;
    }
}
