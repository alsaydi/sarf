
package sarf.verb.quadriliteral.augmented.active.present;

import java.util.*;
import sarf.AugmentationFormula;
import sarf.PresentConjugationDataContainer;
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
public class AbstractAugmentedPresentConjugator {

    private final List lastDprList;
    private final List connectedPronounList;

    public AbstractAugmentedPresentConjugator(List lastDprList, List connectedPronounList) {
        this.lastDprList = lastDprList;
        this.connectedPronounList = connectedPronounList;
    }

    public AugmentedPresentVerb createVerb(AugmentedQuadrilateralRoot root, int pronounIndex, int formulaNo) {
        String cp = PresentConjugationDataContainer.getInstance().getCp(pronounIndex);
        String lastDpr = (String) lastDprList.get(pronounIndex);
        String connectedPronoun = (String) connectedPronounList.get(pronounIndex);
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

    public List createVerbList(AugmentedQuadrilateralRoot root, int formulaNo) {
        List result = new LinkedList();
        for (int i = 0; i < 13; i++) {
            AugmentedPresentVerb verb = createVerb(root, i, formulaNo);
            result.add(verb);
        }

        return result;
    }

    public Map createAllVerbList(AugmentedQuadrilateralRoot root) {
        Map result = new HashMap();
        for (Object o : root.getAugmentationList()) {
            AugmentationFormula formula = (AugmentationFormula) o;
            List formulaVerbList = createVerbList(root, formula.getFormulaNo());
            result.put(formula.getFormulaNo() + "", formulaVerbList);
        }
        return result;
    }

}
