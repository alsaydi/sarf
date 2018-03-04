package sarf.verb.quadriliteral.unaugmented.passive;

import java.util.*;

import sarf.*;
import sarf.verb.quadriliteral.*;
import sarf.verb.quadriliteral.unaugmented.*;

/**
 * <p>Title: Sarf</p>
 *
 * <p>Description: تصريف الأفعال الرباعية  المجردة في المضارع المبني للمجهول     </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class PassivePresentConjugator {
    private PassivePresentConjugator() {
    }

    private static PassivePresentConjugator instance = new PassivePresentConjugator();

    public static PassivePresentConjugator getInstance() {
        return instance;
    }

    /**
     * إنشاء الفعل المضارع بغض النظر عن حالته الإعرابية
     * @param pronounIndex int
     * @param root UnaugmentedQuadriliteralRoot
     * @param lastDprList List
     * @param connectedPronounList List
     * @return PassivePresentVerb
     */
    private PassivePresentVerb createVerb(int pronounIndex, UnaugmentedQuadriliteralRoot root, List lastDprList, List connectedPronounList) {
        //	اظهار مع هو وهي فقط للمجهول اللازم
        if (root.getTransitive().equals("ل") && pronounIndex != 7 && pronounIndex != 8) {
            return null;
        }

        String cp = PresentConjugationDataContainer.getInstance().getCp(pronounIndex);
        String lastDpr = (String) lastDprList.get(pronounIndex);
        String connectedPronoun = (String) connectedPronounList.get(pronounIndex);
        return new PassivePresentVerb(root, cp, lastDpr, connectedPronoun);
    }


    /**
     * إنشاء الفعل المضارع في حالة الرفع
     * @param pronounIndex int
     * @param root QuadriliteralVerb
     * @return PresentConjugation
     */
    public PassivePresentVerb createNominativeVerb(int pronounIndex, UnaugmentedQuadriliteralRoot root) {
        return createVerb(pronounIndex, root, PresentConjugationDataContainer.getInstance().getNominativeLastDprList(), PresentConjugationDataContainer.getInstance().getNominativeConnectedPronounList());
    }


    /**
     * إنشاء الفعل المضارع في حالة النصب
     * @param pronounIndex int
     * @param root QuadriliteralVerb
     * @return PresentConjugation
     */
    public PassivePresentVerb createAccusativeVerb(int pronounIndex, UnaugmentedQuadriliteralRoot root) {
        return createVerb(pronounIndex, root, PresentConjugationDataContainer.getInstance().getAccusativeLastDprList(), PresentConjugationDataContainer.getInstance().getAccusativeConnectedPronounList());
    }


    /**
     * إنشاء الفعل المضارع في حالة الجزم
     * @param pronounIndex int
     * @param root QuadriliteralVerb
     * @return PresentConjugation
     */
    public PassivePresentVerb createJussiveVerb(int pronounIndex, UnaugmentedQuadriliteralRoot root) {
        return createVerb(pronounIndex, root, PresentConjugationDataContainer.getInstance().getJussiveLastDprList(), PresentConjugationDataContainer.getInstance().getJussiveConnectedPronounList());
    }


    /**
     * إنشاء الفعل المضارع في حالة التأكيد
     * @param pronounIndex int
     * @param root QuadriliteralVerb
     * @return PresentConjugation
     */
    public PassivePresentVerb createEmphasizedVerb(int pronounIndex, UnaugmentedQuadriliteralRoot root) {
        return createVerb(pronounIndex, root, PresentConjugationDataContainer.getInstance().getEmphasizedLastDprList(), PresentConjugationDataContainer.getInstance().getEmphasizedConnectedPronounList());
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
