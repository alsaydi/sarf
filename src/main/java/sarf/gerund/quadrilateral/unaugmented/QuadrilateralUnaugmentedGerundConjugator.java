package sarf.gerund.quadrilateral.unaugmented;

import java.util.*;
import sarf.noun.*;
import sarf.util.*;
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
public class QuadrilateralUnaugmentedGerundConjugator {
    private static final QuadrilateralUnaugmentedGerundConjugator instance = new QuadrilateralUnaugmentedGerundConjugator();

    private final int[] form1IndexList = {2, 4, 6, 8, 10, 12, 14, 16, 18};
    private final int[] form2IndexList = {1, 3, 6, 7, 9, 12, 13, 15, 18};

    private QuadriliteralUnaugmentedGerundConjugatorListener listener;

    private QuadrilateralUnaugmentedGerundConjugator() {
    }

    public static QuadrilateralUnaugmentedGerundConjugator getInstance() {
        return instance;
    }

    public List<String> createGerundList(UnaugmentedQuadrilateralRoot root) {
        var gerundDisplayList = createEmptyList();

        boolean applyForm2 = false;
        if (root.getC1() == root.getC3() && root.getC2() == root.getC4()) {
            applyForm2 = listener.selectFormNo() == 2;
        }

        if (!applyForm2) {
            String gerund = GenericNounSuffixContainer.getInstance().getPrefix() + root.getC1() + ArabCharUtil.FATHA + root.getC2() + ArabCharUtil.SKOON + root.getC3() + ArabCharUtil.FATHA + root.getC4();
            for (int i = 0; i < form1IndexList.length; i++) {
                //because index in java start from zero
                int suffixNo = form1IndexList[i] - 1;
                String suffix = GenericNounSuffixContainer.getInstance().get(suffixNo);
                gerundDisplayList.set(suffixNo, gerund + suffix);
            }
        }
        else {
            String gerund = GenericNounSuffixContainer.getInstance().getPrefix()+root.getC1() + ArabCharUtil.KASRA + root.getC2() + ArabCharUtil.SKOON + root.getC3() + ArabCharUtil.FATHA +"ا"+ root.getC4();
            for (int i = 0; i < form2IndexList.length; i++) {
                //because index in java start from zero
                int suffixNo = form2IndexList[i] - 1;
                String suffix = GenericNounSuffixContainer.getInstance().get(suffixNo);
                gerundDisplayList.set(suffixNo, gerund + suffix);
            }
        }

        return gerundDisplayList;
    }

    public List<String> createEmptyList() {
        var result = new ArrayList<String>(18);
        for (int i = 1; i <= 18; i++) {
            result.add("");
        }
        return result;
    }

    public void setListener(QuadriliteralUnaugmentedGerundConjugatorListener listener) {
        this.listener = listener;
    }

}
