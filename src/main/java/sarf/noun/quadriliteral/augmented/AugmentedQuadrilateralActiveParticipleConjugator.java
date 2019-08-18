package sarf.noun.quadriliteral.augmented;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.google.inject.Inject;
import sarf.SystemConstants;
import sarf.noun.quadriliteral.augmented.activeparticiple.NounFormula1;
import sarf.noun.quadriliteral.augmented.activeparticiple.NounFormula2;
import sarf.noun.quadriliteral.augmented.activeparticiple.NounFormula3;
import sarf.verb.quadriliteral.augmented.AugmentedQuadrilateralRoot;

import sarf.noun.GenericNounSuffixContainer;

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
public class AugmentedQuadrilateralActiveParticipleConjugator {
    private final GenericNounSuffixContainer genericNounSuffixContainer;

    @Inject
    public AugmentedQuadrilateralActiveParticipleConjugator(GenericNounSuffixContainer genericNounSuffixContainer) {
        this.genericNounSuffixContainer = genericNounSuffixContainer;
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

    public List<AugmentedQuadrilateralNoun> createNounList(AugmentedQuadrilateralRoot root, int formulaNo) {
        return IntStream.range(0, SystemConstants.NOUN_POSSIBLE_STATES)
                .mapToObj(i -> createNoun(root, i, formulaNo))
                .collect(Collectors.toList());
    }
}
