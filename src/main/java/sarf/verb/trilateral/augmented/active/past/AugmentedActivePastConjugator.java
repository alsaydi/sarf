
package sarf.verb.trilateral.augmented.active.past;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import sarf.SystemConstants;
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
public class AugmentedActivePastConjugator {
    private AugmentedActivePastConjugator() {
    }

    private static final AugmentedActivePastConjugator instance = new AugmentedActivePastConjugator();

    public static AugmentedActivePastConjugator getInstance() {
        return instance;
    }

    public AugmentedPastVerb createVerb(AugmentedTrilateralRoot root, int pronounIndex, int formulaNo) {
        String lastDpa = PastConjugationDataContainer.getInstance().getLastDpa(pronounIndex);
        String connectedPronoun = PastConjugationDataContainer.getInstance().getConnectedPronoun(pronounIndex);
        String formulaClassName = getClass().getPackage().getName()+".formula."+"AugmentedPastVerb"+formulaNo;
        Object [] parameters = {root, lastDpa, connectedPronoun};

        try {
            return (AugmentedPastVerb) Class.forName(formulaClassName).getConstructors()[0].newInstance(parameters);
        }
        catch (Exception ex) {
            ex.printStackTrace();
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
