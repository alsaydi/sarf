package sarf.substitution;

import sarf.ConjugationResult;
import sarf.SystemConstants;
import sarf.Word;
import sarf.verb.Root;

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
public abstract class SubstitutionsApplier {
    private static final List<String> defaultAppliedPronounsIndexes = new ArrayList<>(SystemConstants.PRONOUN_RANGE_END);
    static {
        IntStream.rangeClosed(1, SystemConstants.PRONOUN_RANGE_END)
                .forEach(i -> defaultAppliedPronounsIndexes.add("" + i));
    }

    /**
     * حلقة تمسح الكلمات وتجرب الاستبدلات على كل  كلمة
     * اذا نجح أحد الاستبدالات لا نبحث عن أخر
     *
     * @param words List of Word instances
     * @param root  Root
     */
    public void apply(List<? extends Word> words, Root root) {
        for (var str : getAppliedPronounsIndexes()) {
            var index = Integer.parseInt(str) - 1;
            var word = words.get(index);
            if (word == null || word.isEmpty()) {
                continue;
            }

            for (Substitution substitution : getSubstitutions()) {
                var result = substitution.apply(word, root);
                if (result != null) {
                    //تبديل الكلمة الجديدة المستبدلة بالكلمة القديمة
                    //words.set(index, result);
                    word = result;
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

    public abstract boolean isApplied(ConjugationResult conjugationResult);
}
