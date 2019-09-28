package sarf.noun.trilateral.unaugmented.modifier;

import sarf.Conjugation;
import sarf.KindOfVerb;
import sarf.noun.*;

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
public abstract class AbstractGeminator extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    protected AbstractGeminator() {
    }

    public boolean isApplied(NounConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();

        if (kov == KindOfVerb.Mudaaf) {
            switch (noc) {
                case First:
                case Second:
                case Third:
                case Forth:
                case Fifth:
                    return true;
            }
            return false;
        } else if (kov == KindOfVerb.Mahmouz_Faa_Mudaaf) {
            return noc == Conjugation.Second || noc == Conjugation.First;
        } else if (kov == KindOfVerb.Mithal_Wawi_Mudaaf) {
            return noc == Conjugation.Forth;
        } else if (kov == KindOfVerb.Mithal_Yaee_Mudaaf) {
            return noc == Conjugation.Second || noc == Conjugation.Forth;
        }
        return false;
    }
}
