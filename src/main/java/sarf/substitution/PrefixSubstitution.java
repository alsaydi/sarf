package sarf.substitution;

import sarf.Word;
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
    public Word apply(Word word, Root root) {
        return word.startsWith(segment)? word.replaceFirst(segment,result): null;
    }
}
