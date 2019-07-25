package sarf.noun.trilateral.unaugmented.modifier.instrumental.vocalizer;

import java.util.*;

import sarf.Conjugation;
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
public class YaeiNakesLafifVocalizer extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    private List<Substitution> substitutions = new ArrayList<>();

    public YaeiNakesLafifVocalizer() {
        substitutions.add(new SuffixSubstitution("َيُ","َى"));// EX: (هذا المِسرى )
        substitutions.add(new SuffixSubstitution("َيَ","َى"));// EX: (رأيت المِسرى)
        substitutions.add(new SuffixSubstitution("َيِ","َى"));// EX: (كالمِسرى )
        substitutions.add(new InfixSubstitution("َيٌ","ًى"));// EX: (هذا مِسرًى )
        substitutions.add(new InfixSubstitution("َيًا","ًى"));// EX: (رأيت مِسرًى)
        substitutions.add(new InfixSubstitution("َيٍ","ًى"));// EX: (كَمِسرًى )
        substitutions.add(new InfixSubstitution("ايًا","اءً"));// EX: (مِسراءً)
        substitutions.add(new InfixSubstitution("َيَة","َاة"));// EX: (مِسراة )
        substitutions.add(new InfixSubstitution("َيَت","َات"));// EX: (مِسراتان )
        substitutions.add(new InfixSubstitution("اي","اء"));// EX: (مِسراء )
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        if (conjugationResult.getRoot().getC3() != 'ي')
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
