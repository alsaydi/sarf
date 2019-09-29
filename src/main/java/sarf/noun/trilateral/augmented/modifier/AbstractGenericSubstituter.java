package sarf.noun.trilateral.augmented.modifier;

import sarf.KindOfVerb;
import sarf.ConjugationResult;
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
public abstract class AbstractGenericSubstituter extends TrilateralNounSubstitutionApplier{
    protected AbstractGenericSubstituter() {
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();
        if (formulaNo != 5) {
            return false;
        }

        return kov == KindOfVerb.Salim || kov == KindOfVerb.Mudaaf || kov == KindOfVerb.Mahmouz_Ain || kov == KindOfVerb.Mahmouz_Laam || kov == KindOfVerb.Ajwaf_Wawi_Mahmouz_Laam || kov == KindOfVerb.Ajwaf_Wawi || kov == KindOfVerb.Ajwaf_Yaee || kov == KindOfVerb.Naqis_Wawi || kov == KindOfVerb.Naqis_Yaee || kov == KindOfVerb.Lafeef_Maqroon;
    }
}
