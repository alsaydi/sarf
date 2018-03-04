package sarf.verb.quadriliteral.substitution;

import sarf.verb.quadriliteral.QuadrilateralRoot;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: ›Õ’ «–« ﬂ«‰  «·ﬂ·„…  » œ√ »«·„ﬁÿ⁄ «·„Œ“‰      </p>
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

    /**
     *
     * @param word String
     * @return String
     */
    public String apply(String word, QuadrilateralRoot root) {
        return word.startsWith(segment)? word.replaceAll(segment,result): null;
    }
}
