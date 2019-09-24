
package sarf.verb.trilateral.augmented.active.past;

import com.google.inject.Inject;
import sarf.AugmentationFormula;
import sarf.PastConjugationDataContainer;
import sarf.SystemConstants;
import sarf.verb.trilateral.augmented.AugmentedPastVerb;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;
import sarf.verb.trilateral.augmented.active.past.formula.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
public class AugmentedActivePastConjugator {
    private final PastConjugationDataContainer pastConjugationDataContainer;

    @Inject
    public AugmentedActivePastConjugator(PastConjugationDataContainer pastConjugationDataContainer) {
        this.pastConjugationDataContainer = pastConjugationDataContainer;
    }

    public AugmentedPastVerb createVerb(AugmentedTrilateralRoot root, int pronounIndex, int formulaNo) {
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
        return IntStream.range(0, SystemConstants.PRONOUN_RANGE_END)
                .mapToObj(i -> createVerb(root, i, formulaNo))
                .collect(Collectors.toList());
    }

    public Map createAllVerbList(AugmentedTrilateralRoot root) {
        Map<String, List<AugmentedPastVerb>> result = new HashMap<>();
        for (AugmentationFormula formula : root.getAugmentationList()) {
            var formulaVerbList = createVerbList(root, formula.getFormulaNo());
            result.put(formula.getFormulaNo() + "", formulaVerbList);
        }
        return result;
    }
}
