package sarf.verb.trilateral.unaugmented.modifier.hamza;

import sarf.verb.trilateral.unaugmented.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.unaugmented.modifier.*;

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
public abstract class AbstractFaaMahmouz extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {
    public AbstractFaaMahmouz() {
    }

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
