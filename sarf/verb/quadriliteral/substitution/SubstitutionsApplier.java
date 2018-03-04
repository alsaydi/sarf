package sarf.verb.quadriliteral.substitution;

import java.util.*;
import sarf.verb.quadriliteral.*;

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
public abstract class SubstitutionsApplier {

    public SubstitutionsApplier() {

    }

    /**
     * Õ·ﬁ…  „”Õ «·ﬂ·„«  Ê Ã—» «·«” »œ·«  ⁄·Ï ﬂ·  ﬂ·„…
     * «–« ‰ÃÕ √Õœ «·«” »œ«·«  ·« ‰»ÕÀ ⁄‰ √Œ—
     * @param words List
     */
    public void apply(List words, QuadrilateralRoot root) {
        for (int i=0; i< getAppliedPronounsIndecies().size(); i++) {
            int index = Integer.parseInt(getAppliedPronounsIndecies().get(i).toString())-1;
            Object wordObj = words.get(index);
            if (wordObj == null) {
                continue;
            }
            String word = wordObj.toString().trim();

            Iterator subIter = getSubstitutions().iterator();
            while (subIter.hasNext()) {
                Substitution substitution = (Substitution) subIter.next();
                String result = substitution.apply(word, root);
                if (result != null) {
                    // »œÌ· «·ﬂ·„… «·ÃœÌœ… «·„” »œ·… »«·ﬂ·„… «·ﬁœÌ„…
                    words.set(i, result);
                    //·« œ«⁄Ì ·›Õ’ »«ﬁÌ «·«” »œ«·« 
                    break;
                }
            }
        }
    }

    /**
     * ﬁ«∆„… «·«” »œ«·« 
     * @return List
     */
    public abstract List getSubstitutions();

    protected static List defaultAppliedProunounsIndecies = new ArrayList(13);
    static {
        for (int i=0; i<13; i++) {
            defaultAppliedProunounsIndecies.add(i+1 +"");
        }
    }


    protected List getAppliedPronounsIndecies() {
        return defaultAppliedProunounsIndecies;
    }

}
