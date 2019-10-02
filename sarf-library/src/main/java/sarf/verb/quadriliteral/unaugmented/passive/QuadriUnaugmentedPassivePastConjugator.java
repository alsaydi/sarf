package sarf.verb.quadriliteral.unaugmented.passive;

import java.util.*;

import com.google.inject.Inject;
import sarf.*;
import sarf.verb.quadriliteral.unaugmented.*;

/**
 * <p>Title: Sarf</p>
 *
 * <p>Description: تصريف الأفعال الرباعية  المجردة في صيغة الماضي المبني للمجهول     </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class QuadriUnaugmentedPassivePastConjugator {
    private final PastConjugationDataContainer pastConjugationDataContainer;

    @Inject
    public QuadriUnaugmentedPassivePastConjugator(PastConjugationDataContainer pastConjugationDataContainer) {
        this.pastConjugationDataContainer = pastConjugationDataContainer;
    }

    /**
     *  إنشاء الفعل حسب الضمير
     * @param pronounIndex int
     * @param root TripleVerb
     * @return PassivePastVerb
     */
    private PassivePastVerb createVerb(int pronounIndex, UnaugmentedQuadrilateralRoot root) {
        //	اظهار مع هو وهي فقط للمجهول اللازم
        if (root.getTransitive().equals("ل") && pronounIndex != 7 && pronounIndex != 8) {
            return null;
        }

        String lastDpa = pastConjugationDataContainer.getLastDpa(pronounIndex);
        String connectedPronoun = pastConjugationDataContainer.getConnectedPronoun(pronounIndex);
        return new PassivePastVerb(root, lastDpa, connectedPronoun);
    }

    /**
     *  إنشاء  قائمة تحتوي الأفعال مع الضمائر الثلاثة عشر
     * @param root TripleVerb
     * @return List
     */
    public List<PassivePastVerb> createVerbList(UnaugmentedQuadrilateralRoot root) {
        List<PassivePastVerb> result = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            result.add(createVerb(i, root));
        }
        return result;
    }
}
