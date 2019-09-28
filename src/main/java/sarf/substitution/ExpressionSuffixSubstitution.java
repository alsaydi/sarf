package sarf.substitution;

import sarf.Word;
import sarf.verb.Root;

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
    @Override
    public Word apply(Word word, Root root) {
        if(null == word || word.isEmpty())
            return  null;

        String wordSegment = buildSubstitution(root, segment);
        if (!word.endsWith(wordSegment)) return null;

        String replacedResult = buildSubstitution(root, result);

        return word.replaceAll(wordSegment,replacedResult);
    }
}
