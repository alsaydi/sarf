package sarf.verb.trilateral.unaugmented.modifier.hamza;

import sarf.KindOfVerb;
import sarf.verb.trilateral.unaugmented.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.unaugmented.modifier.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: الصف الأب المشترك لمهموز الفاء حسب شرط الفحص المشترك للمضارع والأمر والماضي           </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public abstract class AbstractFaaMahmouz extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {
    public AbstractFaaMahmouz() {
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        return kov == KindOfVerb.Mahmouz_Faa_Mudaaf || kov == KindOfVerb.Mahmouz_Faa_Mahmouz_Laam || kov == KindOfVerb.Mahmouz_Faa || kov == KindOfVerb.Ajwaf_Wawi_Mahmouz_Faa || kov == KindOfVerb.Ajwaf_Yaee_Mahmouz_Faa || kov == KindOfVerb.Naqis_Wawi_Mahmouz_Faa || kov == KindOfVerb.Naqis_Yaee_Mahmouz_Faa || kov == KindOfVerb.Lafeef_Maqroon_Mahmouz_Faa;
    }
}
