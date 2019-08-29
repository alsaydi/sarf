
package sarf.verb.trilateral.Substitution;

import sarf.SystemConstants;
import sarf.verb.trilateral.TrilateralRoot;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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

    private static final List<String> defaultAppliedPronounsIndexes = new ArrayList<>(SystemConstants.PRONOUN_RANGE_END);

    static {
        IntStream.rangeClosed(1, SystemConstants.PRONOUN_RANGE_END)
                .forEach(i -> defaultAppliedPronounsIndexes.add("" + i));
    }

    /**
     * حلقة تمسح الكلمات وتجرب الاستبدلات على كل  كلمة
     * اذا نجح أحد الاستبدالات لا نبحث عن أخر
     *
     * @param words List
     * @param root  TrilateralRoot
     */
    public void apply(List words, TrilateralRoot root) {
        for (var str : getAppliedPronounsIndexes()) {
            var index = Integer.parseInt(str) - 1;
            var wordObj = words.get(index);
            if (wordObj == null) {
                continue;
            }
            var word = wordObj.toString().trim();

            for (Substitution substitution : getSubstitutions()) {
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
     *
     * @return List
     */
    public abstract List<Substitution> getSubstitutions();

    protected List<String> getAppliedPronounsIndexes() {
        return defaultAppliedPronounsIndexes;
    }
}
