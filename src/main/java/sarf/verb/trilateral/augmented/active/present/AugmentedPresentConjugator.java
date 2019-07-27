package sarf.verb.trilateral.augmented.active.present;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import sarf.SystemConstants;
import sarf.verb.trilateral.augmented.*;
import sarf.AugmentationFormula;
import sarf.PresentConjugationDataContainer;

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
public final class AugmentedPresentConjugator {
    private final List<String> lastDprList;
    private final List<String> connectedPronounList;

    AugmentedPresentConjugator(List<String> lastDprList, List<String> connectedPronounList) {
        this.lastDprList = lastDprList;
        this.connectedPronounList = connectedPronounList;
    }

    private AugmentedPresentVerb createVerb(AugmentedTrilateralRoot root, int pronounIndex, int formulaNo) {
        String cp = PresentConjugationDataContainer.getInstance().getCp(pronounIndex);
        String lastDpr = lastDprList.get(pronounIndex);
        String connectedPronoun = connectedPronounList.get(pronounIndex);
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

    public List<AugmentedPresentVerb> createVerbList(AugmentedTrilateralRoot root, int formulaNo) {
        return IntStream.range(0, SystemConstants.PRONOUN_RANGE_END)
                .mapToObj(i -> createVerb(root, i, formulaNo))
                .collect(Collectors.toList());
    }

    public Map createAllVerbList(AugmentedTrilateralRoot root) {
        Map<String, List<AugmentedPresentVerb>> result = new HashMap<>();
        for (AugmentationFormula formula : root.getAugmentationList()) {
            var formulaVerbList = createVerbList(root, formula.getFormulaNo());
            result.put(formula.getFormulaNo() + "", formulaVerbList);
        }
        return result;
    }
}
