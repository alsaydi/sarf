package sarf.noun.trilateral.augmented;

import sarf.PastConjugationDataContainer;
import java.util.Map;
import java.util.HashMap;
import sarf.verb.trilateral.augmented.AugmentedPastVerb;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
import sarf.AugmentationFormula;
import sarf.noun.trilateral.*;
import sarf.noun.GenericNounSuffixContainer;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class AugmentedTrilateralActiveParticipleConjugator {
    private AugmentedTrilateralActiveParticipleConjugator() {
    }

    private static AugmentedTrilateralActiveParticipleConjugator instance = new AugmentedTrilateralActiveParticipleConjugator();

    public static AugmentedTrilateralActiveParticipleConjugator getInstance() {
        return instance;
    }

    public AugmentedTrilateralNoun createNoun(AugmentedTrilateralRoot root, int suffixIndex, int formulaNo) {
        String suffix = GenericNounSuffixContainer.getInstance().get(suffixIndex);
        String formulaClassName = getClass().getPackage().getName()+".activeparticiple."+"NounFormula"+formulaNo;
        Object [] parameters = {root, suffix};

        try {
            AugmentedTrilateralNoun noun = (AugmentedTrilateralNoun) Class.forName(formulaClassName).getConstructors()[0].newInstance(parameters);
            return noun;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List createNounList(AugmentedTrilateralRoot root, int formulaNo) {
        List result = new LinkedList();
        for (int i = 0; i < 18; i++) {
            AugmentedTrilateralNoun noun = createNoun(root, i, formulaNo);
            result.add(noun);
        }

        return result;

    }

    public Map createAllNounList(AugmentedTrilateralRoot root) {
        Map result = new HashMap();
        Iterator iter = root.getAugmentationList().iterator();
        while (iter.hasNext()) {
            AugmentationFormula formula = (AugmentationFormula) iter.next();
            List formulaVerbList = createNounList(root, formula.getFormulaNo());
            result.put(formula.getFormulaNo()+"", formulaVerbList);
        }
        return result;
    }

}
