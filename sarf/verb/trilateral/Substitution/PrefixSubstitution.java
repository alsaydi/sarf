package sarf.verb.trilateral.Substitution;

import sarf.verb.trilateral.TrilateralRoot;

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
    public String apply(String word, TrilateralRoot root) {
        return word.startsWith(segment)? word.replaceFirst(segment,result): null;
    }
}
