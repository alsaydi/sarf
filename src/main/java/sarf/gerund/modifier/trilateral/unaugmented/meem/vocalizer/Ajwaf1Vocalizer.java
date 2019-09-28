package sarf.gerund.modifier.trilateral.unaugmented.meem.vocalizer;

import sarf.Conjugation;
import sarf.KindOfVerb;
import sarf.noun.TrilateralNounSubstitutionApplier;
import sarf.noun.trilateral.unaugmented.modifier.NounConjugationResult;
import sarf.noun.trilateral.unaugmented.modifier.IUnaugmentedTrilateralNounModificationApplier;
import sarf.verb.trilateral.Substitution.InfixSubstitution;
import sarf.verb.trilateral.Substitution.Substitution;

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
public class Ajwaf1Vocalizer extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Ajwaf1Vocalizer() {
        substitutions.add(new InfixSubstitution("ْيِ", "ِي"));// EX: ( مَبِيع، )
        substitutions.add(new InfixSubstitution("ْيَ", "َا"));// EX: (محار)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(NounConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();

        if (kov == KindOfVerb.Ajwaf_Yaee_Mahmouz_Faa || kov == KindOfVerb.Ajwaf_Yaee) {//return noc == 2;
            return noc == Conjugation.Second;
        } else if (kov == KindOfVerb.Ajwaf_Yaee_Mahmouz_Laam) {//return noc == 2 || noc == Conjugation.Forth;
            return noc == Conjugation.Second || noc == Conjugation.Forth;
        }
        return false;
    }
}
