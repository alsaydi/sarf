package sarf.noun.trilateral.unaugmented.modifier.instrumental.vocalizer;

import java.util.*;

import sarf.Conjugation;
import sarf.KindOfVerb;
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
public class WawiNakesLafifVocalizer extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    private List<Substitution> substitutions = new ArrayList<>();

    public WawiNakesLafifVocalizer() {
        substitutions.add(new SuffixSubstitution("َوُ", "َى")); // EX: (هذا المِغْزَى )
        substitutions.add(new SuffixSubstitution("َوَ", "َى")); // EX: (رأيت المِغْزَى )
        substitutions.add(new SuffixSubstitution("َوِ", "َى")); // EX: (كالمِغْزَى )
        substitutions.add(new InfixSubstitution("َوٌ", "ًى")); // EX: (هذا مِغْزًى )
        substitutions.add(new InfixSubstitution("َوًا", "ًى")); // EX: (رأيت مِغْزًى )
        substitutions.add(new InfixSubstitution("َوٍ", "ًى")); // EX: (كَمِغْزًى )
        substitutions.add(new InfixSubstitution("اوًا", "اءً")); // EX: (مِغْزاءً)
        substitutions.add(new InfixSubstitution("َوَة", "َاة")); // EX: (مِغْزاة )
        substitutions.add(new InfixSubstitution("َوَت", "َات")); // EX: (مِغْزاتان )
        substitutions.add(new InfixSubstitution("َوَ", "َيَ")); // EX: (مِغْزَيان )
        substitutions.add(new InfixSubstitution("او","اء"));// EX: (مِغْزاء )
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        if (conjugationResult.getRoot().getC3() != 'و')
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
