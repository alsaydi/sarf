package sarf.substitution;

import sarf.Word;
import sarf.WordPresenter;
import sarf.verb.Root;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: فحص اذا كانت الكلمة تتضمن المقطع المخزن      </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class InfixSubstitution extends Substitution {

    public InfixSubstitution(String segment, String result) {
        super(segment, result);
    }

    @Override
    public WordPresenter apply(WordPresenter wordPresenter, Root root) {
        return wordPresenter.contains(segment) ? wordPresenter.replaceAll(segment,result): null;
    }
}
