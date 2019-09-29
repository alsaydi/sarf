package sarf.noun.trilateral.unaugmented;

import com.google.inject.Inject;
import sarf.SystemConstants;
import sarf.verb.trilateral.unaugmented.*;
import sarf.noun.*;
import java.util.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: إنشاء اسم الفاعل الثلاثي المجرد    </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class UnaugmentedTrilateralActiveParticipleConjugator implements IUnaugmentedTrilateralNounConjugator{
    private final GenericNounSuffixContainer genericNounSuffixContainer;

    @Inject
    public UnaugmentedTrilateralActiveParticipleConjugator(GenericNounSuffixContainer genericNounSuffixContainer) {
        this.genericNounSuffixContainer = genericNounSuffixContainer;
    }

    public UnaugmentedTrilateralActiveParticiple createNoun(UnaugmentedTrilateralRoot root, int suffixIndex) {
        String suffix = genericNounSuffixContainer.get(suffixIndex);
        return new UnaugmentedTrilateralActiveParticiple(root, suffix, genericNounSuffixContainer);
    }

    public List<UnaugmentedTrilateralActiveParticiple> createNounList(UnaugmentedTrilateralRoot root, String formulaName) {
        List<UnaugmentedTrilateralActiveParticiple> result = new ArrayList<>(SystemConstants.NOUN_POSSIBLE_STATES);
        for (int i=0; i<SystemConstants.NOUN_POSSIBLE_STATES; i++) {
            result.add(createNoun(root, i));
        }
        return result;
    }

    public List<String> getAppliedFormulaList(UnaugmentedTrilateralRoot root) {
        return Collections.emptyList();
    }
}
