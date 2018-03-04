package sarf.gerund.modifier.trilateral.unaugmented.quality;

import java.util.*;

import sarf.noun.*;
import sarf.verb.trilateral.unaugmented.modifier.*;

import sarf.verb.trilateral.Substitution.*;
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
public class AjwafVocalizer extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    List substitutions = new LinkedList();

    public AjwafVocalizer() {
        substitutions.add(new InfixSubstitution("öæú", "öí")); // EX: ( ÞöíãóÉ¡ )
        substitutions.add(new InfixSubstitution("öíú", "öí")); // EX: ( ÈöíÚóÉ¡ )
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());

        switch (kov) {
        case 15:
        case 16:
        case 17:
            switch (noc) {
            case 1:
            case 4:
            case 5:
                return true;
            }

        case 18:
        case 19:
        case 20:
            return noc == 2 || noc == 4;

        }
        return false;
    }
}
