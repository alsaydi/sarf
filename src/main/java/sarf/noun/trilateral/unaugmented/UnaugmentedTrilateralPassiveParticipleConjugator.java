package sarf.noun.trilateral.unaugmented;

import com.google.inject.Inject;
import sarf.SystemConstants;
import sarf.verb.trilateral.unaugmented.*;
import sarf.noun.*;
import java.util.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: إنشاء اسم المفعول الثلاثي المجرد    </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class UnaugmentedTrilateralPassiveParticipleConjugator implements IUnaugmentedTrilateralNounConjugator{
    private final GenericNounSuffixContainer genericNounSuffixContainer;

    @Inject
    public UnaugmentedTrilateralPassiveParticipleConjugator(GenericNounSuffixContainer genericNounSuffixContainer) {
        this.genericNounSuffixContainer = genericNounSuffixContainer;
    }

    private UnaugmentedTrilateralPassiveParticiple createNoun(UnaugmentedTrilateralRoot root, int suffixIndex) {
        String suffix = genericNounSuffixContainer.get(suffixIndex);
        return new UnaugmentedTrilateralPassiveParticiple(root, suffix, genericNounSuffixContainer);
    }

    public List<UnaugmentedTrilateralPassiveParticiple> createNounList(UnaugmentedTrilateralRoot root, String formulaName) {
        List<UnaugmentedTrilateralPassiveParticiple> result = new ArrayList<>(SystemConstants.NOUN_POSSIBLE_STATES);
        for (int i = 0; i< SystemConstants.NOUN_POSSIBLE_STATES; i++) {
            result.add(createNoun(root, i));
        }
        return result;
    }

    //TODO: why null?
    public List getAppliedFormulaList(UnaugmentedTrilateralRoot root) {
        return null;
    }
}
