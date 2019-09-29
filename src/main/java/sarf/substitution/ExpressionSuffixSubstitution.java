package sarf.substitution;

import sarf.WordPresenter;
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

    @Override
    public WordPresenter apply(WordPresenter wordPresenter, Root root) {
        if (null == wordPresenter || wordPresenter.isEmpty()) {
            return null;
        }

        String wordSegment = buildSubstitution(root, segment);
        if (!wordPresenter.endsWith(wordSegment)) {
            return null;
        }

        String replacedResult = buildSubstitution(root, result);

        return wordPresenter.replaceAll(wordSegment, replacedResult);
    }
}
