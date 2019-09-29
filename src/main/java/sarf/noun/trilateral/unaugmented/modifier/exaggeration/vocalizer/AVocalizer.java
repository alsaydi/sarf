package sarf.noun.trilateral.unaugmented.modifier.exaggeration.vocalizer;

import java.util.*;

import sarf.Conjugation;
import sarf.KindOfVerb;
import sarf.noun.*;

import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;

import sarf.noun.trilateral.unaugmented.modifier.*;
import sarf.ConjugationResult;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: الصيغة القياسية فهي غير واردة الرمز في قاعدة السماعي        </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class AVocalizer extends TrilateralNounSubstitutionApplier{
    private final List<Substitution> substitutions = new LinkedList<>();

    public AVocalizer() {
        substitutions.add(new InfixSubstitution("اوًا", "اءً")); // EX: (غَزَّاءً)
        substitutions.add(new InfixSubstitution("ايًا", "اءً")); // EX: (رمَّاءً)
        substitutions.add(new InfixSubstitution("او", "اء")); // EX: (غَزَّاءٌ)
        substitutions.add(new InfixSubstitution("اي", "اء")); // EX: (رمَّاءٌ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        String nounFormula = conjugationResult.getNounFormula();
        if (!nounFormula.equals("فَعَّال")) {
            return false;
        }

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


            if (noc == Conjugation.Second) {
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
