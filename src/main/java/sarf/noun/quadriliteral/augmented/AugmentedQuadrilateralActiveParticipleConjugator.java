package sarf.noun.quadriliteral.augmented;

import java.util.*;

import com.google.inject.Inject;
import sarf.SystemConstants;
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
        String formulaClassName = getClass().getPackage().getName()+".activeparticiple."+"NounFormula"+formulaNo;
        Object [] parameters = {root, suffix, genericNounSuffixContainer};

        try {
            return (AugmentedQuadrilateralNoun) Class.forName(formulaClassName)
                    .getConstructor(root.getClass(), suffix.getClass(), genericNounSuffixContainer.getClass()).newInstance(parameters);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<AugmentedQuadrilateralNoun> createNounList(AugmentedQuadrilateralRoot root, int formulaNo) {
        List<AugmentedQuadrilateralNoun> result = new ArrayList<>();
        for (int i = 0; i < SystemConstants.NOUN_POSSIBLE_STATES; i++) {
            AugmentedQuadrilateralNoun noun = createNoun(root, i, formulaNo);
            result.add(noun);
        }
        return result;
    }
}
