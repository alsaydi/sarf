package sarf.verb.trilateral.unaugmented.modifier.vocalizer.lafif.connected;

import java.util.*;

import sarf.Conjugation;
import sarf.KindOfVerb;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SubstitutionsApplier;
import sarf.substitution.SuffixSubstitution;

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
public class ActivePast1Vocalizer extends SubstitutionsApplier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public ActivePast1Vocalizer() {
        substitutions.add(new SuffixSubstitution("َيَ","َى"));
        substitutions.add(new InfixSubstitution("َيُوا","َوْا"));
        substitutions.add(new InfixSubstitution("َيَت","َت"));
    }

    @Override
    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    @Override
    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();
        return (kov == KindOfVerb.Lafeef_Maqroon_Mahmouz_Faa || kov == KindOfVerb.Lafeef_Maqroon) && (noc == Conjugation.Second);
    }
}
