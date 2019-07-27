
package sarf.verb.trilateral.augmented.imperative;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import sarf.SystemConstants;
import sarf.verb.trilateral.augmented.*;
import sarf.AugmentationFormula;

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
public final class AugmentedImperativeConjugator {
    private final List<String> lastDimList;
    private final List<String> connectedPronounList;

    AugmentedImperativeConjugator(List<String> lastDimList, List<String> connectedPronounList) {
        this.lastDimList = lastDimList;
        this.connectedPronounList = connectedPronounList;
    }

    private AugmentedImperativeVerb createVerb(AugmentedTrilateralRoot root, int pronounIndex, int formulaNo) {
        String lastDim = lastDimList.get(pronounIndex);
        String connectedPronoun = connectedPronounList.get(pronounIndex);
        String formulaClassName = getClass().getPackage().getName()+".formula."+"AugmentedImperativeVerb"+formulaNo;
        Object [] parameters = {root,  lastDim, connectedPronoun};

        try {
            return (AugmentedImperativeVerb) Class.forName(formulaClassName).getConstructors()[0].newInstance(parameters);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<AugmentedImperativeVerb> createVerbList(AugmentedTrilateralRoot root, int formulaNo) {
        List<AugmentedImperativeVerb> result = IntStream.range(0, SystemConstants.PRONOUN_RANGE_END)
                .mapToObj(i -> (AugmentedImperativeVerb) null).collect(Collectors.toList());
        //that indexing because the pronouns is existed only for that indexes
        for (int i = 2; i < 7; i++) {
            AugmentedImperativeVerb verb = createVerb(root, i, formulaNo);
            result.set(i, verb);
        }
        return result;
    }

    private Map createAllVerbList(AugmentedTrilateralRoot root) {
        var result = new HashMap<String, List<AugmentedImperativeVerb>>();
        for (AugmentationFormula formula : root.getAugmentationList()) {
            var formulaVerbList = createVerbList(root, formula.getFormulaNo());
            result.put(formula.getFormulaNo() + "", formulaVerbList);
        }
        return result;
    }

}
