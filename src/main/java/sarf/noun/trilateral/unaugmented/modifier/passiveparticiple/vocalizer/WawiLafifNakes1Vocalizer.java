package sarf.noun.trilateral.unaugmented.modifier.passiveparticiple.vocalizer;

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
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class WawiLafifNakes1Vocalizer extends TrilateralNounSubstitutionApplier{
    private final List<Substitution> substitutions = new ArrayList<>();

    public WawiLafifNakes1Vocalizer() {
        substitutions.add(new InfixSubstitution("ُوو", "ُوّ")); // EX: (مأسُوّ، مَغْزُوّ، مَسْرُوّ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
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
                case Fifth:
                    return true;
            }
        }
        return false;
    }
}
