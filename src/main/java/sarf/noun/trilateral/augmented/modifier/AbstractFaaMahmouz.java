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
public abstract class AbstractFaaMahmouz extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();

        switch (kov) {
        case 3:
        case 4:
        case 5:
        case 15:
        case 18:
        case 21:
        case 24:
        case 27:
            return true;
        }
        return false;
    }
}
