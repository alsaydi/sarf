package sarf.verb.trilateral.unaugmented.modifier.vocalizer.mithal;

import java.util.*;

import sarf.Conjugation;
import sarf.KindOfVerb;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SubstitutionsApplier;

import sarf.verb.trilateral.unaugmented.modifier.*;
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
public class Imperative2Vocalizer extends SubstitutionsApplier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Imperative2Vocalizer() {
        substitutions.add(new InfixSubstitution("اوْ","اي"));// EX: (ايجل، ايبأ، ايدد، ايئب )
    }

    @Override
    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    @Override
    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();
        return (kov == KindOfVerb.Mithal_Wawi_Mudaaf || kov == KindOfVerb.Mithal_Wawi_Mahmouz_Ain || kov == KindOfVerb.Mithal_Wawi_Mahmouz_Laam || kov == KindOfVerb.Mithal_Wawi)  && noc == Conjugation.Forth ;
    }
}
