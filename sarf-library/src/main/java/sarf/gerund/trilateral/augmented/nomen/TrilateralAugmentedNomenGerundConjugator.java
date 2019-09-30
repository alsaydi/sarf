package sarf.gerund.trilateral.augmented.nomen;

import com.google.inject.Inject;
import sarf.SystemConstants;
import sarf.gerund.trilateral.augmented.nomen.pattern.GerundPattern1;
import sarf.gerund.trilateral.augmented.nomen.pattern.GerundPattern10;
import sarf.gerund.trilateral.augmented.nomen.pattern.GerundPattern11;
import sarf.gerund.trilateral.augmented.nomen.pattern.GerundPattern12;
import sarf.gerund.trilateral.augmented.nomen.pattern.GerundPattern2;
import sarf.gerund.trilateral.augmented.nomen.pattern.GerundPattern3;
import sarf.gerund.trilateral.augmented.nomen.pattern.GerundPattern4;
import sarf.gerund.trilateral.augmented.nomen.pattern.GerundPattern5;
import sarf.gerund.trilateral.augmented.nomen.pattern.GerundPattern6;
import sarf.gerund.trilateral.augmented.nomen.pattern.GerundPattern7;
import sarf.gerund.trilateral.augmented.nomen.pattern.GerundPattern8;
import sarf.gerund.trilateral.augmented.nomen.pattern.GerundPattern9;
import sarf.gerund.trilateral.augmented.nomen.pattern.GerundPatternEmpty;
import sarf.noun.GenericNounSuffixContainer;
import sarf.verb.trilateral.augmented.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
public class TrilateralAugmentedNomenGerundConjugator {
    private final int[] indexArray = {2, 4, 6, 8, 10, 12, 14, 16, 18};
    private final GenericNounSuffixContainer genericNounSuffixContainer;

    @Inject
    public TrilateralAugmentedNomenGerundConjugator(GenericNounSuffixContainer genericNounSuffixContainer) {
        this.genericNounSuffixContainer = genericNounSuffixContainer;
    }

    public List<TrilateralAugmentedNomenGerund> createGerundList(AugmentedTrilateralRoot root, int formulaNo) {
        var gerundDisplayList = createEmptyList();

        for (int value : indexArray) {
            //because index in java start from zero
            int suffixNo = value - 1;
            TrilateralAugmentedNomenGerund gerund = createTrilateralAugmentedNomenGerund(root, formulaNo, suffixNo);
            gerundDisplayList.set(suffixNo, gerund);
        }
        return gerundDisplayList;
    }

    private TrilateralAugmentedNomenGerund createTrilateralAugmentedNomenGerund(AugmentedTrilateralRoot root, int formulaNo, int suffixIndex) {
        switch (formulaNo) {
            case 1:
                return new GerundPattern1(root, "" + suffixIndex, genericNounSuffixContainer);
            case 2:
                return new GerundPattern2(root, "" + suffixIndex, genericNounSuffixContainer);
            case 3:
                return new GerundPattern3(root, "" + suffixIndex, genericNounSuffixContainer);
            case 4:
                return new GerundPattern4(root, "" + suffixIndex, genericNounSuffixContainer);
            case 5:
                return new GerundPattern5(root, "" + suffixIndex, genericNounSuffixContainer);
            case 6:
                return new GerundPattern6(root, "" + suffixIndex, genericNounSuffixContainer);
            case 7:
                return new GerundPattern7(root, "" + suffixIndex, genericNounSuffixContainer);
            case 8:
                return new GerundPattern8(root, "" + suffixIndex, genericNounSuffixContainer);
            case 9:
                return new GerundPattern9(root, "" + suffixIndex, genericNounSuffixContainer);
            case 10:
                return new GerundPattern10(root, "" + suffixIndex, genericNounSuffixContainer);
            case 11:
                return new GerundPattern11(root, "" + suffixIndex, genericNounSuffixContainer);
            case 12:
                return new GerundPattern12(root, "" + suffixIndex, genericNounSuffixContainer);
        }
        return new GerundPatternEmpty(new AugmentedTrilateralRoot(), "0", genericNounSuffixContainer);
    }

    private List<TrilateralAugmentedNomenGerund> createEmptyList() {
        return IntStream.rangeClosed(1, SystemConstants.NOUN_POSSIBLE_STATES)
                .mapToObj(i -> new GerundPatternEmpty(new AugmentedTrilateralRoot(), "0", genericNounSuffixContainer))
                .collect(Collectors.toCollection(() -> new ArrayList<>(SystemConstants.NOUN_POSSIBLE_STATES)));
    }
}
