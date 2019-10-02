package sarf.noun.quadriliteral.augmented;

import com.google.inject.Inject;
import sarf.SystemConstants;
import sarf.noun.GenericNounSuffixContainer;
import sarf.noun.quadriliteral.augmented.passiveparticiple.NounFormula1;
import sarf.noun.quadriliteral.augmented.passiveparticiple.NounFormula2;
import sarf.noun.quadriliteral.augmented.passiveparticiple.NounFormula3;
import sarf.verb.quadriliteral.augmented.AugmentedQuadrilateralRoot;

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
public class AugmentedQuadrilateralPassiveParticipleConjugator {
    private final GenericNounSuffixContainer genericNounSuffixContainer;

    @Inject
    public AugmentedQuadrilateralPassiveParticipleConjugator(GenericNounSuffixContainer genericNounSuffixContainer) {
        this.genericNounSuffixContainer = genericNounSuffixContainer;
    }

    public List<AugmentedQuadrilateralNoun> createNounList(AugmentedQuadrilateralRoot root, int formulaNo) {
        List<AugmentedQuadrilateralNoun> result = new ArrayList<>();
        for (int i = 0; i < SystemConstants.NOUN_POSSIBLE_STATES; i++) {
            AugmentedQuadrilateralNoun noun = createNoun(root, i, formulaNo);
            result.add(noun);
        }
        return result;
    }

    public List<AugmentedQuadrilateralNoun> createTimeAndPlaceNounList(AugmentedQuadrilateralRoot root, int formulaNo) {
        return createNounList(root, formulaNo, timeAndPlaceIndexesList);
    }

    public List<AugmentedQuadrilateralNoun> createMeemGerundNounList(AugmentedQuadrilateralRoot root, int formulaNo) {
        return createNounList(root, formulaNo, meemGerundIndexesList);
    }

    private AugmentedQuadrilateralNoun createNoun(AugmentedQuadrilateralRoot root, int suffixIndex, int formulaNo) {
        String suffix = genericNounSuffixContainer.get(suffixIndex);
        switch (formulaNo) {
            case 1:
                return new NounFormula1(root, suffix, genericNounSuffixContainer);
            case 2:
                return new NounFormula2(root, suffix, genericNounSuffixContainer);
            case 3:
                return new NounFormula3(root, suffix, genericNounSuffixContainer);
        }
        return null;
    }

    //تستعمل في اسم الزمان والمكان والمصدر الميمي
    private List<AugmentedQuadrilateralNoun> createNounList(AugmentedQuadrilateralRoot root, int formulaNo, List<Integer> indexes) {
        List<AugmentedQuadrilateralNoun> result = IntStream.range(0, SystemConstants.NOUN_POSSIBLE_STATES).mapToObj(i -> new EmptyAugmentedQuadrilateralNoun(root, "0", genericNounSuffixContainer)).collect(Collectors.toList());
        indexes.forEach(index -> {
            AugmentedQuadrilateralNoun noun = createNoun(root, index, formulaNo);
            result.set(index, noun);
        });
        return result;
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

    static final class EmptyAugmentedQuadrilateralNoun extends AugmentedQuadrilateralNoun{
        EmptyAugmentedQuadrilateralNoun(AugmentedQuadrilateralRoot root, String suffix, GenericNounSuffixContainer genericNounSuffixContainer) {
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
