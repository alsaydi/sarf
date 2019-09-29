package sarf.verb.quadriliteral.unaugmented.active;

import java.util.ArrayList;
import java.util.List;

import sarf.PresentConjugationDataContainer;
import sarf.SystemConstants;
import sarf.verb.quadriliteral.unaugmented.*;

/**
 * <p>Title: Sarf</p>
 *
* <p>Description: تصريف الأفعال الرباعية  المجردة في المضارع     </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class QuadActivePresentConjugator {
    public QuadActivePresentConjugator() {
    }

    /**
     * *إنشاء الفعل المضارع بغض النظر عن حالته الإعرابية
     * @param pronounIndex int
     * @param root UnaugmentedQuadrilateralRoot
     * @param lastDprList List
     * @param connectedPronounList List
     * @return ActivePresentVerb
     */
    private ActivePresentVerb createVerb(int pronounIndex, UnaugmentedQuadrilateralRoot root, List lastDprList, List connectedPronounList) {
        String cp = PresentConjugationDataContainer.getCp(pronounIndex);
        String lastDpr = (String) lastDprList.get(pronounIndex);
        String connectedPronoun = (String) connectedPronounList.get(pronounIndex);
        return new ActivePresentVerb(root, cp, lastDpr, connectedPronoun);
    }


    /**
     * إنشاء الفعل المضارع في حالة الرفع
     * @param pronounIndex int
     * @param root QuadrilateralVerb
     * @return PresentConjugation
     */
    public ActivePresentVerb createNominativeVerb(int pronounIndex, UnaugmentedQuadrilateralRoot root) {
        return createVerb(pronounIndex, root, PresentConjugationDataContainer.getNominativeLastDprList() , PresentConjugationDataContainer.getNominativeConnectedPronounList());
    }


    /**
     * إنشاء الفعل المضارع في حالة النصب
     * @param pronounIndex int
     * @param root QuadrilateralVerb
     * @return PresentConjugation
     */
    private ActivePresentVerb createAccusativeVerb(int pronounIndex, UnaugmentedQuadrilateralRoot root) {
        return createVerb(pronounIndex, root, PresentConjugationDataContainer.getAccusativeLastDprList() , PresentConjugationDataContainer.getAccusativeConnectedPronounList());
    }

    /**
     * إنشاء الفعل المضارع في حالة الجزم
     * @param pronounIndex int
     * @param root QuadrilateralVerb
     * @return PresentConjugation
     */
    private ActivePresentVerb createJussiveVerb(int pronounIndex, UnaugmentedQuadrilateralRoot root) {
        return createVerb(pronounIndex, root, PresentConjugationDataContainer.getJussiveLastDprList() , PresentConjugationDataContainer.getJussiveConnectedPronounList());
    }


    /**
     * إنشاء الفعل المضارع في حالة التأكيد
     * @param pronounIndex int
     * @param root QuadrilateralVerb
     * @return PresentConjugation
     */
    private ActivePresentVerb createEmphasizedVerb(int pronounIndex, UnaugmentedQuadrilateralRoot root) {
        return createVerb(pronounIndex, root, PresentConjugationDataContainer.getEmphasizedLastDprList() , PresentConjugationDataContainer.getEmphasizedConnectedPronounList());
    }

    /**
     * إنشاء قائمة تحتوي الأفعال حسب الضمائر
     * في حالة الرفع
     * @param root TripleVerb
     * @return List
     */
    public List<ActivePresentVerb> createNominativeVerbList(UnaugmentedQuadrilateralRoot root) {
        var result = new ArrayList<ActivePresentVerb>();
        for (int i = 0; i < SystemConstants.PRONOUN_RANGE_END; i++) {
            result.add(createNominativeVerb(i, root));
        }

        return result;
    }

    /**
     * إنشاء قائمة تحتوي الأفعال حسب الضمائر
     * في حالة النصب
     * @param root TripleVerb
     * @return List
     */
    public List<ActivePresentVerb> createAccusativeVerbList(UnaugmentedQuadrilateralRoot root) {
        var result = new ArrayList<ActivePresentVerb>();
        for (int i = 0; i < SystemConstants.PRONOUN_RANGE_END; i++) {
            result.add(createAccusativeVerb(i, root));
        }
        return result;
    }

    /**
     * إنشاء قائمة تحتوي الأفعال حسب الضمائر
     * في حالة الجزم
     * @param root TripleVerb
     * @return List
     */
    public List<ActivePresentVerb> createJussiveVerbList(UnaugmentedQuadrilateralRoot root) {
        var result = new ArrayList<ActivePresentVerb>();
        for (int i = 0; i < SystemConstants.PRONOUN_RANGE_END; i++) {
            result.add(createJussiveVerb(i, root));
        }
        return result;
    }

    /**
     * إنشاء قائمة تحتوي الأفعال حسب الضمائر
     * في حالة التأكيد
     * @param root TripleVerb
     * @return List
     */
    public List<ActivePresentVerb> createEmphasizedVerbList(UnaugmentedQuadrilateralRoot root) {
        var result = new ArrayList<ActivePresentVerb>();
        for (int i = 0; i < SystemConstants.PRONOUN_RANGE_END; i++) {
            result.add(createEmphasizedVerb(i, root));
        }
        return result;
    }
}
