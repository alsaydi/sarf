package sarf.verb.trilateral.augmented.passive.past;

import java.util.*;

import com.google.inject.Inject;
import sarf.SystemConstants;
import sarf.verb.trilateral.augmented.*;
import sarf.AugmentationFormula;
import sarf.PastConjugationDataContainer;
import sarf.verb.trilateral.augmented.passive.past.formula.AugmentedPastVerb1;
import sarf.verb.trilateral.augmented.passive.past.formula.AugmentedPastVerb10;
import sarf.verb.trilateral.augmented.passive.past.formula.AugmentedPastVerb11;
import sarf.verb.trilateral.augmented.passive.past.formula.AugmentedPastVerb12;
import sarf.verb.trilateral.augmented.passive.past.formula.AugmentedPastVerb2;
import sarf.verb.trilateral.augmented.passive.past.formula.AugmentedPastVerb3;
import sarf.verb.trilateral.augmented.passive.past.formula.AugmentedPastVerb4;
import sarf.verb.trilateral.augmented.passive.past.formula.AugmentedPastVerb5;
import sarf.verb.trilateral.augmented.passive.past.formula.AugmentedPastVerb6;
import sarf.verb.trilateral.augmented.passive.past.formula.AugmentedPastVerb7;
import sarf.verb.trilateral.augmented.passive.past.formula.AugmentedPastVerb8;
import sarf.verb.trilateral.augmented.passive.past.formula.AugmentedPastVerb9;

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
    private final PastConjugationDataContainer pastConjugationDataContainer;

    @Inject
    public AugmentedPassivePastConjugator(PastConjugationDataContainer pastConjugationDataContainer) {
        this.pastConjugationDataContainer = pastConjugationDataContainer;
    }

    private AugmentedPastVerb createVerb(AugmentedTrilateralRoot root, int pronounIndex, int formulaNo) {
        String lastDpa = pastConjugationDataContainer.getLastDpa(pronounIndex);
        String connectedPronoun = pastConjugationDataContainer.getConnectedPronoun(pronounIndex);

        switch (formulaNo) {
            case 1:
                return new AugmentedPastVerb1(root, lastDpa, connectedPronoun);
            case 2:
                return new AugmentedPastVerb2(root, lastDpa, connectedPronoun);
            case 3:
                return new AugmentedPastVerb3(root, lastDpa, connectedPronoun);
            case 4:
                return new AugmentedPastVerb4(root, lastDpa, connectedPronoun);
            case 5:
                return new AugmentedPastVerb5(root, lastDpa, connectedPronoun);
            case 6:
                return new AugmentedPastVerb6(root, lastDpa, connectedPronoun);
            case 7:
                return new AugmentedPastVerb7(root, lastDpa, connectedPronoun);
            case 8:
                return new AugmentedPastVerb8(root, lastDpa, connectedPronoun);
            case 9:
                return new AugmentedPastVerb9(root, lastDpa, connectedPronoun);
            case 10:
                return new AugmentedPastVerb10(root, lastDpa, connectedPronoun);
            case 11:
                return new AugmentedPastVerb11(root, lastDpa, connectedPronoun);
            case 12:
                return new AugmentedPastVerb12(root, lastDpa, connectedPronoun);
        }
        return null;
    }

    public List<AugmentedPastVerb> createVerbList(AugmentedTrilateralRoot root, int formulaNo) {
        AugmentationFormula augmentationFormula = root.getAugmentationFormula(formulaNo);
        if (augmentationFormula.getTransitive() == 'ل') {
            return createLazzemVerbList(root, formulaNo);
        }
        else {
            List<AugmentedPastVerb> result = new ArrayList<>();
            for (int i = 0; i < SystemConstants.PRONOUN_RANGE_END; i++) {
                AugmentedPastVerb verb = createVerb(root, i, formulaNo);
                result.add(verb);
            }
            return result;
        }
    }

    //المبني لمجهول اللازم فقط مع هو او هي
    private List<AugmentedPastVerb> createLazzemVerbList(AugmentedTrilateralRoot root, int formulaNo) {
        var result = new ArrayList<AugmentedPastVerb>();
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
