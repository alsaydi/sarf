package sarf.verb.quadriliteral.unaugmented.active;

import java.util.List;
import java.util.LinkedList;
import sarf.*;
import sarf.verb.quadriliteral.*;
import sarf.verb.quadriliteral.unaugmented.*;

/**
 * <p>Title: Sarf</p>
 *
 * <p>Description: تصريف الأفعال الرباعية  المجردة في الماضي      </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class ActivePastConjugator {
    private ActivePastConjugator() {
    }

    private static ActivePastConjugator instance = new ActivePastConjugator();

    public static ActivePastConjugator getInstance() {
        return instance;
    }

    /**
    *  إنشاء الفعل حسب الضمير
     * @param pronounIndex int
     * @param root UnaugmentedQuadriliteralRoot
     * @return PastConjugation
     */
    public ActivePastVerb createVerb(int pronounIndex, UnaugmentedQuadriliteralRoot root) {
        String lastDpa = PastConjugationDataContainer.getInstance().getLastDpa(pronounIndex);
        String connectedPronoun = PastConjugationDataContainer.getInstance().getConnectedPronoun(pronounIndex);
        return new ActivePastVerb(root, lastDpa, connectedPronoun);
    }

    /**
     *  إنشاء  قائمة تحتوي الأفعال مع الضمائر الثلاثة عشر
     * @param root UnaugmentedQuadriliteralRoot
     * @return List
     */
    public List createVerbList(UnaugmentedQuadriliteralRoot root) {
        List result = new LinkedList();
        for (int i=0; i<13; i++) {
            result.add(createVerb(i, root));
        }

        return result;
    }

}
