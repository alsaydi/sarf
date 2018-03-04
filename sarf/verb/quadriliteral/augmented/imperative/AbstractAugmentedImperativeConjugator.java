package sarf.verb.quadriliteral.augmented.imperative;

import java.util.*;
import sarf.AugmentationFormula;
import sarf.verb.quadriliteral.augmented.*;
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

    private List lastDimList;
    private List connectedPronounList;

    public AbstractAugmentedImperativeConjugator(List lastDimList, List connectedPronounList) {
        this.lastDimList = lastDimList;
        this.connectedPronounList = connectedPronounList;
    }

    public AugmentedImperativeVerb createVerb(AugmentedQuadriliteralRoot root, int pronounIndex, int formulaNo) {
        String lastDim = (String) lastDimList.get(pronounIndex);
        String connectedPronoun = (String) connectedPronounList.get(pronounIndex);
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

    public List createVerbList(AugmentedQuadriliteralRoot root, int formulaNo) {
        List result = new LinkedList();
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

    public Map createAllVerbList(AugmentedQuadriliteralRoot root) {
        Map result = new HashMap();
        Iterator iter = root.getAugmentationList().iterator();
        while (iter.hasNext()) {
            AugmentationFormula formula = (AugmentationFormula) iter.next();
            List formulaVerbList = createVerbList(root, formula.getFormulaNo());
            result.put(formula.getFormulaNo()+"", formulaVerbList);
        }
        return result;
    }

}
