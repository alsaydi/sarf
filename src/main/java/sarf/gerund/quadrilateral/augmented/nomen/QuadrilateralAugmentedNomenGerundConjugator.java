package sarf.gerund.quadrilateral.augmented.nomen;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
public class QuadrilateralAugmentedNomenGerundConjugator {
    /* Nomen vicis اسم المرَّة */
    private static final QuadrilateralAugmentedNomenGerundConjugator instance = new QuadrilateralAugmentedNomenGerundConjugator();
    private final int[] indexArray = {2, 4, 6, 8, 10, 12, 14, 16, 18};

    public static QuadrilateralAugmentedNomenGerundConjugator getInstance() {
        return instance;
    }

    public List<QuadrilateralAugmentedNomenGerund> createGerundList(AugmentedQuadrilateralRoot root, int formulaNo) {
        var gerundPatternClassName = getClass().getPackage().getName() + ".pattern." + "GerundPattern" + formulaNo;
        var gerundDisplayList = createEmptyList();

        for (int value : indexArray) {
            //because index in java start from zero
            int suffixNo = value - 1;
            Object[] parameters = {root, suffixNo + ""};
            try {
                QuadrilateralAugmentedNomenGerund gerund = (QuadrilateralAugmentedNomenGerund) Class.forName(gerundPatternClassName).getConstructors()[0].newInstance(parameters);
                gerundDisplayList.set(suffixNo, gerund);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return gerundDisplayList;
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
