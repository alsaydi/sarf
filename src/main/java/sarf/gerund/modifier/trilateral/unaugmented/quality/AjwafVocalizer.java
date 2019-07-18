package sarf.gerund.modifier.trilateral.unaugmented.quality;

import java.util.*;

import sarf.Conjugation;
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
    private List<Substitution> substitutions = new ArrayList<>();

    AjwafVocalizer() {
        substitutions.add(new InfixSubstitution("ِوْ", "ِي")); // EX: ( قِيمَة، )
        substitutions.add(new InfixSubstitution("ِيْ", "ِي")); // EX: ( بِيعَة، )
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();

        switch (kov) {
            case 15:
            case 16:
            case 17:
                switch (noc) {
                    case First:
                    case Forth:
                    case Fifth:
                        return true;
                }

            case 18:
            case 19:
            case 20:
                return noc == Conjugation.Second || noc == Conjugation.Forth;
        }
        return false;
    }
}
