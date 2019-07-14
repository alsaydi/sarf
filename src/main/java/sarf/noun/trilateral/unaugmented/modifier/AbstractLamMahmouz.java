package sarf.noun.trilateral.unaugmented.modifier;

import java.util.*;

import sarf.noun.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.noun.trilateral.unaugmented.modifier.IUnaugmentedTrilateralNounModificationApplier;
import sarf.noun.trilateral.unaugmented.modifier.*;

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
public abstract class AbstractLamMahmouz extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();

        switch (kov) {
        case 4:
        case 7:
        case 10:
        case 16:
        case 19:
            return true;
        }

        return false;
    }
}
