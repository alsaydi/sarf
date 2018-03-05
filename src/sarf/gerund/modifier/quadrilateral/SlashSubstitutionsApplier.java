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
     * حلقة تمسح الكلمات وتجرب الاستبدلات على كل  كلمة
     * اذا نجح أحد الاستبدالات لا نبحث عن أخر
     * @param words List
     */
    public void apply(List words, QuadrilateralRoot root) {
        for (int index = 0; index < 18; index++) {
            Object wordObj = words.get(index);
            if (wordObj == null) {
                //حالة الفعل أمر
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
                    //تبديل الكلمة الجديدة المستبدلة بالكلمة القديمة
                    words.set(index, result);
                    //لا داعي لفحص باقي الاستبدالات
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
     * قائمة الاستبدالات
     * @return List
     */
    public abstract List getSubstitutions();

}
