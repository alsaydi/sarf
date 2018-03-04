package sarf.verb.trilateral.augmented.modifier.geminator;

import sarf.verb.trilateral.augmented.ConjugationResult;
import sarf.verb.trilateral.augmented.*;
import sarf.verb.trilateral.augmented.modifier.IAugmentedTrilateralModifier;
import sarf.*;
import java.util.*;
import sarf.verb.trilateral.Substitution.InfixSubstitution;
import sarf.verb.trilateral.Substitution.SubstitutionsApplier;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: «·–Ì Ì‰ ÂÌ »«· «¡  </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class TEndedGeminator extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public TEndedGeminator() {
        substitutions.add(new InfixSubstitution(" ˙ ", " ¯")); // EX: (√‰« ”Ûﬂ¯Û ¯ı ° √‰ Û ”Ûﬂ¯Û ¯Û ° √‰ ˆ ”Ûﬂ¯Û ¯ˆ )    }
    }

    public List getSubstitutions() {
        return substitutions;
    }


    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();
        if (conjugationResult.getRoot().getC3() != ' ') return false;

        switch (formulaNo) {
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 7:
        case 8:
        case 9:
        case 10:
        case 11:
            switch (kov) {
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 11:
            case 17:
            case 20:
                return true;
            }
        }
        return false;
    }

    public void apply(String tense, boolean active, ConjugationResult conjResult) {
        if (!tense.equals(SystemConstants.PAST_TENSE)) {
            return;
        }
        apply(conjResult.getFinalResult(), conjResult.getRoot());
    }
}
