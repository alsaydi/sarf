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
    public abstract boolean isApplied(ConjugationResult conjugationResult);
    /**
     * حلقة تمسح الكلمات وتجرب الاستبدلات على كل  كلمة
     * اذا نجح أحد الاستبدالات لا نبحث عن أخر
     * @param words List
     */
    public void apply(List words, QuadrilateralRoot root) {
        for (int i = 0; i< getAppliedPronounsIndexes().size(); i++) {
            int index = Integer.parseInt(getAppliedPronounsIndexes().get(i).toString())-1;
            Object wordObj = words.get(index);
            if (wordObj == null) {
                continue;
            }
            String word = wordObj.toString().trim();

            for (Object o : getSubstitutions()) {
                Substitution substitution = (Substitution) o;
                String result = substitution.apply(word, root);
                if (result != null) {
                    //تبديل الكلمة الجديدة المستبدلة بالكلمة القديمة
                    words.set(i, result);
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
    public abstract List getSubstitutions();

    private static final List<String> defaultAppliedPronounsIndexes = new ArrayList<>(13);
    static {
        for (int i=0; i<13; i++) {
            defaultAppliedPronounsIndexes.add(i+1 +"");
        }
    }

    protected List<String> getAppliedPronounsIndexes() {
        return defaultAppliedPronounsIndexes;
    }
}
