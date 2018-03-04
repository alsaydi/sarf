package sarf.verb.quadriliteral.augmented.active.past;

import java.util.*;
import sarf.AugmentationFormula;
import sarf.PastConjugationDataContainer;
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
public class AugmentedActivePastConjugator {
    private AugmentedActivePastConjugator() {
    }

    private static AugmentedActivePastConjugator instance = new AugmentedActivePastConjugator();

    public static AugmentedActivePastConjugator getInstance() {
        return instance;
    }

    public AugmentedPastVerb createVerb(AugmentedQuadriliteralRoot root, int pronounIndex, int formulaNo) {
        String lastDpa = PastConjugationDataContainer.getInstance().getLastDpa(pronounIndex);
        String connectedPronoun = PastConjugationDataContainer.getInstance().getConnectedPronoun(pronounIndex);
        String formulaClassName = getClass().getPackage().getName()+".formula."+"AugmentedPastVerb"+formulaNo;
        Object [] parameters = {root, lastDpa, connectedPronoun};

        try {
            AugmentedPastVerb verb = (AugmentedPastVerb) Class.forName(formulaClassName).getConstructors()[0].newInstance(parameters);
            return verb;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List createVerbList(AugmentedQuadriliteralRoot root, int formulaNo) {
        List result = new LinkedList();
        for (int i = 0; i < 13; i++) {
            AugmentedPastVerb verb = createVerb(root, i, formulaNo);
            result.add(verb);
        }

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
