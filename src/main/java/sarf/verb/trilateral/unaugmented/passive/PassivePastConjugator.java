package sarf.verb.trilateral.unaugmented.passive;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;
import sarf.verb.trilateral.unaugmented.*;
import sarf.*;

/**
 * <p>Title: Sarf</p>
 *
 * <p>Description: تصريف الأفعال في الماضي المبني للمجهول     </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class PassivePastConjugator {

    private final PastConjugationDataContainer pastConjugationDataContainer;

    @Inject
    public PassivePastConjugator(PastConjugationDataContainer pastConjugationDataContainer) {
        this.pastConjugationDataContainer = pastConjugationDataContainer;
    }

    /**
    *  إنشاء الفعل حسب الضمير
     * @param pronounIndex int
     * @param root TripleVerb
     * @return PassivePastVerb
     */
    private PassivePastVerb createVerb(int pronounIndex, UnaugmentedTrilateralRoot root) {
        //	اظهار مع هو وهي فقط للمجهول اللازم
        if (root.getTransitive().equals("ل") && pronounIndex!= 7 && pronounIndex!= 8)
            return null;
        String lastDpa = pastConjugationDataContainer.getLastDpa(pronounIndex);
        String connectedPronoun = pastConjugationDataContainer.getConnectedPronoun(pronounIndex);
        return new PassivePastVerb(root, lastDpa, connectedPronoun);
    }

    /**
     *  إنشاء  قائمة تحتوي الأفعال مع الضمائر الثلاثة عشر
     * @param root TripleVerb
     * @return List
     */
    public List<PassivePastVerb> createVerbList(UnaugmentedTrilateralRoot root) {
        var result = new ArrayList<PassivePastVerb>();
        for (int i=0; i<SystemConstants.PRONOUN_RANGE_END; i++) {
            result.add(createVerb(i, root));
        }
        return result;
    }
}
