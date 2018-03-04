package sarf.gerund.modifier.quadrilateral;

import java.util.*;
import sarf.verb.quadriliteral.*;
import sarf.verb.quadriliteral.substitution.Substitution;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public abstract class SlashSubstitutionsApplier {

    public SlashSubstitutionsApplier() {

    }

    /**
     * Õ·ﬁ…  „”Õ «·ﬂ·„«  Ê Ã—» «·«” »œ·«  ⁄·Ï ﬂ·  ﬂ·„…
     * «–« ‰ÃÕ √Õœ «·«” »œ«·«  ·« ‰»ÕÀ ⁄‰ √Œ—
     * @param words List
     */
    public void apply(List words, QuadrilateralRoot root) {
        for (int index = 0; index < 18; index++) {
            Object wordObj = words.get(index);
            if (wordObj == null) {
                //Õ«·… «·›⁄· √„—
                continue;
            }
            String word = wordObj.toString().trim();
            if (word.indexOf("/") != -1) {
                StringTokenizer tokenizer = new StringTokenizer(word);
                String word1 = tokenizer.nextToken().trim();
                String newWord1 = apply(word1, root);
                newWord1 = newWord1 == null ? word1 : newWord1;

                tokenizer.nextToken(); // to discard the /
                String word2 = tokenizer.nextToken().trim();
                String newWord2 = apply(word2, root);
                newWord2 = newWord2 == null? word2: newWord2;

                words.set(index, newWord1 + " / " + newWord2);
            }
            else {
                String result = apply(word, root);
                if (result != null) {
                    // »œÌ· «·ﬂ·„… «·ÃœÌœ… «·„” »œ·… »«·ﬂ·„… «·ﬁœÌ„…
                    words.set(index, result);
                    //·« œ«⁄Ì ·›Õ’ »«ﬁÌ «·«” »œ«·« 
                }
            }
        }
    }

    private String apply(String word, QuadrilateralRoot root) {
        Iterator subIter = getSubstitutions().iterator();
        while (subIter.hasNext()) {
            Substitution substitution = (Substitution) subIter.next();
            String result = substitution.apply(word, root);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    /**
     * ﬁ«∆„… «·«” »œ«·« 
     * @return List
     */
    public abstract List getSubstitutions();

}
