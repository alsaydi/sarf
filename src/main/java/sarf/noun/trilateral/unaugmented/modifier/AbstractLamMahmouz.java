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
public abstract class AbstractLamMahmouz extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        return kov == 4 || kov == 7 || kov == 10 || kov == 16 || kov == KindOfVerb.Ajwaf_Yaee_Mahmouz_Laam;
    }
}
