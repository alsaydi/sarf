package sarf.verb.trilateral.augmented.modifier.substituter;

import sarf.KindOfVerb;
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
        KindOfVerb kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();
        if (formulaNo != 5) return false;

        boolean kovCond = false;
        return kov == 1 || kov == 2 || kov == 6 || kov == 7 || kov == 16 || kov == KindOfVerb.Ajwaf_Wawi || kov == KindOfVerb.Ajwaf_Yaee || kov == KindOfVerb.Naqis_Wawi || kov == KindOfVerb.Naqis_Yaee || kov == KindOfVerb.Lafeef_Maqroon;
    }
}
