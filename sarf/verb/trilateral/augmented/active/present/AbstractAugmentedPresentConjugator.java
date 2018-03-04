
package sarf.verb.trilateral.augmented.active.present;

import java.util.*;

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
public class AbstractAugmentedPresentConjugator {

    private List lastDprList;
    private List connectedPronounList;

    public AbstractAugmentedPresentConjugator(List lastDprList, List connectedPronounList) {
        this.lastDprList = lastDprList;
        this.connectedPronounList = connectedPronounList;
    }

    public AugmentedPresentVerb createVerb(AugmentedTrilateralRoot root, int pronounIndex, int formulaNo) {
        String cp = PresentConjugationDataContainer.getInstance().getCp(pronounIndex);
        String lastDpr = (String) lastDprList.get(pronounIndex);
        String connectedPronoun = (String) connectedPronounList.get(pronounIndex);
        String formulaClassName = getClass().getPackage().getName()+".formula."+"AugmentedPresentVerb"+formulaNo;
        Object [] parameters = {root, cp, lastDpr, connectedPronoun};

        try {
            AugmentedPresentVerb verb = (AugmentedPresentVerb) Class.forName(formulaClassName).getConstructors()[0].newInstance(parameters);
            return verb;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List createVerbList(AugmentedTrilateralRoot root, int formulaNo) {
        List result = new LinkedList();
        for (int i = 0; i < 13; i++) {
            AugmentedPresentVerb verb = createVerb(root, i, formulaNo);
            result.add(verb);
        }

        return result;
    }

    public Map createAllVerbList(AugmentedTrilateralRoot root) {
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
