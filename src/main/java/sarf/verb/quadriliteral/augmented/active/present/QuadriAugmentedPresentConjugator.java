
package sarf.verb.quadriliteral.augmented.active.present;

import java.util.*;
import sarf.AugmentationFormula;
import sarf.PresentConjugationDataContainer;
import sarf.SystemConstants;
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
public class QuadriAugmentedPresentConjugator {
    private final List lastDprList;
    private final List connectedPronounList;

    public QuadriAugmentedPresentConjugator(List lastDprList, List connectedPronounList) {
        this.lastDprList = lastDprList;
        this.connectedPronounList = connectedPronounList;
    }

    public AugmentedPresentVerb createVerb(AugmentedQuadrilateralRoot root, int pronounIndex, int formulaNo) {
        String cp = PresentConjugationDataContainer.getCp(pronounIndex);
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

    public List<AugmentedPresentVerb> createVerbList(AugmentedQuadrilateralRoot root, int formulaNo) {
        List<AugmentedPresentVerb> result = new ArrayList<>();
        for (int i = 0; i < SystemConstants.PRONOUN_RANGE_END; i++) {
            AugmentedPresentVerb verb = createVerb(root, i, formulaNo);
            result.add(verb);
        }
        return result;
    }
}
