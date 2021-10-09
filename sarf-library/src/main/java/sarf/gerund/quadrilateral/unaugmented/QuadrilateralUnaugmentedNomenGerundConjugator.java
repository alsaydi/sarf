package sarf.gerund.quadrilateral.unaugmented;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.google.inject.Inject;
import sarf.noun.*;
import sarf.util.*;
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
public class QuadrilateralUnaugmentedNomenGerundConjugator {
    private final int[] indexList = {2, 4, 6, 8, 10, 12, 14, 16, 18};

    @Inject
    public QuadrilateralUnaugmentedNomenGerundConjugator(GenericNounSuffixContainer genericNounSuffixContainer) {
    }

    public List<QuadrilateralGerund> createGerundList(UnaugmentedQuadrilateralRoot root, GenericNounSuffixContainer genericNounSuffixContainer) {
        var gerundDisplayList = createEmptyList();

        String gerund = genericNounSuffixContainer.getPrefix()+root.getC1() + ArabCharUtil.FATHA + root.getC2() + ArabCharUtil.SKOON + root.getC3()+ArabCharUtil.FATHA+root.getC4();
        for (int value : indexList) {
            //because index in java start from zero
            int suffixNo = value - 1;
            String suffix = genericNounSuffixContainer.get(suffixNo);
            gerundDisplayList.set(suffixNo, new QuadrilateralGerund(gerund + suffix));
        }

        return gerundDisplayList;
    }

    private static List<QuadrilateralGerund> createEmptyList() {
        return IntStream.rangeClosed(1, NOUN_POSSIBLE_STATES)
                .mapToObj(i -> new QuadrilateralGerund(""))
                .collect(Collectors.toCollection(() -> new ArrayList<>(NOUN_POSSIBLE_STATES)));
    }
}
