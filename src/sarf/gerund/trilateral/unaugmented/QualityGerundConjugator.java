package sarf.gerund.trilateral.unaugmented;

import java.util.*;
import sarf.noun.*;
import sarf.util.*;
import sarf.verb.trilateral.unaugmented.*;

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
public class QualityGerundConjugator implements IUnaugmentedTrilateralGerundConjugator{
    private static QualityGerundConjugator instance = new QualityGerundConjugator();

    private int[] indexList = {2, 8, 14};

    private QualityGerundConjugator() {
    }

    public static QualityGerundConjugator getInstance() {
        return instance;
    }

    public List createEmptyList() {
        List result = new ArrayList(18);
        for (int i = 1; i <= 18; i++) {
            result.add("");
        }
        return result;
    }

    public List createGerundList(UnaugmentedTrilateralRoot root, String formulaName) {
        List gerundDisplayList = createEmptyList();

        String gerund = GenericNounSuffixContainer.getInstance().getPrefix()+root.getC1() + ArabCharUtil.KASRA + root.getC2() + ArabCharUtil.SKOON + root.getC3();
        for (int i = 0; i < indexList.length; i++) {
            //because index in java start from zero
            int suffixNo = indexList[i] - 1;
            String suffix = GenericNounSuffixContainer.getInstance().get(suffixNo);
            gerundDisplayList.set(suffixNo, gerund + suffix);
        }

        return gerundDisplayList;

    }

    public List getAppliedFormulaList(UnaugmentedTrilateralRoot root) {
        return null;
    }

}
