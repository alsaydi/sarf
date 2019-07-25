package sarf.gerund.modifier.trilateral.unaugmented.meem.vocalizer;

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
public class NakesLafifVocalizer extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    private List<Substitution> substitutions = new ArrayList<>();

    public NakesLafifVocalizer() {
        substitutions.add(new InfixSubstitution("َوٌ", "ًى")); // EX: (هذا مَغْزًى )
        substitutions.add(new InfixSubstitution("َوًا", "ًى")); // EX: (رأيت مَغْزًى )
        substitutions.add(new InfixSubstitution("َوٍ", "ًى")); // EX: (بِمَغْزًى )
        substitutions.add(new SuffixSubstitution("َوُ", "َى")); // EX: (هذا مَغْزَى الأمر)
        substitutions.add(new SuffixSubstitution("َوَ", "َى")); // EX: (رأيت مَغْزَى الأمر)
        substitutions.add(new SuffixSubstitution("َوِ", "َى")); // EX: (بِمَغْزَى الأمر)
        substitutions.add(new InfixSubstitution("َيٌ", "ًى")); // EX: (هذا مرمًى )
        substitutions.add(new InfixSubstitution("َيًا", "ًى")); // EX: (رأيت مرمًى)
        substitutions.add(new InfixSubstitution("َيٍ", "ًى")); // EX: (بِمرمًى)
        substitutions.add(new SuffixSubstitution("َيُ", "َى")); // EX: (هذا مرمَى القوم)
        substitutions.add(new SuffixSubstitution("َيَ", "َى")); // EX: (رأيت مرمَى القوم)
        substitutions.add(new SuffixSubstitution("َيِ", "َى")); // EX: (بِمرمَى القوم)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        if (!conjugationResult.getNounFormula().equals("مَفْعَل")) {
            return false;
        }

        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();

        if (kov == 21) {
            return noc == Conjugation.First || noc == Conjugation.Fifth;
        } else if (kov == 22) {
            return noc == Conjugation.First || noc == Conjugation.Third;
        } else if (kov == 23) {
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
        } else if (kov == 24 || kov == KindOfVerb.Naqis_Yaee) {
            switch (noc) {
                case Second:
                case Third:
                case Forth:
                    return true;
            }


            return noc == Conjugation.Third || noc == Conjugation.Forth;
        } else if (kov == 25) {
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
