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
public class TrilateralUnaugmentedNomenGerundConjugator implements IUnaugmentedTrilateralGerundConjugator {
    private static TrilateralUnaugmentedNomenGerundConjugator instance = new TrilateralUnaugmentedNomenGerundConjugator();

    private int[] indexList1 = {2, 4, 8, 10, 14, 16};
    private int[] indexList2 = {6, 12, 18};

    private TrilateralUnaugmentedNomenGerundConjugator() {
    }

    public static TrilateralUnaugmentedNomenGerundConjugator getInstance() {
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

        String gerund = GenericNounSuffixContainer.getInstance().getPrefix() + root.getC1() + ArabCharUtil.FATHA + root.getC2() + ArabCharUtil.SKOON + root.getC3();
        for (int i = 0; i < indexList1.length; i++) {
            //because index in java start from zero
            int suffixNo = indexList1[i] - 1;
            String suffix = GenericNounSuffixContainer.getInstance().get(suffixNo);
            gerundDisplayList.set(suffixNo, gerund + suffix);
        }

        if (root.getC2() == 'æ' || root.getC2() == 'í') {
            gerund = GenericNounSuffixContainer.getInstance().getPrefix() + root.getC1() + ArabCharUtil.FATHA + root.getC2() + ArabCharUtil.SKOON + root.getC3();
            for (int i = 0; i < indexList2.length; i++) {
                //because index in java start from zero
                int suffixNo = indexList2[i] - 1;
                String suffix = GenericNounSuffixContainer.getInstance().get(suffixNo);
                gerundDisplayList.set(suffixNo, gerund + suffix);
            }

        }
        else {
            gerund = GenericNounSuffixContainer.getInstance().getPrefix() + root.getC1() + ArabCharUtil.FATHA + root.getC2() + ArabCharUtil.FATHA + root.getC3();
            for (int i = 0; i < indexList2.length; i++) {
                //because index in java start from zero
                int suffixNo = indexList2[i] - 1;
                String suffix = GenericNounSuffixContainer.getInstance().get(suffixNo);
                gerundDisplayList.set(suffixNo, gerund + suffix);
            }

        }

        return gerundDisplayList;
    }



    static List formulas = new ArrayList(1);
    static {
        formulas.add("ÝóÚúáóÉ");
    }

    public List getAppliedFormulaList(UnaugmentedTrilateralRoot root) {
        return formulas;
    }

}
