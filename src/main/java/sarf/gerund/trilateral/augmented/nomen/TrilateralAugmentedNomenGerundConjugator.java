package sarf.gerund.trilateral.augmented.nomen;

import sarf.gerund.trilateral.augmented.nomen.pattern.GerundPatternEmpty;
import sarf.verb.trilateral.augmented.*;
import java.util.*;

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
public class TrilateralAugmentedNomenGerundConjugator {
    private static TrilateralAugmentedNomenGerundConjugator instance = new TrilateralAugmentedNomenGerundConjugator();
    private Map<String, TrilateralAugmentedNomenGerund> gerundClassMap = new HashMap<>();

    private int[] indexArray = {2, 4, 6, 8, 10, 12, 14, 16, 18};

    private TrilateralAugmentedNomenGerundConjugator() {
        for (int i = 1; i <= 12; i++) {
            String gerundClassName = getClass().getPackage().getName() + ".pattern." + "GerundPattern" + i;
            try {
                var gerundInstance = (TrilateralAugmentedNomenGerund) Class.forName(gerundClassName).getConstructor().newInstance();
                gerundClassMap.put(i + "", gerundInstance);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static TrilateralAugmentedNomenGerundConjugator getInstance() {
        return instance;
    }

    public List<TrilateralAugmentedNomenGerund> createGerundList(AugmentedTrilateralRoot root, int formulaNo) {
        var gerundPatternClassName = getClass().getPackage().getName() + ".pattern." + "GerundPattern" + formulaNo;
        var gerundDisplayList = createEmptyList();

        for (int i = 0; i < indexArray.length; i++) {
            //because index in java start from zero
            int suffixNo = indexArray[i] - 1;
            Object[] parameters = {root, suffixNo + ""};
            try {
                TrilateralAugmentedNomenGerund gerund = (TrilateralAugmentedNomenGerund) Class.forName(gerundPatternClassName).getConstructor(root.getClass(), "".getClass()).newInstance(parameters);
                gerundDisplayList.set(suffixNo, gerund);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return gerundDisplayList;
    }

    private List<TrilateralAugmentedNomenGerund> createEmptyList() {
        var result = new ArrayList<TrilateralAugmentedNomenGerund>(18);
        for (int i = 1; i <= 18; i++) {
            result.add(new GerundPatternEmpty());
        }
        return result;
    }

}
