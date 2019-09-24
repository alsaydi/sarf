package sarf.verb.quadriliteral.unaugmented.active;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

import com.google.inject.Inject;
import sarf.*;
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
public class QuadriActivePastConjugator {
    private final PastConjugationDataContainer pastConjugationDataContainer;

    @Inject
    public QuadriActivePastConjugator(PastConjugationDataContainer pastConjugationDataContainer) {
        this.pastConjugationDataContainer = pastConjugationDataContainer;
    }

    /**
    *  إنشاء الفعل حسب الضمير
     * @param pronounIndex int
     * @param root UnaugmentedQuadrilateralRoot
     * @return PastConjugation
     */
    public ActivePastVerb createVerb(int pronounIndex, UnaugmentedQuadrilateralRoot root) {
        String lastDpa = pastConjugationDataContainer.getLastDpa(pronounIndex);
        String connectedPronoun = pastConjugationDataContainer.getConnectedPronoun(pronounIndex);
        return new ActivePastVerb(root, lastDpa, connectedPronoun);
    }

    /**
     *  إنشاء  قائمة تحتوي الأفعال مع الضمائر الثلاثة عشر
     * @param root UnaugmentedQuadrilateralRoot
     * @return List
     */
    public List<ActivePastVerb> createVerbList(UnaugmentedQuadrilateralRoot root) {
        List<ActivePastVerb> result = new ArrayList<>();
        for (int i=0; i<SystemConstants.PRONOUN_RANGE_END; i++) {
            result.add(createVerb(i, root));
        }
        return result;
    }
}
