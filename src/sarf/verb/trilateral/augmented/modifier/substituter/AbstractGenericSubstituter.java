package sarf.verb.trilateral.augmented.modifier.substituter;

import sarf.verb.trilateral.augmented.*;
import sarf.verb.trilateral.augmented.modifier.*;
import sarf.verb.trilateral.Substitution.SubstitutionsApplier;

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
public abstract class AbstractGenericSubstituter extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    public AbstractGenericSubstituter() {
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();
        if (formulaNo != 5) return false;

        boolean kovCond = false;
        switch (kov) {
        case 1:
        case 2:
        case 6:
        case 7:
        case 16:
        case 17:
        case 20:
        case 23:
        case 26:
        case 28:
            return true;
        }

        return false;
    }
}
