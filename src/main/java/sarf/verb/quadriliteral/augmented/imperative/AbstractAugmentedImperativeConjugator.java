package sarf.verb.quadriliteral.augmented.imperative;

import java.util.*;
import sarf.AugmentationFormula;
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
public class AbstractAugmentedImperativeConjugator {

    private List<String> lastDimList;
    private List<String> connectedPronounList;

    public AbstractAugmentedImperativeConjugator(List<String> lastDimList, List<String> connectedPronounList) {
        this.lastDimList = lastDimList;
        this.connectedPronounList = connectedPronounList;
    }

    public AugmentedImperativeVerb createVerb(AugmentedQuadrilateralRoot root, int pronounIndex, int formulaNo) {
        String lastDim = lastDimList.get(pronounIndex);
        String connectedPronoun = connectedPronounList.get(pronounIndex);
        String formulaClassName = getClass().getPackage().getName()+".formula."+"AugmentedImperativeVerb"+formulaNo;
        Object [] parameters = {root,  lastDim, connectedPronoun};

        try {
            AugmentedImperativeVerb verb = (AugmentedImperativeVerb) Class.forName(formulaClassName).getConstructors()[0].newInstance(parameters);
            return verb;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<AugmentedImperativeVerb> createVerbList(AugmentedQuadrilateralRoot root, int formulaNo) {
        List<AugmentedImperativeVerb> result = new LinkedList<AugmentedImperativeVerb>();
        result.add(null);
        result.add(null);
        //that indexing because the pronouns is existed only for that indecis
        for (int i = 2; i < 7; i++) {
            AugmentedImperativeVerb verb = createVerb(root, i, formulaNo);
            result.add(verb);
        }
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);

        return result;
    }

    public Map<String, List<AugmentedImperativeVerb>> createAllVerbList(AugmentedQuadrilateralRoot root) {
        Map<String, List<AugmentedImperativeVerb>> result = new HashMap<String, List<AugmentedImperativeVerb>>();
        Iterator<AugmentationFormula> iter = root.getAugmentationList().iterator();
        while (iter.hasNext()) {
            AugmentationFormula formula = iter.next();
            List<AugmentedImperativeVerb> formulaVerbList = createVerbList(root, formula.getFormulaNo());
            result.put(formula.getFormulaNo()+"", formulaVerbList);
        }
        return result;
    }

}
