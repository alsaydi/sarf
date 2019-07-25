package sarf.noun.trilateral.unaugmented.modifier;

import java.util.*;

import sarf.KindOfVerb;
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
public abstract class AbstractFaaMahmouz extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        return kov == 3 || kov == 4 || kov == 5 || kov == 15 || kov == 18 || kov == 21 || kov == 24 || kov == KindOfVerb.Lafeef_Maqroon_Mahmouz_Faa;
    }
}
