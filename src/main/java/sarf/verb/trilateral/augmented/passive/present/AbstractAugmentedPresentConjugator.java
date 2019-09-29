
package sarf.verb.trilateral.augmented.passive.present;

import sarf.AugmentationFormula;
import sarf.PresentConjugationDataContainer;
import sarf.verb.trilateral.augmented.AugmentedPresentVerb;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;

import java.util.ArrayList;
import java.util.List;

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

    private final List lastDprList;
    private final List connectedPronounList;

    public AbstractAugmentedPresentConjugator(List lastDprList, List connectedPronounList) {
        this.lastDprList = lastDprList;
        this.connectedPronounList = connectedPronounList;
    }

    public AugmentedPresentVerb createVerb(AugmentedTrilateralRoot root, int pronounIndex, int formulaNo) {
        String cp = PresentConjugationDataContainer.getCp(pronounIndex);
        String lastDpr = (String) lastDprList.get(pronounIndex);
        String connectedPronoun = (String) connectedPronounList.get(pronounIndex);
        String formulaClassName = getClass().getPackage().getName() + ".formula." + "AugmentedPresentVerb" + formulaNo;
        Object[] parameters = {root, cp, lastDpr, connectedPronoun};

        try {
            return (AugmentedPresentVerb) Class.forName(formulaClassName).getConstructors()[0].newInstance(parameters);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<AugmentedPresentVerb> createVerbList(AugmentedTrilateralRoot root, int formulaNo) {
        AugmentationFormula augmentationFormula = root.getAugmentationFormula(formulaNo);
        if (augmentationFormula.getTransitive() == 'ل') {
            return createLazzemVerbList(root, formulaNo);
        } else {

            var result = new ArrayList<AugmentedPresentVerb>();
            for (int i = 0; i < 13; i++) {
                AugmentedPresentVerb verb = createVerb(root, i, formulaNo);
                result.add(verb);
            }
            return result;
        }
    }

    //المبني لمجهول اللازم فقط مع هو او هي
    private List<AugmentedPresentVerb> createLazzemVerbList(AugmentedTrilateralRoot root, int formulaNo) {
        var result = new ArrayList<AugmentedPresentVerb>();
        for (int i = 0; i < 13; i++) {
            if (i == 7 || i == 8) {
                AugmentedPresentVerb verb = createVerb(root, i, formulaNo);
                result.add(verb);
            } else {
                result.add(null);
            }
        }
        return result;
    }


}
