package sarf.verb.trilateral.Substitution;

import sarf.verb.trilateral.TrilateralRoot;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: فحص اذا كانت الكلمة تنتهي بالمقطع المخزن      </p>
 * بعد تعويض كل حرف من الجذر في المقطع
 * </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class ExpressionSuffixSubstitution extends Substitution {

    public ExpressionSuffixSubstitution(String segment, String result) {
        super(segment, result);
    }

    /**
     *
     * @param word String
     * @return String
     */
    public String apply(String word, TrilateralRoot root) {
        String wordSegment = segment.replaceAll("C1",root.getC1()+"");
        wordSegment = wordSegment.replaceAll("C2",root.getC2()+"");
        wordSegment = wordSegment.replaceAll("C3",root.getC3()+"");

        if (!word.endsWith(wordSegment)) return null;

        String replacedResult = result.replaceAll("C1",root.getC1()+"");
        replacedResult = replacedResult.replaceAll("C2",root.getC2()+"");
        replacedResult = replacedResult.replaceAll("C3",root.getC3()+"");

        return word.replaceAll(wordSegment,replacedResult);
    }
}
