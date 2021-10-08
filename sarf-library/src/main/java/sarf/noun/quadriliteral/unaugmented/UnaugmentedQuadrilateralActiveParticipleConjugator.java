package sarf.noun.quadriliteral.unaugmented;

import com.google.inject.Inject;
import sarf.SystemConstants;
import sarf.verb.quadriliteral.unaugmented.*;
import sarf.noun.*;
import java.util.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: إنشاء اسم الفاعل الرباعي المجرد    </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class UnaugmentedQuadrilateralActiveParticipleConjugator {
    @Inject
    public UnaugmentedQuadrilateralActiveParticipleConjugator() {
    }

    private UnaugmentedQuadrilateralActiveParticiple createNoun(UnaugmentedQuadrilateralRoot root, int suffixIndex, GenericNounSuffixContainer genericNounSuffixContainer) {
        String suffix = genericNounSuffixContainer.get(suffixIndex);
        return new UnaugmentedQuadrilateralActiveParticiple(root, suffix, genericNounSuffixContainer);
    }

    public List<UnaugmentedQuadrilateralActiveParticiple> createNounList(UnaugmentedQuadrilateralRoot root, GenericNounSuffixContainer genericNounSuffixContainer) {
        List<UnaugmentedQuadrilateralActiveParticiple> result = new ArrayList<>(SystemConstants.NOUN_POSSIBLE_STATES);
        for (int i=0; i<SystemConstants.NOUN_POSSIBLE_STATES; i++) {
            result.add(createNoun(root, i, genericNounSuffixContainer));
        }
        return result;
    }
}
