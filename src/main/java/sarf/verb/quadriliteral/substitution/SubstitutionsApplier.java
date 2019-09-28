package sarf.verb.quadriliteral.substitution;

import sarf.verb.Root;
import sarf.verb.trilateral.Substitution.Substitution;
import sarf.verb.trilateral.augmented.ConjugationResult;

import java.util.ArrayList;
import java.util.List;

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
public abstract class SubstitutionsApplier<T> {
    public abstract boolean isApplied(ConjugationResult<T> conjugationResult);

    public abstract List<Substitution> getSubstitutions();

    private static final List<String> defaultAppliedPronounsIndexes = new ArrayList<>(13);

    static {
        for (int i = 0; i < 13; i++) {
            defaultAppliedPronounsIndexes.add(i + 1 + "");
        }
    }
    /**
     * حلقة تمسح الكلمات وتجرب الاستبدلات على كل  كلمة
     * اذا نجح أحد الاستبدالات لا نبحث عن أخر
     *
     * @param words List
     */
    public void apply(List words, Root root) {
        for (int i = 0; i < getAppliedPronounsIndexes().size(); i++) {
            int index = Integer.parseInt(getAppliedPronounsIndexes().get(i)) - 1;
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

    protected List<String> getAppliedPronounsIndexes() {
        return defaultAppliedPronounsIndexes;
    }
}
