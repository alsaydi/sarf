package sarf.verb.trilateral.augmented.modifier.hamza.lam;

import sarf.KindOfVerb;
import sarf.verb.trilateral.augmented.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: الصف الأب المشترك لمهموز اللام حسب شرط الفحص المشترك للمضارع والأمر والماضي           </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public abstract class AbstractLamMahmouz extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    public AbstractLamMahmouz() {
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        if (kov == 4) {
            return formulaNo == 5;
        } else if (kov == 7) {
            switch (formulaNo) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                    return true;
            }

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


            switch (formulaNo) {
                case 1:
                case 2:
                case 3:
                case 7:
                case 8:
                case 9:
                    return true;
            }
        } else if (kov == 10 || kov == 16) {
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


            switch (formulaNo) {
                case 1:
                case 2:
                case 3:
                case 7:
                case 8:
                case 9:
                    return true;
            }
        } else if (kov == KindOfVerb.Ajwaf_Yaee_Mahmouz_Laam) {
            switch (formulaNo) {
                case 1:
                case 2:
                case 3:
                case 7:
                case 8:
                case 9:
                    return true;
            }
        }
        return false;
    }

}
