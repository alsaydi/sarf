package sarf.gerund.trilateral.unaugmented;

import java.util.*;

import sarf.SystemConstants;
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
    private final int[] indexList = {2, 8, 14};
    private final GenericNounSuffixContainer genericNounSuffixContainer;

    public QualityGerundConjugator(GenericNounSuffixContainer genericNounSuffixContainer) {
        this.genericNounSuffixContainer = genericNounSuffixContainer;
    }

    private List<String> createEmptyList() {
        List<String> result = new ArrayList(SystemConstants.NOUN_POSSIBLE_STATES);
        for (int i = 1; i <= SystemConstants.NOUN_POSSIBLE_STATES; i++) {
            result.add("");
        }
        return result;
    }

    public List<String> createGerundList(UnaugmentedTrilateralRoot root, String formulaName) {
        var gerundDisplayList = createEmptyList();

        String gerund = genericNounSuffixContainer.getPrefix()+root.getC1() + ArabCharUtil.KASRA + root.getC2() + ArabCharUtil.SKOON + root.getC3();
        for (int value : indexList) {
            //because index in java start from zero
            int suffixNo = value - 1;
            String suffix = genericNounSuffixContainer.get(suffixNo);
            gerundDisplayList.set(suffixNo, gerund + suffix);
        }

        return gerundDisplayList;

    }

    public List getAppliedFormulaList(UnaugmentedTrilateralRoot root) {
        return null;
    }

}
