package sarf.noun.trilateral.augmented;

import com.google.inject.Inject;
import sarf.SystemConstants;
import sarf.noun.GenericNounSuffixContainer;
import sarf.noun.trilateral.augmented.passiveparticiple.*;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;

import java.util.ArrayList;
import java.util.List;
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
public class AugmentedTrilateralPassiveParticipleConjugator {
    private final GenericNounSuffixContainer _genericNounSuffixContainer;

    @Inject
    public AugmentedTrilateralPassiveParticipleConjugator(GenericNounSuffixContainer genericNounSuffixContainer) {
        this._genericNounSuffixContainer = genericNounSuffixContainer;
    }

    public List<AugmentedTrilateralNoun> createNounList(AugmentedTrilateralRoot root, int formulaNo, GenericNounSuffixContainer genericNounSuffixContainer) {
        return IntStream.range(0, SystemConstants.NOUN_POSSIBLE_STATES)
                .mapToObj(i -> createNoun(root, i, formulaNo, genericNounSuffixContainer))
                .collect(Collectors.toList());
    }

    public List<AugmentedTrilateralNoun> createTimeAndPlaceNounList(AugmentedTrilateralRoot root, int formulaNo, GenericNounSuffixContainer genericNounSuffixContainer) {
        return createNounList(root, formulaNo, timeAndPlaceIndexesList, genericNounSuffixContainer);
    }

    public List<AugmentedTrilateralNoun> createMeemGerundNounList(AugmentedTrilateralRoot root, int formulaNo) {
        return createNounList(root, formulaNo, meemGerundIndexesList, this._genericNounSuffixContainer);
    }

    //تستعمل في اسم الزمان والمكان والمصدر الميمي
    private List<AugmentedTrilateralNoun> createNounList(AugmentedTrilateralRoot root, int formulaNo, List<Integer> indexes, GenericNounSuffixContainer genericNounSuffixContainer) {
        List<AugmentedTrilateralNoun> result = IntStream.range(0, 18)
                .mapToObj(i -> new EmptyAugmentedTrilateralNoun(root, "0", genericNounSuffixContainer))
                .collect(Collectors.toList());

        indexes.forEach(index -> {
            AugmentedTrilateralNoun noun = createNoun(root, index, formulaNo, genericNounSuffixContainer);
            result.set(index, noun);
        });
        return result;
    }

    private AugmentedTrilateralNoun createNoun(AugmentedTrilateralRoot root, int suffixIndex, int formulaNo, GenericNounSuffixContainer genericNounSuffixContainer) {
        String suffix = genericNounSuffixContainer.get(suffixIndex);
        switch (formulaNo) {
            case 1:
                return new NounFormula1(root, suffix, genericNounSuffixContainer);
            case 2:
                return new NounFormula2(root, suffix, genericNounSuffixContainer);
            case 3:
                return new NounFormula3(root, suffix, genericNounSuffixContainer);
            case 4:
                return new NounFormula4(root, suffix, genericNounSuffixContainer);
            case 5:
                return new NounFormula5(root, suffix, genericNounSuffixContainer);
            case 6:
                return new NounFormula6(root, suffix, genericNounSuffixContainer);
            case 7:
                return new NounFormula7(root, suffix, genericNounSuffixContainer);
            case 8:
                return new NounFormula8(root, suffix, genericNounSuffixContainer);
            case 9:
                return new NounFormula9(root, suffix, genericNounSuffixContainer);
            case 10:
                return new NounFormula10(root, suffix, genericNounSuffixContainer);
            case 11:
                return new NounFormula11(root, suffix, genericNounSuffixContainer);
            case 12:
                return new NounFormula12(root, suffix, genericNounSuffixContainer);
        }
        return new EmptyAugmentedTrilateralNoun(root, suffix, genericNounSuffixContainer);
    }

    private static final List<Integer> timeAndPlaceIndexesList = new ArrayList<>();

    static {
        //حذف المؤنث والجمع
        timeAndPlaceIndexesList.add(0);
        timeAndPlaceIndexesList.add(2);
        timeAndPlaceIndexesList.add(6);
        timeAndPlaceIndexesList.add(8);
        timeAndPlaceIndexesList.add(12);
        timeAndPlaceIndexesList.add(14);
    }

    private static final List<Integer> meemGerundIndexesList = new ArrayList<>();

    static {
        //المذكر المفرد
        meemGerundIndexesList.add(0);
        meemGerundIndexesList.add(6);
        meemGerundIndexesList.add(12);
    }

    final static class EmptyAugmentedTrilateralNoun extends AugmentedTrilateralNoun {
        EmptyAugmentedTrilateralNoun(AugmentedTrilateralRoot root, String suffix, GenericNounSuffixContainer genericNounSuffixContainer) {
            super(root, suffix, genericNounSuffixContainer);
        }

        @Override
        public String form() {
            return "";
        }

        @Override
        public String toString(){
            return form();
        }
    }
}
