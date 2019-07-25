package sarf.noun.trilateral.unaugmented.modifier.timeandplace.vocalizer;

import java.util.*;

import sarf.Conjugation;
import sarf.KindOfVerb;
import sarf.noun.*;

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
    private final List<Substitution> substitutions = new ArrayList<>();

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

        if (kov == KindOfVerb.Naqis_Wawi_Mahmouz_Faa) {
            return noc == Conjugation.First || noc == Conjugation.Fifth;
        } else if (kov == KindOfVerb.Naqis_Wawi_Mahmouz_Ain) {
            return noc == Conjugation.First || noc == Conjugation.Third;
        } else if (kov == KindOfVerb.Naqis_Wawi) {
            switch (noc) {
                case First:
                case Third:
                case Forth:
                case Fifth:
                    return true;
            }


            switch (noc) {
                case Second:
                case Third:
                case Forth:
                    return true;
            }


            return noc == Conjugation.Third || noc == Conjugation.Forth;
        } else if (kov == KindOfVerb.Naqis_Yaee_Mahmouz_Faa || kov == KindOfVerb.Naqis_Yaee) {
            switch (noc) {
                case Second:
                case Third:
                case Forth:
                    return true;
            }


            return noc == Conjugation.Third || noc == Conjugation.Forth;
        } else if (kov == KindOfVerb.Naqis_Yaee_Mahmouz_Ain) {
            return noc == Conjugation.Third || noc == Conjugation.Forth;
        } else if (kov == KindOfVerb.Lafeef_Maqroon_Mahmouz_Faa || kov == KindOfVerb.Lafeef_Mafrooq_Mahmouz_Ain) {
            return noc == Conjugation.Second;
        } else if (kov == KindOfVerb.Lafeef_Maqroon) {
            return noc == Conjugation.Second || noc == Conjugation.Forth;
        } else if (kov == KindOfVerb.Lafeef_Mafrooq) {
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
