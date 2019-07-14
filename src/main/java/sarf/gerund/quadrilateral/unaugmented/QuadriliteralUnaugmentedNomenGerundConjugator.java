package sarf.gerund.quadrilateral.unaugmented;

import java.util.*;
import sarf.noun.*;
import sarf.util.*;
import sarf.verb.trilateral.unaugmented.*;
import sarf.verb.quadriliteral.unaugmented.*;

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
public class QuadriliteralUnaugmentedNomenGerundConjugator {
    private static QuadriliteralUnaugmentedNomenGerundConjugator instance = new QuadriliteralUnaugmentedNomenGerundConjugator();

    private int[] indexList = {2, 4, 6, 8, 10, 12, 14, 16, 18};

    private QuadriliteralUnaugmentedNomenGerundConjugator() {
    }

    public static QuadriliteralUnaugmentedNomenGerundConjugator getInstance() {
        return instance;
    }

    public List createGerundList(UnaugmentedQuadriliteralRoot root) {
        List gerundDisplayList = createEmptyList();

        String gerund = GenericNounSuffixContainer.getInstance().getPrefix()+root.getC1() + ArabCharUtil.FATHA + root.getC2() + ArabCharUtil.SKOON + root.getC3()+ArabCharUtil.FATHA+root.getC4();
        for (int i = 0; i < indexList.length; i++) {
            //because index in java start from zero
            int suffixNo = indexList[i] - 1;
            String suffix = GenericNounSuffixContainer.getInstance().get(suffixNo);
            gerundDisplayList.set(suffixNo, gerund + suffix);
        }

        return gerundDisplayList;
    }

    public List createEmptyList() {
        List result = new ArrayList(18);
        for (int i = 1; i <= 18; i++) {
            result.add("");
        }
        return result;
    }

}
