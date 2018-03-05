package sarf.noun.trilateral.augmented.modifier;

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
        int kov = conjugationResult.getKov();

        switch (kov) {
        case 6:
        case 9:
        case 13:
        case 22:
        case 25:
        case 29:
            return true;
        }

        return false;
    }
}
