package sarf.gerund.quadrilateral.unaugmented;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.google.inject.Inject;
import sarf.noun.*;
import sarf.util.*;
import sarf.verb.quadriliteral.QuadrilateralRoot;
import sarf.verb.quadriliteral.unaugmented.*;

import static sarf.SystemConstants.NOUN_POSSIBLE_STATES;

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
    private final int[] form1IndexList = {2, 4, 6, 8, 10, 12, 14, 16, 18};
    private final int[] form2IndexList = {1, 3, 6, 7, 9, 12, 13, 15, 18};
    private final GenericNounSuffixContainer genericNounSuffixContainer;

    private QuadrilateralUnaugmentedGerundConjugatorListener listener;

    @Inject
    public QuadrilateralUnaugmentedGerundConjugator(GenericNounSuffixContainer genericNounSuffixContainer) {
        this.genericNounSuffixContainer = genericNounSuffixContainer;
    }

    public List<QuadrilateralGerund> createGerundList(UnaugmentedQuadrilateralRoot root) {
        var gerundDisplayList = createEmptyList();

        boolean applyForm2 = false;
        if (isQuadrilateralMudaaf(root)) {
            applyForm2 = listener.selectFormNo() == 2;
        }

        if (applyForm2) {
            for (int value : form2IndexList) {
                //because index in java start from zero
                int suffixIndex = value - 1;
                gerundDisplayList.set(suffixIndex, createQuadrilateralGerundOfSecondForm(root, suffixIndex));
            }
        } else {
            for (int value : form1IndexList) {
                //because index in java start from zero
                int suffixIndex = value - 1;
                gerundDisplayList.set(suffixIndex, createQuadrilateralGerundOfFirstForm(root, suffixIndex));
            }
        }

        return gerundDisplayList;
    }

    private boolean isQuadrilateralMudaaf(UnaugmentedQuadrilateralRoot root) {
        return root.getC1() == root.getC3() && root.getC2() == root.getC4();
    }

    private static List<QuadrilateralGerund> createEmptyList() {
        return IntStream.rangeClosed(1, NOUN_POSSIBLE_STATES)
                .mapToObj(i -> new QuadrilateralGerund(""))
                .collect(Collectors.toCollection(() -> new ArrayList<>(18)));
    }

    private QuadrilateralGerund createQuadrilateralGerundOfFirstForm(QuadrilateralRoot root, int suffixIndex){
        var gerund = genericNounSuffixContainer.getPrefix()
                + root.getC1() + ArabCharUtil.FATHA
                + root.getC2() + ArabCharUtil.SKOON
                + root.getC3() + ArabCharUtil.FATHA
                + root.getC4() + genericNounSuffixContainer.get(suffixIndex);
        return  new QuadrilateralGerund(gerund);
    }


    private QuadrilateralGerund createQuadrilateralGerundOfSecondForm(QuadrilateralRoot root, int suffixIndex) {
        var gerund = genericNounSuffixContainer.getPrefix()
                + root.getC1() + ArabCharUtil.KASRA
                + root.getC2() + ArabCharUtil.SKOON
                + root.getC3() + ArabCharUtil.FATHA + "ا"
                + root.getC4() + genericNounSuffixContainer.get(suffixIndex);
        return new QuadrilateralGerund(gerund);
    }

    public void setListener(QuadrilateralUnaugmentedGerundConjugatorListener listener) {
        this.listener = listener;
    }
}
