package sarf.verb.trilateral.unaugmented.modifier.vocalizer.nakes.wawi.active;

import java.util.*;

import sarf.Conjugation;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.unaugmented.modifier.*;
import sarf.verb.trilateral.unaugmented.ConjugationResult;
import sarf.util.ArabCharUtil;

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
public class Past1Vocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {
    private List<Substitution> substitutions = new ArrayList<>();

    public Past1Vocalizer() {
        substitutions.add(new SuffixSubstitution("َوَ","َا"));// EX: (غزا، أسا، عثا)
        substitutions.add(new InfixSubstitution("َوُوا","َوْا"));// EX: (غزَوْا، أسوا، عَثَوْا)
        substitutions.add(new InfixSubstitution("َوَت","َت"));// EX: (غَزَتْ، غَزَتَا، أسَتْ، أسَتَا، عَثَتْ، عَثَتَا)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();
        return (kov == 21 || kov == 23) && (noc == Conjugation.First || noc == Conjugation.Third);
    }
}
