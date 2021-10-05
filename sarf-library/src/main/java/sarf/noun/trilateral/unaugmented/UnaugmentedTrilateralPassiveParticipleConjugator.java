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

    private static UnaugmentedTrilateralPassiveParticiple createNoun(UnaugmentedTrilateralRoot root, int suffixIndex, GenericNounSuffixContainer genericNounSuffixContainer) {
        String suffix = genericNounSuffixContainer.get(suffixIndex);
        return new UnaugmentedTrilateralPassiveParticiple(root, suffix, genericNounSuffixContainer);
    }

    /**
     * @deprecated Use the version that takes an instance of GenericNounSuffixContainer
     *
     */
    public List<UnaugmentedTrilateralPassiveParticiple> createNounList(UnaugmentedTrilateralRoot root, String formulaName) {
        return this.createNounList(root, formulaName, this.genericNounSuffixContainer);
    }
    public List<UnaugmentedTrilateralPassiveParticiple> createNounList(UnaugmentedTrilateralRoot root, String formulaName, GenericNounSuffixContainer genericNounSuffixContainer) {
        List<UnaugmentedTrilateralPassiveParticiple> result = new ArrayList<>(SystemConstants.NOUN_POSSIBLE_STATES);
        for (int i = 0; i< SystemConstants.NOUN_POSSIBLE_STATES; i++) {
            result.add(createNoun(root, i, genericNounSuffixContainer));
        }
        return result;
    }

    public List<String> getAppliedFormulaList(UnaugmentedTrilateralRoot root) {
        return Collections.emptyList();
    }
}
