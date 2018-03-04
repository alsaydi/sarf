package sarf.verb.trilateral.Substitution;

import sarf.verb.trilateral.TrilateralRoot;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: ›Õ’ «–« ﬂ«‰  «·ﬂ·„…  ‰ ÂÌ »«·„ﬁÿ⁄ «·„Œ“‰      </p>
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

    /**
     *
     * @param word String
     * @return String
     */
    public String apply(String word, TrilateralRoot root) {
        if (word.endsWith(segment)) {
            int changeIndex = word.lastIndexOf(segment);
            //String replacement = word.substring(changeIndex, word.length());
            //replacement.replaceAll(segment, result);
            return word.substring(0,changeIndex) + result;
        }
        return  null;
    }
}
