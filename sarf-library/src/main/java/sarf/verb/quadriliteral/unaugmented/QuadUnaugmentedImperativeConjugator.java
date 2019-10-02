package sarf.verb.quadriliteral.unaugmented;

import java.util.*;

import sarf.*;

/**
 * يقوم هذا الصف بتصريف الأفعال الرباعية المجردة في صيغة الأمر
 * <p>Title: Sarf</p>
 * <p>Description: برنامج التصريف</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class QuadUnaugmentedImperativeConjugator {
    public QuadUnaugmentedImperativeConjugator() {
    }

    /**
     * إنشاء صيغة الفعل الأمر غير المؤكد
     * @param pronounIndex int
     * @param root QuadrilateralVerb
     * @return PresentConjugation
     */
    private ImperativeVerb createVerb(int pronounIndex, UnaugmentedQuadrilateralRoot root) {
        String lastDim = ImperativeConjugationDataContainer.getLastDim(pronounIndex);
        String connectedPronoun = ImperativeConjugationDataContainer.getConnectedPronoun(pronounIndex);
        if (lastDim.equals("") && connectedPronoun.equals("")) return null;

        return new ImperativeVerb(root, lastDim, connectedPronoun);
    }

    /**
     * إنشاء صيغة الفعل الأمر  المؤكد
     * @param pronounIndex int
     * @param root QuadrilateralVerb
     * @return PresentConjugation
     */
    private ImperativeVerb createEmphasizedVerb(int pronounIndex, UnaugmentedQuadrilateralRoot root) {
        String lastDim = ImperativeConjugationDataContainer.getEmphasizedLastDim(pronounIndex);
        String connectedPronoun = ImperativeConjugationDataContainer.getEmphasizedConnectedPronoun(pronounIndex);
        if (lastDim.equals("") && connectedPronoun.equals("")) return null;

        return new ImperativeVerb(root, lastDim, connectedPronoun);
    }

    /**
     * إنشاء قائمة تحتوي على صيغ تصريف الفعل حسب الضمائر
     * الأمر غير المؤكد
     * @param root TripleVerb
     * @return List
     */
    public List<ImperativeVerb> createVerbList(UnaugmentedQuadrilateralRoot root) {
        var result = new ArrayList<ImperativeVerb>();
        for (int i = 0; i < SystemConstants.PRONOUN_RANGE_END; i++) {
            ImperativeVerb conj = createVerb(i, root);
            result.add(conj);
        }
        return result;
    }

    /**
    * إنشاء قائمة تحتوي على صيغ تصريف الفعل حسب الضمائر
    * الأمر  المؤكد
    * @param root TripleVerb
    * @return List
    */
   public List<ImperativeVerb> createEmphasizedVerbList(UnaugmentedQuadrilateralRoot root) {
       var result = new ArrayList<ImperativeVerb>();
       for (int i = 0; i < SystemConstants.PRONOUN_RANGE_END; i++) {
           ImperativeVerb conj = createEmphasizedVerb(i, root);
           result.add(conj);
       }
       return result;
   }
}
