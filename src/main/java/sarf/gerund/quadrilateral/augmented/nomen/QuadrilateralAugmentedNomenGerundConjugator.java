package sarf.gerund.quadrilateral.augmented.nomen;

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
public class QuadrilateralAugmentedNomenGerundConjugator {
    /* Nomen vicis اسم المرَّة */
    private static final QuadrilateralAugmentedNomenGerundConjugator instance = new QuadrilateralAugmentedNomenGerundConjugator();
    private final Map gerundClassMap = new HashMap();

    private final int[] indexArray = {2, 4, 6, 8, 10, 12, 14, 16, 18};

    private QuadrilateralAugmentedNomenGerundConjugator() {
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

    public static QuadrilateralAugmentedNomenGerundConjugator getInstance() {
        return instance;
    }

    public List createGerundList(AugmentedQuadrilateralRoot root, int formulaNo) {
        String gerundPatternClassName = getClass().getPackage().getName() + ".pattern." + "GerundPattern" + formulaNo;
        List gerundDisplayList = createEmptyList();

        QuadriliteralAugmentedNomenGerund gerundInstance = (QuadriliteralAugmentedNomenGerund) gerundClassMap.get(formulaNo + "");

        for (int i = 0; i < indexArray.length; i++) {
            //because index in java start from zero
            int suffixNo = indexArray[i] - 1;
            Object[] parameters = {root, suffixNo + ""};
            try {
                QuadriliteralAugmentedNomenGerund gerund = (QuadriliteralAugmentedNomenGerund) Class.forName(gerundPatternClassName).getConstructors()[0].newInstance(parameters);
                gerundDisplayList.set(suffixNo, gerund);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return gerundDisplayList;
    }

    private static List createEmptyList() {
        List result = new ArrayList(18);
        for (int i = 1; i <= 18; i++) {
            result.add("");
        }
        return result;
    }

}
