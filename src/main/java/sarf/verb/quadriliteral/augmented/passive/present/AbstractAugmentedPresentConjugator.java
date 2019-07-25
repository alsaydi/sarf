
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

    private List<String> lastDprList;
    private List<String> connectedPronounList;

    public AbstractAugmentedPresentConjugator(List<String> lastDprList, List<String> connectedPronounList) {
        this.lastDprList = lastDprList;
        this.connectedPronounList = connectedPronounList;
    }

    public AugmentedPresentVerb createVerb(AugmentedQuadrilateralRoot root, int pronounIndex, int formulaNo) {
        String cp = PresentConjugationDataContainer.getInstance().getCp(pronounIndex);
        String lastDpr = (String) lastDprList.get(pronounIndex);
        String connectedPronoun = (String) connectedPronounList.get(pronounIndex);
        String formulaClassName = getClass().getPackage().getName()+".formula."+"AugmentedPresentVerb"+formulaNo;
        Object [] parameters = {root, cp, lastDpr, connectedPronoun};

        try {
            return (AugmentedPresentVerb) Class.forName(formulaClassName).getConstructors()[0].newInstance(parameters);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List createVerbList(AugmentedQuadrilateralRoot root, int formulaNo) {
        AugmentationFormula augmentationFormula = root.getAugmentationFormula(formulaNo);
        if (augmentationFormula.getTransitive() == 'ل') {
            return createLazzemVerbList(root, formulaNo);
        }
        else {

            List<AugmentedPresentVerb> result = new LinkedList<AugmentedPresentVerb>();
            for (int i = 0; i < 13; i++) {
                AugmentedPresentVerb verb = createVerb(root, i, formulaNo);
                result.add(verb);
            }

            return result;
        }
    }

    //المبني لمجهول اللازم فقط مع هو او هي
    public List<AugmentedPresentVerb> createLazzemVerbList(AugmentedQuadrilateralRoot root, int formulaNo) {
        List<AugmentedPresentVerb> result = new LinkedList<AugmentedPresentVerb>();
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
