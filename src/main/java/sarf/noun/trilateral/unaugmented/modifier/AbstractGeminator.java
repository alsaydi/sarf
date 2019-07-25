package sarf.noun.trilateral.unaugmented.modifier;

import java.util.*;

import sarf.Conjugation;
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
public abstract class AbstractGeminator extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    protected AbstractGeminator() {
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();

        if (kov == 2) {
            switch (noc) {
                case First:
                case Second:
                case Third:
                case Forth:
                case Fifth:
                    return true;
            }
            return noc == Conjugation.Second || noc == Conjugation.First; //TODO: simplify this
        } else if (kov == 3) {
            return noc == Conjugation.Second || noc == Conjugation.First;
        } else if (kov == 8) {
            return noc == Conjugation.Forth;
        } else if (kov == 12) {
            return noc == Conjugation.Second || noc == Conjugation.Forth;
        }
        return false;
    }
}
