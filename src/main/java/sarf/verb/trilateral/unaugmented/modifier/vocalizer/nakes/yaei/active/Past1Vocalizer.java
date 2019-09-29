package sarf.verb.trilateral.unaugmented.modifier.vocalizer.nakes.yaei.active;

import sarf.Conjugation;
import sarf.ConjugationResult;
import sarf.KindOfVerb;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SubstitutionsApplier;
import sarf.substitution.SuffixSubstitution;

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
public class Past1Vocalizer extends SubstitutionsApplier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Past1Vocalizer() {
        substitutions.add(new SuffixSubstitution("َيَ","َى"));// EX: (رمى، أتى، سعى، نأى، أبى )
        substitutions.add(new InfixSubstitution("َيُوا","َوْا"));// EX: (رَمَوْا، أتَوْا، سَعَوْا، نأوْا، أبَوْا)
        substitutions.add(new InfixSubstitution("َيَت","َت"));// EX: (رَمَتْ، رَمَتَا، أتَتْ، أتَتَا، سَعَتْ، سَعَتَا، نَأتْ، نأتَا، أبَتْ، أبَتَا)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    @Override
    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();
        return (kov == KindOfVerb.Naqis_Yaee_Mahmouz_Faa || kov == KindOfVerb.Naqis_Yaee_Mahmouz_Ain || kov == KindOfVerb.Naqis_Yaee) && (noc == Conjugation.Second || noc == Conjugation.Third);
    }
}
