package sarf.gerund.quadrilateral.augmented.nomen;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import sarf.gerund.quadrilateral.augmented.nomen.pattern.GerundPattern1;
import sarf.gerund.quadrilateral.augmented.nomen.pattern.GerundPattern2;
import sarf.gerund.quadrilateral.augmented.nomen.pattern.GerundPattern3;
import sarf.noun.GenericNounSuffixContainer;
import sarf.verb.quadriliteral.augmented.*;

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

@Singleton
public class QuadrilateralAugmentedNomenGerundConjugator {
    /* Nomen vicis اسم المرَّة */
    private final int[] indexArray = {2, 4, 6, 8, 10, 12, 14, 16, 18};

    @Inject
    public QuadrilateralAugmentedNomenGerundConjugator() {
    }

    public List<QuadrilateralAugmentedNomenGerund> createGerundList(AugmentedQuadrilateralRoot root, int formulaNo, GenericNounSuffixContainer genericNounSuffixContainer) {
        var gerundDisplayList = createEmptyList();

        for (int value : indexArray) {
            //because index in java start from zero
            int suffixNo = value - 1;
            QuadrilateralAugmentedNomenGerund gerund = createQuadrilateralAugmentedNomenGerund(root, suffixNo + "", formulaNo, genericNounSuffixContainer);
            gerundDisplayList.set(suffixNo, gerund);
        }
        return gerundDisplayList;
    }

    private QuadrilateralAugmentedNomenGerund createQuadrilateralAugmentedNomenGerund(AugmentedQuadrilateralRoot root, String suffixNo, int formula, GenericNounSuffixContainer genericNounSuffixContainer) {
        switch (formula) {
            case 1:
                return new GerundPattern1(root, suffixNo, genericNounSuffixContainer);
            case 2:
                return new GerundPattern2(root, suffixNo, genericNounSuffixContainer);
            case 3:
                return new GerundPattern3(root, suffixNo, genericNounSuffixContainer);
        }
        return new EmptyQuadrilateralAugmentedNomenGerund();
    }

    private static List<QuadrilateralAugmentedNomenGerund> createEmptyList() {
        return IntStream.rangeClosed(1, NOUN_POSSIBLE_STATES)
                .mapToObj(i -> new EmptyQuadrilateralAugmentedNomenGerund())
                .collect(Collectors.toCollection(() -> new ArrayList<>(NOUN_POSSIBLE_STATES)));
    }

    private static final class EmptyQuadrilateralAugmentedNomenGerund extends QuadrilateralAugmentedNomenGerund {

        @Override
        public String form() {
            return "";
        }

        @Override
        public String getPattern() {
            return "";
        }
    }
}
