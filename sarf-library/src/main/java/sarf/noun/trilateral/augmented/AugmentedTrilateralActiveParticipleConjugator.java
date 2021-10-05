package sarf.noun.trilateral.augmented;

import com.google.inject.Inject;
import sarf.SystemConstants;
import sarf.noun.GenericNounSuffixContainer;
import sarf.noun.trilateral.augmented.activeparticiple.*;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;

import java.util.*;

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
public class AugmentedTrilateralActiveParticipleConjugator {

    @Inject
    public AugmentedTrilateralActiveParticipleConjugator() {
    }
    
    private AugmentedTrilateralNoun createNoun(AugmentedTrilateralRoot root, int suffixIndex, int formulaNo, GenericNounSuffixContainer genericNounSuffixContainer) {
        String suffix = genericNounSuffixContainer.get(suffixIndex);
        switch (formulaNo){
            case 1: return new NounFormula1(root, suffix, genericNounSuffixContainer);
            case 2: return new NounFormula2(root, suffix, genericNounSuffixContainer);
            case 3: return new NounFormula3(root, suffix, genericNounSuffixContainer);
            case 4: return new NounFormula4(root, suffix, genericNounSuffixContainer);
            case 5: return new NounFormula5(root, suffix, genericNounSuffixContainer);
            case 6: return new NounFormula6(root, suffix, genericNounSuffixContainer);
            case 7: return new NounFormula7(root, suffix, genericNounSuffixContainer);
            case 8: return new NounFormula8(root, suffix, genericNounSuffixContainer);
            case 9: return new NounFormula9(root, suffix, genericNounSuffixContainer);
            case 10: return new NounFormula10(root, suffix, genericNounSuffixContainer);
            case 11: return new NounFormula11(root, suffix, genericNounSuffixContainer);
            case 12: return new NounFormula12(root, suffix, genericNounSuffixContainer);
        }
        return  null;
    }

    public List<AugmentedTrilateralNoun> createNounList(AugmentedTrilateralRoot root, int formulaNo, GenericNounSuffixContainer genericNounSuffixContainer) {
        List<AugmentedTrilateralNoun> result = new ArrayList<>();
        for (int i = 0; i < SystemConstants.NOUN_POSSIBLE_STATES; i++) {
            AugmentedTrilateralNoun noun = createNoun(root, i, formulaNo, genericNounSuffixContainer);
            result.add(noun);
        }
        return result;
    }
}
