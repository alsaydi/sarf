package sarf.verb.trilateral.Substitution;

import sarf.verb.Root;
import sarf.verb.trilateral.TrilateralRoot;

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
    public String apply(String word, Root root) {
        return word.startsWith(segment)? word.replaceFirst(segment,result): null;
    }
}
