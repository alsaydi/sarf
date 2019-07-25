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

        return kov == 1 || kov == 2 || kov == 6 || kov == KindOfVerb.Mahmouz_Laam || kov == KindOfVerb.Ajwaf_Wawi_Mahmouz_Laam || kov == KindOfVerb.Ajwaf_Wawi || kov == KindOfVerb.Ajwaf_Yaee || kov == KindOfVerb.Naqis_Wawi || kov == KindOfVerb.Naqis_Yaee || kov == KindOfVerb.Lafeef_Maqroon;
    }
}
