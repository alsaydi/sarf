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
        return kov == 3 || kov == 4 || kov == 5 || kov == 15 || kov == 18 || kov == 21 || kov == 24 || kov == KindOfVerb.Lafeef_Maqroon_Mahmouz_Faa;
    }
}
