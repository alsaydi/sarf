package sarf.verb.trilateral.unaugmented.modifier.hamza;

import sarf.verb.trilateral.unaugmented.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.unaugmented.modifier.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: «·’› «·√» «·„‘ —ﬂ ·„Â„Ê“ «·⁄Ì‰ Õ”» ‘—ÿ «·›Õ’ «·„‘ —ﬂ ··„÷«—⁄ Ê«·√„— Ê«·„«÷Ì           </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public abstract class AbstractEinMahmouz extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {
    public AbstractEinMahmouz() {
    }

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
