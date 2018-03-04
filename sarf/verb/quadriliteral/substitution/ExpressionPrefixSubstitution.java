package sarf.verb.quadriliteral.substitution;

import sarf.verb.quadriliteral.QuadrilateralRoot;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: ›Õ’ «–« ﬂ«‰  «·ﬂ·„…  » œ√ »«·„ﬁÿ⁄ «·„Œ“‰
 * »⁄œ  ⁄ÊÌ÷ ﬂ· Õ—› „‰ «·Ã–— ›Ì «·„ﬁÿ⁄
 * </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class ExpressionPrefixSubstitution extends Substitution {

    public ExpressionPrefixSubstitution(String segment, String result) {
        super(segment, result);
    }

    /**
     *
     * @param word String
     * @return String
     */
    public String apply(String word, QuadrilateralRoot root) {
        String wordSegment = segment.replaceAll("C1",root.getC1()+"");
        wordSegment = wordSegment.replaceAll("C2",root.getC2()+"");
        wordSegment = wordSegment.replaceAll("C3",root.getC3()+"");
        wordSegment = wordSegment.replaceAll("C4",root.getC4()+"");

        if (!word.startsWith(wordSegment)) return null;

        String replacedResult = result.replaceAll("C1",root.getC1()+"");
        replacedResult = replacedResult.replaceAll("C2",root.getC2()+"");
        replacedResult = replacedResult.replaceAll("C3",root.getC3()+"");
        replacedResult = replacedResult.replaceAll("C4",root.getC4()+"");

        return word.replaceAll(wordSegment,replacedResult);

    }
}
