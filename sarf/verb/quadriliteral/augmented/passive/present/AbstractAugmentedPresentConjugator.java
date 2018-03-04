
package sarf.verb.quadriliteral.augmented.passive.present;

import java.util.*;
import sarf.AugmentationFormula;
import sarf.PresentConjugationDataContainer;
import sarf.verb.quadriliteral.augmented.*;

/**
 * <p>Title: Sarf</p>
 *
 * <p>Description: ?????? ???????</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class AbstractAugmentedPresentConjugator {

    private List lastDprList;
    private List connectedPronounList;

    public AbstractAugmentedPresentConjugator(List lastDprList, List connectedPronounList) {
        this.lastDprList = lastDprList;
        this.connectedPronounList = connectedPronounList;
    }

    public AugmentedPresentVerb createVerb(AugmentedQuadriliteralRoot root, int pronounIndex, int formulaNo) {
        String cp = PresentConjugationDataContainer.getInstance().getCp(pronounIndex);
        String lastDpr = (String) lastDprList.get(pronounIndex);
        String connectedPronoun = (String) connectedPronounList.get(pronounIndex);
        String formulaClassName = getClass().getPackage().getName()+".formula."+"AugmentedPresentVerb"+formulaNo;
        Object [] parameters = {root, cp, lastDpr, connectedPronoun};

        try {
            AugmentedPresentVerb verb = (AugmentedPresentVerb) Class.forName(formulaClassName).getConstructors()[0].newInstance(parameters);
            return verb;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List createVerbList(AugmentedQuadriliteralRoot root, int formulaNo) {
        AugmentationFormula augmentationFormula = root.getAugmentationFormula(formulaNo);
        if (augmentationFormula.getTransitive() == 'á') {
            return createLazzemVerbList(root, formulaNo);
        }
        else {

            List result = new LinkedList();
            for (int i = 0; i < 13; i++) {
                AugmentedPresentVerb verb = createVerb(root, i, formulaNo);
                result.add(verb);
            }

            return result;
        }
    }

    //ÇáãÈäí áãÌåæá ÇááÇÒã ÝÞØ ãÚ åæ Çæ åí
    public List createLazzemVerbList(AugmentedQuadriliteralRoot root, int formulaNo) {
        List result = new LinkedList();
        for (int i = 0; i < 13; i++) {
            if (i == 7 || i == 8) {
                AugmentedPresentVerb verb = createVerb(root, i, formulaNo);
                result.add(verb);
            }
            else {
                result.add(null);
            }
        }
        return result;
    }


}
