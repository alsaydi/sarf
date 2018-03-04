package sarf.verb.trilateral.augmented.modifier.hamza.faa;

import sarf.verb.trilateral.augmented.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: «·’› «·√» «·„‘ —ﬂ ·„Â„Ê“ «·›«¡ Õ”» ‘—ÿ «·›Õ’ «·„‘ —ﬂ ··„÷«—⁄ Ê«·√„— Ê«·„«÷Ì           </p>
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

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        switch (kov) {
        case 3:
            switch (formulaNo) {
            case 2:
            case 3:
            case 5:
            case 7:
            case 8:
            case 9:
                return true;
            }

        case 4:
            return formulaNo == 5;

        case 5:
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

        case 15:
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

        case 18:
        case 27:
            switch (formulaNo) {
            case 1:
            case 2:
            case 3:
            case 5:
            case 8:
            case 9:
                return true;
            }

        case 21:
        case 24:
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
