package sarf.noun.quadriliteral.augmented;

import sarf.PastConjugationDataContainer;
import java.util.Map;
import java.util.HashMap;
import sarf.verb.quadriliteral.augmented.AugmentedPastVerb;
import sarf.verb.quadriliteral.augmented.AugmentedQuadriliteralRoot;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
import sarf.AugmentationFormula;
import sarf.noun.quadriliteral.*;
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
public class AugmentedQuadriliteralActiveParticipleConjugator {
    private AugmentedQuadriliteralActiveParticipleConjugator() {
    }

    private static AugmentedQuadriliteralActiveParticipleConjugator instance = new AugmentedQuadriliteralActiveParticipleConjugator();

    public static AugmentedQuadriliteralActiveParticipleConjugator getInstance() {
        return instance;
    }

    public AugmentedQuadriliteralNoun createNoun(AugmentedQuadriliteralRoot root, int suffixIndex, int formulaNo) {
        String suffix = GenericNounSuffixContainer.getInstance().get(suffixIndex);
        String formulaClassName = getClass().getPackage().getName()+".activeparticiple."+"NounFormula"+formulaNo;
        Object [] parameters = {root, suffix};

        try {
            AugmentedQuadriliteralNoun noun = (AugmentedQuadriliteralNoun) Class.forName(formulaClassName).getConstructors()[0].newInstance(parameters);
            return noun;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List createNounList(AugmentedQuadriliteralRoot root, int formulaNo) {
        List result = new LinkedList();
        for (int i = 0; i < 18; i++) {
            AugmentedQuadriliteralNoun noun = createNoun(root, i, formulaNo);
            result.add(noun);
        }

        return result;

    }

    public Map createAllNounList(AugmentedQuadriliteralRoot root) {
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
