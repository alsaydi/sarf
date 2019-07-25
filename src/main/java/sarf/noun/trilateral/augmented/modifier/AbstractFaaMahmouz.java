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
public abstract class AbstractFaaMahmouz extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();

        return kov == 3 || kov == 4 || kov == 5 || kov == KindOfVerb.Ajwaf_Wawi_Mahmouz_Faa || kov == KindOfVerb.Ajwaf_Yaee_Mahmouz_Faa || kov == KindOfVerb.Naqis_Wawi_Mahmouz_Faa || kov == KindOfVerb.Naqis_Yaee_Mahmouz_Faa || kov == KindOfVerb.Lafeef_Maqroon_Mahmouz_Faa;
    }
}
