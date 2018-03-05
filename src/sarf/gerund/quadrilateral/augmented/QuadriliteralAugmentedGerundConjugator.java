package sarf.gerund.quadrilateral.augmented;

import sarf.verb.trilateral.augmented.*;
import java.util.*;
import sarf.*;
import sarf.verb.quadriliteral.augmented.*;

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
public class QuadriliteralAugmentedGerundConjugator {
    private static QuadriliteralAugmentedGerundConjugator instance = new QuadriliteralAugmentedGerundConjugator();
    private Map gerundClassMap = new HashMap();

    private int[] indexArray = {1, 3, 6, 7, 9, 12, 13, 15, 18};

    private QuadriliteralAugmentedGerundConjugator() {
        for (int i = 1; i <= 3; i++) {
            String gerundClassName = getClass().getPackage().getName() + ".pattern." + "GerundPattern" + i;
            try {
                Class gerundClass = Class.forName(gerundClassName);
                gerundClassMap.put(i + "", gerundClass.newInstance());
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static QuadriliteralAugmentedGerundConjugator getInstance() {
        return instance;
    }

    public List createGerundList(AugmentedQuadriliteralRoot root, int formulaNo) {
        String gerundPatternClassName = getClass().getPackage().getName() + ".pattern." + "GerundPattern" + formulaNo;
        List gerundDisplayList = createEmptyList();

        QuadriliteralAugmentedGerund gerundInstance = (QuadriliteralAugmentedGerund) gerundClassMap.get(formulaNo + "");

        for (int i = 0; i < indexArray.length; i++) {
            //because index in java start from zero
            int suffixNo = indexArray[i] - 1;
            Object[] parameters = {root, suffixNo + ""};
            try {
                QuadriliteralAugmentedGerund gerund = (QuadriliteralAugmentedGerund) Class.forName(gerundPatternClassName).getConstructors()[0].newInstance(parameters);
                gerundDisplayList.set(suffixNo, gerund);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return gerundDisplayList;
    }

    /**
     * the key in the map are the gerund pattern, the value are 18 string can be diplayed
     * on the NounConjugationUI
     * @param root AugmentedTrilateralRoot
     * @return Map
     */
    public Map createGerundMap(AugmentedQuadriliteralRoot root) {
        Map result = new HashMap();
        Iterator iter = root.getAugmentationList().iterator();
        while (iter.hasNext()) {
            AugmentationFormula augmentationFormula = (AugmentationFormula) iter.next();

            QuadriliteralAugmentedGerund gerundInstance = (QuadriliteralAugmentedGerund) gerundClassMap.get(augmentationFormula.getFormulaNo() + "");
            result.put(gerundInstance.getPattern(), createGerundList(root, augmentationFormula.getFormulaNo()));

        }
        return result;
    }

    public List createEmptyList() {
        List result = new ArrayList(18);
        for (int i = 1; i <= 18; i++) {
            result.add("");
        }
        return result;
    }

}
