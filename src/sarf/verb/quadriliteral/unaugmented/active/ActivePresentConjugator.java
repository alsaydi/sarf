package sarf.verb.quadriliteral.unaugmented.active;

import java.util.List;
import java.util.LinkedList;
import sarf.PresentConjugationDataContainer;
import sarf.verb.quadriliteral.*;
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
public class ActivePresentConjugator {
    private ActivePresentConjugator() {
    }

    private static ActivePresentConjugator instance = new ActivePresentConjugator();

    public static ActivePresentConjugator getInstance() {
        return instance;
    }

    /**
     * *إنشاء الفعل المضارع بغض النظر عن حالته الإعرابية
     * @param pronounIndex int
     * @param root UnaugmentedQuadriliteralRoot
     * @param lastDprList List
     * @param connectedPronounList List
     * @return ActivePresentVerb
     */
    private ActivePresentVerb createVerb(int pronounIndex, UnaugmentedQuadriliteralRoot root, List lastDprList, List connectedPronounList) {
        String cp = PresentConjugationDataContainer.getInstance().getCp(pronounIndex);
        String lastDpr = (String) lastDprList.get(pronounIndex);
        String connectedPronoun = (String) connectedPronounList.get(pronounIndex);
        return new ActivePresentVerb(root, cp, lastDpr, connectedPronoun);
    }


    /**
     * إنشاء الفعل المضارع في حالة الرفع
     * @param pronounIndex int
     * @param root QuadriliteralVerb
     * @return PresentConjugation
     */
    public ActivePresentVerb createNominativeVerb(int pronounIndex, UnaugmentedQuadriliteralRoot root) {
        return createVerb(pronounIndex, root, PresentConjugationDataContainer.getInstance().getNominativeLastDprList() , PresentConjugationDataContainer.getInstance().getNominativeConnectedPronounList());
    }


    /**
     * إنشاء الفعل المضارع في حالة النصب
     * @param pronounIndex int
     * @param root QuadriliteralVerb
     * @return PresentConjugation
     */
    public ActivePresentVerb createAccusativeVerb(int pronounIndex, UnaugmentedQuadriliteralRoot root) {
        return createVerb(pronounIndex, root, PresentConjugationDataContainer.getInstance().getAccusativeLastDprList() , PresentConjugationDataContainer.getInstance().getAccusativeConnectedPronounList());
    }


    /**
     * إنشاء الفعل المضارع في حالة الجزم
     * @param pronounIndex int
     * @param root QuadriliteralVerb
     * @return PresentConjugation
     */
    public ActivePresentVerb createJussiveVerb(int pronounIndex, UnaugmentedQuadriliteralRoot root) {
        return createVerb(pronounIndex, root, PresentConjugationDataContainer.getInstance().getJussiveLastDprList() , PresentConjugationDataContainer.getInstance().getJussiveConnectedPronounList());
    }


    /**
     * إنشاء الفعل المضارع في حالة التأكيد
     * @param pronounIndex int
     * @param root QuadriliteralVerb
     * @return PresentConjugation
     */
    public ActivePresentVerb createEmphasizedVerb(int pronounIndex, UnaugmentedQuadriliteralRoot root) {
        return createVerb(pronounIndex, root, PresentConjugationDataContainer.getInstance().getEmphasizedLastDprList() , PresentConjugationDataContainer.getInstance().getEmphasizedConnectedPronounList());
    }

    /**
     * إنشاء قائمة تحتوي الأفعال حسب الضمائر
     * في حالة الرفع
     * @param root TripleVerb
     * @return List
     */
    public List createNominativeVerbList(UnaugmentedQuadriliteralRoot root) {
        List result = new LinkedList();
        for (int i = 0; i < 13; i++) {
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
    public List createAccusativeVerbList(UnaugmentedQuadriliteralRoot root) {
        List result = new LinkedList();
        for (int i = 0; i < 13; i++) {
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
    public List createJussiveVerbList(UnaugmentedQuadriliteralRoot root) {
        List result = new LinkedList();
        for (int i = 0; i < 13; i++) {
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
    public List createEmphasizedVerbList(UnaugmentedQuadriliteralRoot root) {
        List result = new LinkedList();
        for (int i = 0; i < 13; i++) {
            result.add(createEmphasizedVerb(i, root));
        }

        return result;
    }

}
