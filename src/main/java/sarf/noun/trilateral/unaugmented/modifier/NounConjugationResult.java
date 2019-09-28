package sarf.noun.trilateral.unaugmented.modifier;

import java.util.*;

import sarf.KindOfVerb;
import sarf.verb.trilateral.unaugmented.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: يمثل نتيجة التصريف مع الجذر ونوع الجذر      </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class NounConjugationResult extends sarf.verb.trilateral.augmented.ConjugationResult{
    private final String nounFormula;

    public NounConjugationResult(KindOfVerb kov, UnaugmentedTrilateralRoot root, List originalResult, String nounFormula) {
        super(kov, 0, root, originalResult);
        this.nounFormula = nounFormula;
    }

    public String getNounFormula() {
        return nounFormula;
    }
}
