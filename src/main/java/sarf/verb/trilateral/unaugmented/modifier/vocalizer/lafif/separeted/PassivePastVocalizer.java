package sarf.verb.trilateral.unaugmented.modifier.vocalizer.lafif.separeted;

import java.util.*;

import sarf.Conjugation;
import sarf.KindOfVerb;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.unaugmented.modifier.*;
import sarf.verb.trilateral.unaugmented.ConjugationResult;

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
public class PassivePastVocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public PassivePastVocalizer() {
        substitutions.add(new InfixSubstitution("ِيْ", "ِي"));
        substitutions.add(new InfixSubstitution("ِيُ", "ُ"));
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();
        return ((kov == KindOfVerb.Lafeef_Mafrooq_Mahmouz_Ain || kov == KindOfVerb.Lafeef_Mafrooq ) && (noc == Conjugation.Second)) ||
                (kov == KindOfVerb.Lafeef_Mafrooq  && (noc == Conjugation.Sixth || noc == Conjugation.Forth));
    }
}
