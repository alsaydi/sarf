package sarf.gerund.quadrilateral.augmented;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.google.inject.Inject;
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
public class QuadrilateralAugmentedGerundConjugator {
    private final int[] indexArray = {1, 3, 6, 7, 9, 12, 13, 15, NOUN_POSSIBLE_STATES};
    private final GenericNounSuffixContainer genericNounSuffixContainer;

    @Inject
    public QuadrilateralAugmentedGerundConjugator(GenericNounSuffixContainer genericNounSuffixContainer){
        this.genericNounSuffixContainer = genericNounSuffixContainer;
    }

    public List<QuadrilateralAugmentedGerund> createGerundList(AugmentedQuadrilateralRoot root, int formulaNo) {
        String gerundPatternClassName = getClass().getPackage().getName() + ".pattern." + "GerundPattern" + formulaNo;
        List<QuadrilateralAugmentedGerund> gerundDisplayList = createEmptyList();

        for (int value : indexArray) {
            //because index in java start from zero
            int suffixNo = value - 1;
            Object[] parameters = {root, suffixNo + "", genericNounSuffixContainer};
            try {
                var gerund = (QuadrilateralAugmentedGerund) Class.forName(gerundPatternClassName)
                        .getConstructor(root.getClass(), "".getClass(), GenericNounSuffixContainer.class)
                        .newInstance(parameters);
                gerundDisplayList.set(suffixNo, gerund);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return gerundDisplayList;
    }

    private List<QuadrilateralAugmentedGerund> createEmptyList() {
        return IntStream.rangeClosed(1, NOUN_POSSIBLE_STATES)
                .<QuadrilateralAugmentedGerund>mapToObj(i -> new EmptyQuadrilateralAugmentedGerund(new AugmentedQuadrilateralRoot(), "0", genericNounSuffixContainer))
                .collect(Collectors.toCollection(() -> new ArrayList<>(NOUN_POSSIBLE_STATES)));
    }

    private static class EmptyQuadrilateralAugmentedGerund extends QuadrilateralAugmentedGerund {
        EmptyQuadrilateralAugmentedGerund(AugmentedQuadrilateralRoot root, String suffixNo, GenericNounSuffixContainer genericNounSuffixContainer) {
            super(root, suffixNo, genericNounSuffixContainer);
        }

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
