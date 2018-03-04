package sarf.verb.trilateral.unaugmented.active;

import java.util.List;
import java.util.LinkedList;
import sarf.verb.trilateral.unaugmented.*;
import sarf.PresentConjugationDataContainer;

/**
 * <p>Title: Sarf</p>
 *
 * <p>Description:  ’—Ì› «·√›⁄«· ›Ì «·„÷«—⁄   </p>
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
     * *≈‰‘«¡ «·›⁄· «·„÷«—⁄ »€÷ «·‰Ÿ— ⁄‰ Õ«· Â «·≈⁄—«»Ì…
     * @param pronounIndex int
     * @param root UnaugmentedTrilateralRoot
     * @param lastDprList List
     * @param connectedPronounList List
     * @return ActivePresentVerb
     */
    private ActivePresentVerb createVerb(int pronounIndex, UnaugmentedTrilateralRoot root, List lastDprList, List connectedPronounList) {
        String cp = PresentConjugationDataContainer.getInstance().getCp(pronounIndex);
        String dpr2 = PresentConjugationDataContainer.getInstance().getDpr2(root);
        String lastDpr = (String) lastDprList.get(pronounIndex);
        String connectedPronoun = (String) connectedPronounList.get(pronounIndex);
        return new ActivePresentVerb(root, cp, dpr2, lastDpr, connectedPronoun);
    }


    /**
     * ≈‰‘«¡ «·›⁄· «·„÷«—⁄ ›Ì Õ«·… «·—›⁄
     * @param pronounIndex int
     * @param root TrilateralVerb
     * @return PresentConjugation
     */
    public ActivePresentVerb createNominativeVerb(int pronounIndex, UnaugmentedTrilateralRoot root) {
        return createVerb(pronounIndex, root, PresentConjugationDataContainer.getInstance().getNominativeLastDprList() , PresentConjugationDataContainer.getInstance().getNominativeConnectedPronounList());
    }


    /**
     * ≈‰‘«¡ «·›⁄· «·„÷«—⁄ ›Ì Õ«·… «·‰’»
     * @param pronounIndex int
     * @param root TrilateralVerb
     * @return PresentConjugation
     */
    public ActivePresentVerb createAccusativeVerb(int pronounIndex, UnaugmentedTrilateralRoot root) {
        return createVerb(pronounIndex, root, PresentConjugationDataContainer.getInstance().getAccusativeLastDprList() , PresentConjugationDataContainer.getInstance().getAccusativeConnectedPronounList());
    }


    /**
     * ≈‰‘«¡ «·›⁄· «·„÷«—⁄ ›Ì Õ«·… «·Ã“„
     * @param pronounIndex int
     * @param root TrilateralVerb
     * @return PresentConjugation
     */
    public ActivePresentVerb createJussiveVerb(int pronounIndex, UnaugmentedTrilateralRoot root) {
        return createVerb(pronounIndex, root, PresentConjugationDataContainer.getInstance().getJussiveLastDprList() , PresentConjugationDataContainer.getInstance().getJussiveConnectedPronounList());
    }


    /**
     * ≈‰‘«¡ «·›⁄· «·„÷«—⁄ ›Ì Õ«·… «· √ﬂÌœ
     * @param pronounIndex int
     * @param root TrilateralVerb
     * @return PresentConjugation
     */
    public ActivePresentVerb createEmphasizedVerb(int pronounIndex, UnaugmentedTrilateralRoot root) {
        return createVerb(pronounIndex, root, PresentConjugationDataContainer.getInstance().getEmphasizedLastDprList() , PresentConjugationDataContainer.getInstance().getEmphasizedConnectedPronounList());
    }

    /**
     * ≈‰‘«¡ ﬁ«∆„…  Õ ÊÌ «·√›⁄«· Õ”» «·÷„«∆—
     * ›Ì Õ«·… «·—›⁄
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
     * ≈‰‘«¡ ﬁ«∆„…  Õ ÊÌ «·√›⁄«· Õ”» «·÷„«∆—
     * ›Ì Õ«·… «·‰’»
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
     * ≈‰‘«¡ ﬁ«∆„…  Õ ÊÌ «·√›⁄«· Õ”» «·÷„«∆—
     * ›Ì Õ«·… «·Ã“„
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
     * ≈‰‘«¡ ﬁ«∆„…  Õ ÊÌ «·√›⁄«· Õ”» «·÷„«∆—
     * ›Ì Õ«·… «· √ﬂÌœ
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
