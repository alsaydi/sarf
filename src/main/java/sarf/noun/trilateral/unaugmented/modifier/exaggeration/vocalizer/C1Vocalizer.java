package sarf.noun.trilateral.unaugmented.modifier.exaggeration.vocalizer;

import java.util.*;

import sarf.Conjugation;
import sarf.KindOfVerb;
import sarf.noun.*;

import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;

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
public class C1Vocalizer extends TrilateralNounSubstitutionApplier{
    private final List<Substitution> substitutions = new ArrayList<>();

    public C1Vocalizer() {
        substitutions.add(new InfixSubstitution("مِوْ","مِي"));// EX: (مِيصال )
    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        String nounFormula = conjugationResult.getNounFormula();
        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();

        return nounFormula.equals("مِفْعَال") && (kov == KindOfVerb.Mithal_Wawi
                && (noc == Conjugation.Second || noc == Conjugation.Third || noc == Conjugation.Fifth || noc == Conjugation.Sixth));
    }

}
