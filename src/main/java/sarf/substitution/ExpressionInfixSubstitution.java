package sarf.substitution;

import sarf.verb.Root;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: فحص اذا كانت الكلمة تتضمن المقطع المخزن      </p>
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
public class ExpressionInfixSubstitution extends Substitution {

    public ExpressionInfixSubstitution(String segment, String result) {
        super(segment, result);
    }

    public String apply(String word, Root root) {
        if(word == null || word.equals(""))
            return null;

        var wordSegment = buildSubstitution(root, segment);
        if(!word.contains(wordSegment))
            return null;

        String replacedResult = buildSubstitution(root, result);

        return word.replaceAll(wordSegment,replacedResult);
    }
}
