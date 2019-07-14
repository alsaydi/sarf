
package sarf.verb.trilateral.Substitution;

import java.util.*;
import sarf.verb.trilateral.*;

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

    protected static List<String> defaultAppliedProunounsIndecies = new ArrayList<String>(13);
    static {
        for (int i=0; i<13; i++) {
            defaultAppliedProunounsIndecies.add(i+1 +"");
        }
    }

    public SubstitutionsApplier() {

    }

    /**
     * حلقة تمسح الكلمات وتجرب الاستبدلات على كل  كلمة
     * اذا نجح أحد الاستبدالات لا نبحث عن أخر
     * @param words List
     * @param root TrilateralRoot
     */
    public void apply(List<String> words, TrilateralRoot root) {
        for (int i=0; i< getAppliedPronounsIndecies().size(); i++) {
            int index = Integer.parseInt(getAppliedPronounsIndecies().get(i).toString())-1;
            Object wordObj = words.get(index);
            if (wordObj == null) {
                continue;
            }
            String word = wordObj.toString().trim();

            Iterator<Substitution> subIter = getSubstitutions().iterator();
            while (subIter.hasNext()) {
                Substitution substitution = subIter.next();
                String result = substitution.apply(word, root);
                if (result != null) {
                    //تبديل الكلمة الجديدة المستبدلة بالكلمة القديمة
                    words.set(index, result);
                    //لا داعي لفحص باقي الاستبدالات
                    break;
                }
            }
        }
    }

    /**
     * قائمة الاستبدالات
     * @return List
     */
    public abstract List<Substitution> getSubstitutions();

    protected List<String> getAppliedPronounsIndecies() {
        return defaultAppliedProunounsIndecies;
    }


}
