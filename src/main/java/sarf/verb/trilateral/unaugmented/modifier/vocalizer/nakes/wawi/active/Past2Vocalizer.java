package sarf.verb.trilateral.unaugmented.modifier.vocalizer.nakes.wawi.active;

import java.util.*;

import sarf.Conjugation;
import sarf.KindOfVerb;
import sarf.verb.trilateral.Substitution.*;
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
public class Past2Vocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Past2Vocalizer() {
        substitutions.add(new SuffixSubstitution("َوَ", "َى")); // EX: (مأى، جأى )
        substitutions.add(new InfixSubstitution("َوُوا", "َوْا")); // EX: (مأَوْا، جأوْا)
        substitutions.add(new InfixSubstitution("َوَت", "َت")); // EX: (مأتْ، مأتَا، جأتْ، جأتَا)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();
        return (kov == KindOfVerb.Naqis_Wawi_Mahmouz_Ain) && (noc == Conjugation.First || noc == Conjugation.Third);
    }
}
