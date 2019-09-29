package sarf.verb.trilateral.unaugmented.active;

import sarf.PresentConjugationDataContainer;
import sarf.SystemConstants;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: Sarf</p>
 *
 * <p>Description: تصريف الأفعال في المضارع   </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class ActivePresentConjugator {
    public ActivePresentConjugator() {
    }

    /**
     * *إنشاء الفعل المضارع بغض النظر عن حالته الإعرابية
     *
     * @param pronounIndex         int
     * @param root                 UnaugmentedTrilateralRoot
     * @param lastDprList          List
     * @param connectedPronounList List
     * @return ActivePresentVerb
     */
    private ActivePresentVerb createVerb(int pronounIndex, UnaugmentedTrilateralRoot root, List lastDprList, List connectedPronounList) {
        String cp = PresentConjugationDataContainer.getCp(pronounIndex);
        String dpr2 = PresentConjugationDataContainer.getDpr2(root);
        String lastDpr = (String) lastDprList.get(pronounIndex);
        String connectedPronoun = (String) connectedPronounList.get(pronounIndex);
        return new ActivePresentVerb(root, cp, dpr2, lastDpr, connectedPronoun);
    }

    /**
     * إنشاء الفعل المضارع في حالة الرفع
     *
     * @param pronounIndex int
     * @param root         TrilateralVerb
     * @return PresentConjugation
     */
    public ActivePresentVerb createNominativeVerb(int pronounIndex, UnaugmentedTrilateralRoot root) {
        return createVerb(pronounIndex, root, PresentConjugationDataContainer.getNominativeLastDprList()
                , PresentConjugationDataContainer.getNominativeConnectedPronounList());
    }

    /**
     * إنشاء الفعل المضارع في حالة النصب
     *
     * @param pronounIndex int
     * @param root         TrilateralVerb
     * @return PresentConjugation
     */
    public ActivePresentVerb createAccusativeVerb(int pronounIndex, UnaugmentedTrilateralRoot root) {
        return createVerb(pronounIndex, root, PresentConjugationDataContainer.getAccusativeLastDprList()
                , PresentConjugationDataContainer.getAccusativeConnectedPronounList());
    }


    /**
     * إنشاء الفعل المضارع في حالة الجزم
     *
     * @param pronounIndex int
     * @param root         TrilateralVerb
     * @return PresentConjugation
     */
    public ActivePresentVerb createJussiveVerb(int pronounIndex, UnaugmentedTrilateralRoot root) {
        return createVerb(pronounIndex, root, PresentConjugationDataContainer.getJussiveLastDprList()
                , PresentConjugationDataContainer.getJussiveConnectedPronounList());
    }


    /**
     * إنشاء الفعل المضارع في حالة التأكيد
     *
     * @param pronounIndex int
     * @param root         TrilateralVerb
     * @return PresentConjugation
     */
    private ActivePresentVerb createEmphasizedVerb(int pronounIndex, UnaugmentedTrilateralRoot root) {
        return createVerb(pronounIndex, root, PresentConjugationDataContainer.getEmphasizedLastDprList()
                , PresentConjugationDataContainer.getEmphasizedConnectedPronounList());
    }

    /**
     * إنشاء قائمة تحتوي الأفعال حسب الضمائر
     * في حالة الرفع
     *
     * @param root TripleVerb
     * @return List
     */
    public List<ActivePresentVerb> createNominativeVerbList(UnaugmentedTrilateralRoot root) {
        var result = new ArrayList<ActivePresentVerb>();
        for (int i = 0; i < SystemConstants.PRONOUN_RANGE_END; i++) {
            result.add(createNominativeVerb(i, root));
        }
        return result;
    }

    /**
     * إنشاء قائمة تحتوي الأفعال حسب الضمائر
     * في حالة النصب
     *
     * @param root TripleVerb
     * @return List
     */
    public List<ActivePresentVerb> createAccusativeVerbList(UnaugmentedTrilateralRoot root) {
        var result = new ArrayList<ActivePresentVerb>();
        for (int i = 0; i < SystemConstants.PRONOUN_RANGE_END; i++) {
            result.add(createAccusativeVerb(i, root));
        }
        return result;
    }

    /**
     * إنشاء قائمة تحتوي الأفعال حسب الضمائر
     * في حالة الجزم
     *
     * @param root TripleVerb
     * @return List
     */
    public List<ActivePresentVerb> createJussiveVerbList(UnaugmentedTrilateralRoot root) {
        var result = new ArrayList<ActivePresentVerb>();
        for (int i = 0; i < SystemConstants.PRONOUN_RANGE_END; i++) {
            result.add(createJussiveVerb(i, root));
        }
        return result;
    }


    /**
     * إنشاء قائمة تحتوي الأفعال حسب الضمائر
     * في حالة التأكيد
     *
     * @param root TripleVerb
     * @return List
     */
    public List<ActivePresentVerb> createEmphasizedVerbList(UnaugmentedTrilateralRoot root) {
        var result = new ArrayList<ActivePresentVerb>();
        for (int i = 0; i < SystemConstants.PRONOUN_RANGE_END; i++) {
            result.add(createEmphasizedVerb(i, root));
        }
        return result;
    }
}
