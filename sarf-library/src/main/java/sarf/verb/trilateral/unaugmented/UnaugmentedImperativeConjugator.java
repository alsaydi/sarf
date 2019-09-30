package sarf.verb.trilateral.unaugmented;

import sarf.ImperativeConjugationDataContainer;
import sarf.PresentConjugationDataContainer;
import sarf.SystemConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * يقوم هذا الصف بتصريف الأفعال الثلاثية المجردة في صيغة الأمر
 * <p>Title: Sarf</p>
 * <p>Description: برنامج التصريف</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class UnaugmentedImperativeConjugator {
    public UnaugmentedImperativeConjugator() {
    }

    /**
     * إنشاء صيغة الفعل الأمر غير المؤكد
     *
     * @param pronounIndex int
     * @param root         TrilateralVerb
     * @return PresentConjugation
     */
    private ImperativeVerb createVerb(int pronounIndex, UnaugmentedTrilateralRoot root) {
        String dpr2 = PresentConjugationDataContainer.getDpr2(root);
        String lastDim = ImperativeConjugationDataContainer.getLastDim(pronounIndex);
        String connectedPronoun = ImperativeConjugationDataContainer.getConnectedPronoun(pronounIndex);
        if (lastDim.equals("") && connectedPronoun.equals("")) return null;

        return new ImperativeVerb(root, dpr2, lastDim, connectedPronoun);
    }

    /**
     * إنشاء صيغة الفعل الأمر  المؤكد
     *
     * @param pronounIndex int
     * @param root         TrilateralVerb
     * @return PresentConjugation
     */
    private ImperativeVerb createEmphasizedVerb(int pronounIndex, UnaugmentedTrilateralRoot root) {
        String dpr2 = PresentConjugationDataContainer.getDpr2(root);
        String lastDim = ImperativeConjugationDataContainer.getEmphasizedLastDim(pronounIndex);
        String connectedPronoun = ImperativeConjugationDataContainer.getEmphasizedConnectedPronoun(pronounIndex);
        if (lastDim.equals("") && connectedPronoun.equals("")) return null;

        return new ImperativeVerb(root, dpr2, lastDim, connectedPronoun);
    }

    /**
     * إنشاء قائمة تحتوي على صيغ تصريف الفعل حسب الضمائر
     * الأمر غير المؤكد
     *
     * @param root TripleVerb
     * @return List
     */
    public List<ImperativeVerb> createVerbList(UnaugmentedTrilateralRoot root) {
        var result = new ArrayList<ImperativeVerb>();
        for (int i = 0; i < SystemConstants.PRONOUN_RANGE_END; i++) {
            result.add(createVerb(i, root));
        }
        return result;
    }

    /**
     * إنشاء قائمة تحتوي على صيغ تصريف الفعل حسب الضمائر
     * الأمر  المؤكد
     *
     * @param root TripleVerb
     * @return List
     */
    public List<ImperativeVerb> createEmphasizedVerbList(UnaugmentedTrilateralRoot root) {
        var result = new ArrayList<ImperativeVerb>();
        for (int i = 0; i < SystemConstants.PRONOUN_RANGE_END; i++) {
            result.add(createEmphasizedVerb(i, root));
        }
        return result;
    }
}
