package sarf.substitution;

import sarf.WordPresenter;
import sarf.verb.Root;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: فحص اذا كانت الكلمة تبتدأ بالمقطع المخزن      </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class PrefixSubstitution extends Substitution {

    public PrefixSubstitution(String segment, String result) {
        super(segment, result);
    }

    @Override
    public WordPresenter apply(WordPresenter wordPresenter, Root root) {
        return wordPresenter.startsWith(segment)? wordPresenter.replaceFirst(segment,result): null;
    }
}
