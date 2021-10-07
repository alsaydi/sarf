package sarf.gerund.trilateral.unaugmented;

import java.util.*;

import com.google.inject.Inject;
import sarf.SystemConstants;
import sarf.Word;
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
    private final int[] indexList1 = {2, 4, 8, 10, 14, 16};
    private final int[] indexList2 = {6, 12, 18};

    @Inject
    public TrilateralUnaugmentedNomenGerundConjugator() {
    }

    private List<Word> createEmptyList() {
        List<Word> result = new ArrayList<>(SystemConstants.NOUN_POSSIBLE_STATES);
        for (int i = 1; i <= SystemConstants.NOUN_POSSIBLE_STATES; i++) {
            result.add(Word.empty());
        }
        return result;
    }

    public List<Word> createGerundList(UnaugmentedTrilateralRoot root, String formulaName, INounSuffixContainer genericNounSuffixContainer) {
        var gerundDisplayList = createEmptyList();

        String gerund = genericNounSuffixContainer.getPrefix() + root.getC1() + ArabCharUtil.FATHA + root.getC2() + ArabCharUtil.SKOON + root.getC3();
        for (int value : indexList1) {
            //because index in java start from zero
            int suffixNo = value - 1;
            String suffix = genericNounSuffixContainer.get(suffixNo);
            gerundDisplayList.set(suffixNo, Word.fromString(gerund + suffix));
        }

        if (root.getC2() == 'و' || root.getC2() == 'ي') {
            gerund = genericNounSuffixContainer.getPrefix() + root.getC1() + ArabCharUtil.FATHA + root.getC2() + ArabCharUtil.SKOON + root.getC3();
            for (int value : indexList2) {
                //because index in java start from zero
                int suffixNo = value - 1;
                String suffix = genericNounSuffixContainer.get(suffixNo);
                gerundDisplayList.set(suffixNo, Word.fromString(gerund + suffix));
            }

        }
        else {
            gerund = genericNounSuffixContainer.getPrefix() + root.getC1() + ArabCharUtil.FATHA + root.getC2() + ArabCharUtil.FATHA + root.getC3();
            for (int value : indexList2) {
                //because index in java start from zero
                int suffixNo = value - 1;
                String suffix = genericNounSuffixContainer.get(suffixNo);
                gerundDisplayList.set(suffixNo, Word.fromString(gerund + suffix));
            }
        }

        return gerundDisplayList;
    }

    private static final List<String> formulas = new ArrayList<>(1);
    static {
        formulas.add("فَعْلَة");
    }

    public List<String> getAppliedFormulaList(UnaugmentedTrilateralRoot root) {
        return formulas;
    }
}
