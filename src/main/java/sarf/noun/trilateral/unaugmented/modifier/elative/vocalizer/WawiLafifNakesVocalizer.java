package sarf.noun.trilateral.unaugmented.modifier.elative.vocalizer;

import java.util.*;

import sarf.KindOfVerb;
import sarf.noun.*;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SuffixSubstitution;

import sarf.ConjugationResult;

import static sarf.KindOfVerb.Naqis_Wawi;

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
public class WawiLafifNakesVocalizer extends TrilateralNounSubstitutionApplier{
    private final List<Substitution> substitutions = new ArrayList<>();

    public WawiLafifNakesVocalizer() {
        substitutions.add(new SuffixSubstitution("َوُ", "َى"));// EX: (هذا الأعلى، )
        substitutions.add(new SuffixSubstitution("َوَ", "َى"));// EX: (رأيتُ الأعلى، )
        substitutions.add(new SuffixSubstitution("َوِ", "َى"));// EX: (مررتُ على الأعلى، )
        substitutions.add(new InfixSubstitution("َوَ", "َيَ"));// EX: (الأعليان)
        substitutions.add(new InfixSubstitution("َوُو", "َوْ"));// EX: (الأعلَوْن)
        substitutions.add(new InfixSubstitution("َوِي", "َيْ"));// EX: (الأعلَيْن)
        substitutions.add(new InfixSubstitution("ْوَى", "ْيَا"));// EX: (العليا)
        substitutions.add(new InfixSubstitution("ْوَي", "ْيَي"));// EX: (عُلْيَيَان)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        if (kov != Naqis_Wawi) {
            return false;
        }

        var noc = conjugationResult.getRoot().getConjugation();
        switch (noc) {
            case First:
            case Third:
            case Forth:
            case Fifth:
                return true;
        }

        return false;
    }
}
