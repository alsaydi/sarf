package sarf.verb.quadriliteral.unaugmented.passive;

import java.util.*;

import sarf.*;
import sarf.verb.quadriliteral.*;
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
public class PassivePastConjugator {
    private PassivePastConjugator() {
    }

    private static PassivePastConjugator instance = new PassivePastConjugator();

    public static PassivePastConjugator getInstance() {
        return instance;
    }

    /**
     *  إنشاء الفعل حسب الضمير
     * @param pronounIndex int
     * @param root TripleVerb
     * @return PassivePastVerb
     */
    public PassivePastVerb createVerb(int pronounIndex, UnaugmentedQuadriliteralRoot root) {
        //	اظهار مع هو وهي فقط للمجهول اللازم
        if (root.getTransitive().equals("ل") && pronounIndex != 7 && pronounIndex != 8) {
            return null;
        }

        String lastDpa = PastConjugationDataContainer.getInstance().getLastDpa(pronounIndex);
        String connectedPronoun = PastConjugationDataContainer.getInstance().getConnectedPronoun(pronounIndex);
        return new PassivePastVerb(root, lastDpa, connectedPronoun);
    }

    /**
     *  إنشاء  قائمة تحتوي الأفعال مع الضمائر الثلاثة عشر
     * @param root TripleVerb
     * @return List
     */
    public List createVerbList(UnaugmentedQuadriliteralRoot root) {
        List result = new LinkedList();
        for (int i = 0; i < 13; i++) {
            result.add(createVerb(i, root));
        }

        return result;
    }

}
