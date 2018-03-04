package sarf.verb.trilateral.unaugmented.passive;

import java.util.List;
import java.util.LinkedList;
import sarf.verb.trilateral.unaugmented.*;
import sarf.PresentConjugationDataContainer;

/**
 * <p>Title: Sarf</p>
 *
 * <p>Description: ÊÕÑíİ ÇáÃİÚÇá İí ÇáãÖÇÑÚ ÇáãÈäí ááãÌåæá     </p>
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
     * ÅäÔÇÁ ÇáİÚá ÇáãÖÇÑÚ ÈÛÖ ÇáäÙÑ Úä ÍÇáÊå ÇáÅÚÑÇÈíÉ
     * @param pronounIndex int
     * @param root UnaugmentedTrilateralRoot
     * @param lastDprList List
     * @param connectedPronounList List
     * @return PassivePresentVerb
     */
    private PassivePresentVerb createVerb(int pronounIndex, UnaugmentedTrilateralRoot root, List lastDprList, List connectedPronounList) {
        //	ÇÙåÇÑ ãÚ åæ æåí İŞØ ááãÌåæá ÇááÇÒã
        if (root.getTransitive().equals("á") && pronounIndex != 7 && pronounIndex != 8) {
            return null;
        }

        String cp = PresentConjugationDataContainer.getInstance().getCp(pronounIndex);
        String lastDpr = (String) lastDprList.get(pronounIndex);
        String connectedPronoun = (String) connectedPronounList.get(pronounIndex);
        return new PassivePresentVerb(root, cp, lastDpr, connectedPronoun);
    }


    /**
     * ÅäÔÇÁ ÇáİÚá ÇáãÖÇÑÚ İí ÍÇáÉ ÇáÑİÚ
     * @param pronounIndex int
     * @param root TrilateralVerb
     * @return PresentConjugation
     */
    public PassivePresentVerb createNominativeVerb(int pronounIndex, UnaugmentedTrilateralRoot root) {
        return createVerb(pronounIndex, root, PresentConjugationDataContainer.getInstance().getNominativeLastDprList(), PresentConjugationDataContainer.getInstance().getNominativeConnectedPronounList());
    }


    /**
     * ÅäÔÇÁ ÇáİÚá ÇáãÖÇÑÚ İí ÍÇáÉ ÇáäÕÈ
     * @param pronounIndex int
     * @param root TrilateralVerb
     * @return PresentConjugation
     */
    public PassivePresentVerb createAccusativeVerb(int pronounIndex, UnaugmentedTrilateralRoot root) {
        return createVerb(pronounIndex, root, PresentConjugationDataContainer.getInstance().getAccusativeLastDprList(), PresentConjugationDataContainer.getInstance().getAccusativeConnectedPronounList());
    }


    /**
     * ÅäÔÇÁ ÇáİÚá ÇáãÖÇÑÚ İí ÍÇáÉ ÇáÌÒã
     * @param pronounIndex int
     * @param root TrilateralVerb
     * @return PresentConjugation
     */
    public PassivePresentVerb createJussiveVerb(int pronounIndex, UnaugmentedTrilateralRoot root) {
        return createVerb(pronounIndex, root, PresentConjugationDataContainer.getInstance().getJussiveLastDprList(), PresentConjugationDataContainer.getInstance().getJussiveConnectedPronounList());
    }


    /**
     * ÅäÔÇÁ ÇáİÚá ÇáãÖÇÑÚ İí ÍÇáÉ ÇáÊÃßíÏ
     * @param pronounIndex int
     * @param root TrilateralVerb
     * @return PresentConjugation
     */
    public PassivePresentVerb createEmphasizedVerb(int pronounIndex, UnaugmentedTrilateralRoot root) {
        return createVerb(pronounIndex, root, PresentConjugationDataContainer.getInstance().getEmphasizedLastDprList(), PresentConjugationDataContainer.getInstance().getEmphasizedConnectedPronounList());
    }

    /**
     * ÅäÔÇÁ ŞÇÆãÉ ÊÍÊæí ÇáÃİÚÇá ÍÓÈ ÇáÖãÇÆÑ
     * İí ÍÇáÉ ÇáÑİÚ
     * @param root TripleVerb
     * @return List
     */
    public List createNominativeVerbList(UnaugmentedTrilateralRoot root) {
        List result = new LinkedList();
        for (int i = 0; i < 13; i++) {
            result.add(createNominativeVerb(i, root));
        }

        return result;
    }

    /**
     * ÅäÔÇÁ ŞÇÆãÉ ÊÍÊæí ÇáÃİÚÇá ÍÓÈ ÇáÖãÇÆÑ
     * İí ÍÇáÉ ÇáäÕÈ
     * @param root TripleVerb
     * @return List
     */
    public List createAccusativeVerbList(UnaugmentedTrilateralRoot root) {
        List result = new LinkedList();
        for (int i = 0; i < 13; i++) {
            result.add(createAccusativeVerb(i, root));
        }

        return result;
    }

    /**
     * ÅäÔÇÁ ŞÇÆãÉ ÊÍÊæí ÇáÃİÚÇá ÍÓÈ ÇáÖãÇÆÑ
     * İí ÍÇáÉ ÇáÌÒã
     * @param root TripleVerb
     * @return List
     */
    public List createJussiveVerbList(UnaugmentedTrilateralRoot root) {
        List result = new LinkedList();
        for (int i = 0; i < 13; i++) {
            result.add(createJussiveVerb(i, root));
        }

        return result;
    }


    /**
     * ÅäÔÇÁ ŞÇÆãÉ ÊÍÊæí ÇáÃİÚÇá ÍÓÈ ÇáÖãÇÆÑ
     * İí ÍÇáÉ ÇáÊÃßíÏ
     * @param root TripleVerb
     * @return List
     */
    public List createEmphasizedVerbList(UnaugmentedTrilateralRoot root) {
        List result = new LinkedList();
        for (int i = 0; i < 13; i++) {
            result.add(createEmphasizedVerb(i, root));
        }

        return result;
    }

}
