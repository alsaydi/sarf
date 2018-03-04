package sarf.verb.trilateral.augmented.passive.past;

import java.util.*;

import sarf.verb.trilateral.augmented.*;
import sarf.AugmentationFormula;
import sarf.PastConjugationDataContainer;

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
public class AugmentedPassivePastConjugator {
    private AugmentedPassivePastConjugator() {
    }

    private static AugmentedPassivePastConjugator instance = new AugmentedPassivePastConjugator();

    public static AugmentedPassivePastConjugator getInstance() {
        return instance;
    }

    public AugmentedPastVerb createVerb(AugmentedTrilateralRoot root, int pronounIndex, int formulaNo) {
        String lastDpa = PastConjugationDataContainer.getInstance().getLastDpa(pronounIndex);
        String connectedPronoun = PastConjugationDataContainer.getInstance().getConnectedPronoun(pronounIndex);
        String formulaClassName = getClass().getPackage().getName() + ".formula." + "AugmentedPastVerb" + formulaNo;
        Object[] parameters = {root, lastDpa, connectedPronoun};

        try {
            AugmentedPastVerb verb = (AugmentedPastVerb) Class.forName(formulaClassName).getConstructors()[0].newInstance(parameters);
            return verb;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List createVerbList(AugmentedTrilateralRoot root, int formulaNo) {
        AugmentationFormula augmentationFormula = root.getAugmentationFormula(formulaNo);
        if (augmentationFormula.getTransitive() == 'á') {
            return createLazzemVerbList(root, formulaNo);
        }
        else {
            List result = new LinkedList();
            for (int i = 0; i < 13; i++) {
                AugmentedPastVerb verb = createVerb(root, i, formulaNo);
                result.add(verb);
            }
            return result;
        }
    }

    //ÇáãÈäí áãÌåæá ÇááÇÒã ÝÞØ ãÚ åæ Çæ åí
    public List createLazzemVerbList(AugmentedTrilateralRoot root, int formulaNo) {
        List result = new LinkedList();
        for (int i = 0; i < 13; i++) {
            if (i == 7 || i == 8) {
                AugmentedPastVerb verb = createVerb(root, i, formulaNo);
                result.add(verb);
            }
            else {
                result.add(null);
            }
        }
        return result;
    }

}
