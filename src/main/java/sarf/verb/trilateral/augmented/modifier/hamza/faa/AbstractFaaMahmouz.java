package sarf.verb.trilateral.augmented.modifier.hamza.faa;

import sarf.KindOfVerb;
import sarf.verb.trilateral.augmented.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.*;

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
public abstract class AbstractFaaMahmouz extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    public AbstractFaaMahmouz() {
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        if (kov == KindOfVerb.Mahmouz_Faa_Mudaaf) {
            switch (formulaNo) {
                case 2:
                case 3:
                case 5:
                case 7:
                case 8:
                case 9:
                    return true;
            }
            return formulaNo == 5;
        } else if (kov == KindOfVerb.Mahmouz_Faa_Mahmouz_Laam) {
            return formulaNo == 5;
        } else if (kov == KindOfVerb.Mahmouz_Faa) {
            switch (formulaNo) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                case 9:
                    return true;
            }


        } else if (kov == KindOfVerb.Ajwaf_Wawi_Mahmouz_Faa) {
            switch (formulaNo) {
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                case 9:
                    return true;
            }


            return formulaNo == 1;


        } else if (kov == KindOfVerb.Ajwaf_Yaee_Mahmouz_Faa || kov == KindOfVerb.Lafeef_Maqroon_Mahmouz_Faa) {
            switch (formulaNo) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 8:
                case 9:
                    return true;
            }


            return formulaNo == 7;
        } else if (kov == KindOfVerb.Naqis_Wawi_Mahmouz_Faa || kov == KindOfVerb.Naqis_Yaee_Mahmouz_Faa) {
            switch (formulaNo) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 8:
                case 9:
                    return true;
            }
        }
        return false;
    }

}
