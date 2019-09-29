package sarf.verb.trilateral.unaugmented.modifier.vocalizer.lafif.separeted;

import java.util.*;

import sarf.Conjugation;
import sarf.KindOfVerb;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SubstitutionsApplier;
import sarf.substitution.SuffixSubstitution;

import sarf.ConjugationResult;
import sarf.verb.trilateral.unaugmented.modifier.*;

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
public class ActivePresent3Vocalizer extends SubstitutionsApplier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public ActivePresent3Vocalizer() {
        substitutions.add(new SuffixSubstitution("َيُ","َى"));// EX: (يَوْجَى)
        substitutions.add(new SuffixSubstitution("َيَ","َى"));// EX: (لن يَوْجَى)
        substitutions.add(new SuffixSubstitution("َيْ","َ"));// EX: (لم يَوْجَ)
        substitutions.add(new InfixSubstitution("َيِي","َيْ"));// EX: (أنتِ تَوْجَيْنَ)
        substitutions.add(new InfixSubstitution("َيُو","َوْ"));// EX: (أنتم تَوْجَوْنَ)
        substitutions.add(new InfixSubstitution("َيُن","َوُن"));// EX: (أنتم تَوْجَوُنَّ)
    }

    @Override
    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    @Override
    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();
        return (kov == KindOfVerb.Lafeef_Mafrooq  && noc == Conjugation.Forth);
    }
}
