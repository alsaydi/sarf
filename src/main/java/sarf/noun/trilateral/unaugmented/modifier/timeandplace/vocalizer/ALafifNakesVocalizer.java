package sarf.noun.trilateral.unaugmented.modifier.timeandplace.vocalizer;

import java.util.*;

import sarf.Conjugation;
import sarf.KindOfVerb;
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
public class ALafifNakesVocalizer extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    private List<Substitution> substitutions = new ArrayList<>();

    public ALafifNakesVocalizer() {
        substitutions.add(new InfixSubstitution("يَيٌ", "يَا")); // EX: (هذا المَحيا )
        substitutions.add(new InfixSubstitution("يَيً", "يَا")); // EX: (رأيتُ المَحيا )
        substitutions.add(new InfixSubstitution("يَيٍ", "يَا")); // EX: (بالمَحيا )
        substitutions.add(new InfixSubstitution("َوَ", "َيَ")); // EX: (مَغْزِيان )
        substitutions.add(new InfixSubstitution("َيَ", "َيَ")); // EX: (مَمْشَيان )
        substitutions.add(new InfixSubstitution("َو", "َى")); // EX: (مَغْزَى )
        substitutions.add(new InfixSubstitution("َي", "َى")); // EX: (مَمْشَى )
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        String nounFormula = conjugationResult.getNounFormula();
        if (!nounFormula.equals("مَفْعَل"))
            return false;

        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();

        switch (kov) {
        case 21:
            return noc == Conjugation.First || noc == Conjugation.Fifth;
        case 22:
            return noc == Conjugation.First || noc == Conjugation.Third;
        case 23:
            switch (noc) {
                case First:
                case Third:
                case Forth:
                case Fifth:
                    return true;
            }
        case 24:
        case 26:
            switch (noc) {
                case Second:
                case Third:
                case Forth:
                    return true;
            }

        case 25:
            return noc == Conjugation.Third || noc == Conjugation.Forth;

        case 27:
        case 29:
            return noc == Conjugation.Second;
        case 28:
            return noc == Conjugation.Second || noc == Conjugation.Forth;

        case 30:
            switch (noc) {
                case Second:
                case Forth:
                case Sixth:
                    return true;
            }
        }
        return false;
    }
}
