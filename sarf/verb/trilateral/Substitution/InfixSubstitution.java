package sarf.verb.trilateral.Substitution;

import sarf.verb.trilateral.TrilateralRoot;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: ›Õ’ «–« ﬂ«‰  «·ﬂ·„…   ÷„‰ «·„ﬁÿ⁄ «·„Œ“‰      </p>
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

    /**
     *
     * @param word String
     * @return String
     */
    public String apply(String word, TrilateralRoot root) {
        return word.indexOf(segment) != -1? word.replaceAll(segment,result): null;
    }
}
