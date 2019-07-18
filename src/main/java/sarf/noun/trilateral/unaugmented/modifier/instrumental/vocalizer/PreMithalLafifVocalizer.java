package sarf.noun.trilateral.unaugmented.modifier.instrumental.vocalizer;

import java.util.*;

import sarf.noun.*;
import sarf.noun.trilateral.unaugmented.modifier.*;
import sarf.verb.trilateral.Substitution.*;

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
public class PreMithalLafifVocalizer extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    List substitutions = new LinkedList();

    public PreMithalLafifVocalizer() {
        substitutions.add(new InfixSubstitution("مِوْ", "مِي")); // EX: (مِيسَم، مِيسمة، مِيصال، مِيفاء)
        substitutions.add(new InfixSubstitution("مِيْ", "مِي")); // EX: (مِيقَن، مِيقنة، مِيقان، مِيداء)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());

        switch (kov) {
        case 8:
            return noc == Conjugation.Forth;
        case 9:
            return noc == Conjugation.Second;
        case 10:
            switch (noc) {
            case 3:
            case 4:
            case 5:
                return true;
            }

        case 11:
            switch (noc) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return true;
            }

        case 12:
            return noc == Conjugation.Second || noc == Conjugation.Forth;
        case 13:
            return noc == Conjugation.Forth || noc == Conjugation.Sixth;

        case 14:
            switch (noc) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return true;
            }
        case 29:
            return noc == Conjugation.Second;

        case 30:
            switch (noc) {
            case 2:
            case 4:
            case 6:
                return true;
            }

        }
        return false;
    }

}
