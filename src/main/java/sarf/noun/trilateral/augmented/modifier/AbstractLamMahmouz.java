package sarf.noun.trilateral.augmented.modifier;

import sarf.ConjugationResult;
import sarf.KindOfVerb;
import sarf.noun.*;
import sarf.verb.trilateral.augmented.modifier.*;

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
public abstract class AbstractLamMahmouz extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        return kov == KindOfVerb.Mahmouz_Faa_Mahmouz_Laam || kov == KindOfVerb.Mahmouz_Laam || kov == KindOfVerb.Mithal_Wawi_Mahmouz_Laam || kov == KindOfVerb.Ajwaf_Wawi_Mahmouz_Laam || kov == KindOfVerb.Ajwaf_Yaee_Mahmouz_Laam;
    }
}
