package sarf.noun.quadriliteral.unaugmented;

import com.google.inject.Inject;
import sarf.SystemConstants;
import sarf.noun.GenericNounSuffixContainer;
import sarf.verb.quadriliteral.unaugmented.UnaugmentedQuadrilateralRoot;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: إنشاء اسم المفعول الرباعي المجرد    </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class UnaugmentedQuadrilateralPassiveParticipleConjugator {
    private final GenericNounSuffixContainer genericNounSuffixContainer;

    @Inject
    public UnaugmentedQuadrilateralPassiveParticipleConjugator(GenericNounSuffixContainer genericNounSuffixContainer) {
        this.genericNounSuffixContainer = genericNounSuffixContainer;
    }

    public List<UnaugmentedQuadrilateralPassiveParticiple> createNounList(UnaugmentedQuadrilateralRoot root) {
        return IntStream.range(0, SystemConstants.NOUN_POSSIBLE_STATES)
                .mapToObj(i -> createNoun(root, i))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List createMeemGerundNounList(UnaugmentedQuadrilateralRoot root) {
        return createNounList(root, meemGerundIndexesList);
    }

    public List createTimeAndPlaceNounList(UnaugmentedQuadrilateralRoot root) {
        return createNounList(root, timeAndPlaceIndexList);
    }

    private static final List<Integer> timeAndPlaceIndexList = new ArrayList<>();

    static {
        //حذف المؤنث والجمع
        timeAndPlaceIndexList.add(0);
        timeAndPlaceIndexList.add(2);
        timeAndPlaceIndexList.add(6);
        timeAndPlaceIndexList.add(8);
        timeAndPlaceIndexList.add(12);
        timeAndPlaceIndexList.add(14);
    }

    private static final List<Integer> meemGerundIndexesList = new ArrayList<>();

    static {
        //المذكر المفرد
        meemGerundIndexesList.add(0);
        meemGerundIndexesList.add(6);
        meemGerundIndexesList.add(12);
    }

    private UnaugmentedQuadrilateralPassiveParticiple createNoun(UnaugmentedQuadrilateralRoot root, int suffixIndex) {
        String suffix = genericNounSuffixContainer.get(suffixIndex);
        return new UnaugmentedQuadrilateralPassiveParticiple(root, suffix, genericNounSuffixContainer);
    }

    //تستعمل في اسم الزمان والمكان والمصدر الميمي
    private List<UnaugmentedQuadrilateralPassiveParticiple> createNounList(UnaugmentedQuadrilateralRoot root, List<Integer> indexes) {
        List<UnaugmentedQuadrilateralPassiveParticiple> result = IntStream.range(0, SystemConstants.NOUN_POSSIBLE_STATES)
                .mapToObj(i -> new UnaugmentedQuadrilateralPassiveParticiple())
                .collect(Collectors.toList());

        indexes.forEach(index -> {
            var noun = createNoun(root, index);
            result.set(index, noun);
        });
        return result;
    }
}
