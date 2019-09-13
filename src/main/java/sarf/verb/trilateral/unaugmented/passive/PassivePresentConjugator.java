package sarf.verb.trilateral.unaugmented.passive;

import sarf.PresentConjugationDataContainer;
import sarf.SystemConstants;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <p>Title: Sarf</p>
 *
 * <p>Description: تصريف الأفعال في المضارع المبني للمجهول     </p>
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

    private static final PassivePresentConjugator instance = new PassivePresentConjugator();

    public static PassivePresentConjugator getInstance() {
        return instance;
    }

    /**
     * إنشاء الفعل المضارع بغض النظر عن حالته الإعرابية
     *
     * @param pronounIndex         int
     * @param root                 UnaugmentedTrilateralRoot
     * @param lastDprList          List
     * @param connectedPronounList List
     * @return PassivePresentVerb
     */
    private PassivePresentVerb createVerb(int pronounIndex, UnaugmentedTrilateralRoot root, List lastDprList, List connectedPronounList) {
        //	اظهار مع هو وهي فقط للمجهول اللازم
        if (root.getTransitive().equals("ل") && pronounIndex != 7 && pronounIndex != 8) {
            return null;
        }

        String cp = PresentConjugationDataContainer.getCp(pronounIndex);
        String lastDpr = (String) lastDprList.get(pronounIndex);
        String connectedPronoun = (String) connectedPronounList.get(pronounIndex);
        return new PassivePresentVerb(root, cp, lastDpr, connectedPronoun);
    }

    /**
     * إنشاء الفعل المضارع في حالة الرفع
     *
     * @param pronounIndex int
     * @param root         TrilateralVerb
     * @return PresentConjugation
     */
    private PassivePresentVerb createNominativeVerb(int pronounIndex, UnaugmentedTrilateralRoot root) {
        return createVerb(pronounIndex, root, PresentConjugationDataContainer.getNominativeLastDprList(), PresentConjugationDataContainer.getNominativeConnectedPronounList());
    }

    /**
     * إنشاء الفعل المضارع في حالة النصب
     *
     * @param pronounIndex int
     * @param root         TrilateralVerb
     * @return PresentConjugation
     */
    private PassivePresentVerb createAccusativeVerb(int pronounIndex, UnaugmentedTrilateralRoot root) {
        return createVerb(pronounIndex, root, PresentConjugationDataContainer.getAccusativeLastDprList(), PresentConjugationDataContainer.getAccusativeConnectedPronounList());
    }

    /**
     * إنشاء الفعل المضارع في حالة الجزم
     *
     * @param pronounIndex int
     * @param root         TrilateralVerb
     * @return PresentConjugation
     */
    private PassivePresentVerb createJussiveVerb(int pronounIndex, UnaugmentedTrilateralRoot root) {
        return createVerb(pronounIndex, root, PresentConjugationDataContainer.getJussiveLastDprList(), PresentConjugationDataContainer.getJussiveConnectedPronounList());
    }


    /**
     * إنشاء الفعل المضارع في حالة التأكيد
     *
     * @param pronounIndex int
     * @param root         TrilateralVerb
     * @return PresentConjugation
     */
    private PassivePresentVerb createEmphasizedVerb(int pronounIndex, UnaugmentedTrilateralRoot root) {
        return createVerb(pronounIndex, root, PresentConjugationDataContainer.getEmphasizedLastDprList(), PresentConjugationDataContainer.getEmphasizedConnectedPronounList());
    }

    /**
     * إنشاء قائمة تحتوي الأفعال حسب الضمائر
     * في حالة الرفع
     *
     * @param root TripleVerb
     * @return List
     */
    public List<PassivePresentVerb> createNominativeVerbList(UnaugmentedTrilateralRoot root) {
        return IntStream.range(0, SystemConstants.PRONOUN_RANGE_END)
                .mapToObj(i -> createNominativeVerb(i, root))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * إنشاء قائمة تحتوي الأفعال حسب الضمائر
     * في حالة النصب
     *
     * @param root TripleVerb
     * @return List
     */
    public List<PassivePresentVerb> createAccusativeVerbList(UnaugmentedTrilateralRoot root) {
        return IntStream.range(0, SystemConstants.PRONOUN_RANGE_END)
                .mapToObj(i -> createAccusativeVerb(i, root))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * إنشاء قائمة تحتوي الأفعال حسب الضمائر
     * في حالة الجزم
     *
     * @param root TripleVerb
     * @return List
     */
    public List<PassivePresentVerb> createJussiveVerbList(UnaugmentedTrilateralRoot root) {
        return IntStream.range(0, SystemConstants.PRONOUN_RANGE_END)
                .mapToObj(i -> createJussiveVerb(i, root))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * إنشاء قائمة تحتوي الأفعال حسب الضمائر
     * في حالة التأكيد
     *
     * @param root TripleVerb
     * @return List
     */
    public List<PassivePresentVerb> createEmphasizedVerbList(UnaugmentedTrilateralRoot root) {
        return IntStream.range(0, SystemConstants.PRONOUN_RANGE_END)
                .mapToObj(i -> createEmphasizedVerb(i, root))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
