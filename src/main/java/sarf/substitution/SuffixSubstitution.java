package sarf.substitution;

import sarf.Word;
import sarf.WordPresenter;
import sarf.verb.Root;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: فحص اذا كانت الكلمة تنتهي بالمقطع المخزن      </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class SuffixSubstitution extends Substitution {

    public SuffixSubstitution(String segment, String result) {
        super(segment, result);
    }

    @Override
    public WordPresenter apply(WordPresenter wordPresenter, Root root) {
        if (wordPresenter.endsWith(segment)) {
            int changeIndex = wordPresenter.lastIndexOf(segment);
            //String replacement = word.substring(changeIndex, word.length());
            //replacement.replaceAll(segment, result);
            return wordPresenter.substring(0,changeIndex).append(result);
        }
        return  WordPresenter.Empty;
    }
}
