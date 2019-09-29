package sarf.gerund.modifier.trilateral.unaugmented.meem.vocalizer;

import sarf.Conjugation;
import sarf.ConjugationResult;
import sarf.KindOfVerb;
import sarf.noun.TrilateralNounSubstitutionApplier;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;

import java.util.ArrayList;
import java.util.List;

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
public class Ajwaf2Vocalizer extends TrilateralNounSubstitutionApplier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Ajwaf2Vocalizer() {
        substitutions.add(new InfixSubstitution("ْوَ", "َا")); // EX: ( مَتاب، )
        substitutions.add(new InfixSubstitution("ْيَ", "َا"));// EX: (مغاد)
    }

    @Override
    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    @Override
    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();

        if (kov == KindOfVerb.Ajwaf_Wawi_Mahmouz_Faa || kov == KindOfVerb.Ajwaf_Wawi_Mahmouz_Laam || kov == KindOfVerb.Ajwaf_Wawi) {
            switch (noc) {
                case First:
                case Forth:
                case Fifth:
                    return true;
            }
            return false;
        } else if (kov == KindOfVerb.Ajwaf_Yaee_Mahmouz_Faa || kov == KindOfVerb.Ajwaf_Yaee_Mahmouz_Laam || kov == KindOfVerb.Ajwaf_Yaee) {
            return noc == Conjugation.Forth;
        }
        return false;
    }
}

