package sarf.noun.trilateral.augmented.modifier;

import sarf.KindOfVerb;
import sarf.noun.*;
import sarf.verb.trilateral.augmented.modifier.*;
import sarf.verb.trilateral.augmented.*;

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
public abstract class AbstractEinMahmouz extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        return kov == 6 || kov == KindOfVerb.Mithal_Wawi_Mahmouz_Ain || kov == KindOfVerb.Mithal_Yaee_Mahmouz_Ain || kov == KindOfVerb.Naqis_Wawi_Mahmouz_Ain || kov == KindOfVerb.Naqis_Yaee_Mahmouz_Ain || kov == KindOfVerb.Lafeef_Mafrooq_Mahmouz_Ain;
    }
}
