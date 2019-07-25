package sarf.noun.trilateral.augmented.modifier;

import sarf.KindOfVerb;
import sarf.verb.trilateral.augmented.modifier.*;
import sarf.verb.trilateral.augmented.ConjugationResult;
import sarf.verb.trilateral.Substitution.*;
import sarf.noun.*;

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
public abstract class AbstractGenericSubstituter extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {
    public AbstractGenericSubstituter() {
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();
        if (formulaNo != 5) {
            return false;
        }

        return kov == 1 || kov == 2 || kov == 6 || kov == 7 || kov == 16 || kov == 17 || kov == 20 || kov == 23 || kov == KindOfVerb.Naqis_Yaee || kov == KindOfVerb.Lafeef_Maqroon;
    }
}
