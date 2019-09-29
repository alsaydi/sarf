package sarf.verb.trilateral.unaugmented.modifier.vocalizer.mithal;

import sarf.Conjugation;
import sarf.ConjugationResult;
import sarf.KindOfVerb;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SubstitutionsApplier;

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
public class WawiPassivePresentVocalizer extends SubstitutionsApplier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public WawiPassivePresentVocalizer() {
        substitutions.add(new InfixSubstitution("ُوْ", "ُو"));// EX: (يُوعَدُ، يُوهَبُ، يُورَثُ، )
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    @Override
    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();
        return (kov == KindOfVerb.Mithal_Wawi_Mahmouz_Ain && noc == Conjugation.Second) ||
                (kov == KindOfVerb.Mithal_Wawi_Mahmouz_Laam && (noc == Conjugation.Third || noc == Conjugation.Forth || noc == Conjugation.Fifth)) ||
                (kov == KindOfVerb.Mithal_Wawi && (noc == Conjugation.Second || noc == Conjugation.Third || noc == Conjugation.Forth || noc == Conjugation.Fifth));
    }
}
