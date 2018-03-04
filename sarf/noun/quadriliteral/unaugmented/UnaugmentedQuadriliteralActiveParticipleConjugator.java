package sarf.noun.quadriliteral.unaugmented;

import sarf.noun.quadriliteral.*;
import sarf.verb.quadriliteral.unaugmented.*;
import sarf.noun.*;
import java.util.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: ≈‰‘«¡ «”„ «·›«⁄· «·—»«⁄Ì «·„Ã—œ    </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class UnaugmentedQuadriliteralActiveParticipleConjugator {
    private UnaugmentedQuadriliteralActiveParticipleConjugator() {
    }

    private static UnaugmentedQuadriliteralActiveParticipleConjugator instance = new UnaugmentedQuadriliteralActiveParticipleConjugator();

    public static UnaugmentedQuadriliteralActiveParticipleConjugator getInstance() {
        return instance;
    }

    public UnaugmentedQuadriliteralActiveParticiple createNoun(UnaugmentedQuadriliteralRoot root, int suffixIndex) {
        String suffix = GenericNounSuffixContainer.getInstance().get(suffixIndex);
        return new UnaugmentedQuadriliteralActiveParticiple(root, suffix);
    }

    public List createNounList(UnaugmentedQuadriliteralRoot root) {
        List result = new ArrayList(18);
        for (int i=0; i<18; i++)
            result.add(createNoun(root, i));
        return result;
    }

}
