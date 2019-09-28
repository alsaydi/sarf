package sarf;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;

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
public final class VerbLamAlefModifier extends SubstitutionsApplier{
    private final List<Substitution> substitutions = new LinkedList<>();

    public VerbLamAlefModifier() {
        substitutions.add(new InfixSubstitution("لَا","لا"));// EX: (قالا)
        substitutions.add(new InfixSubstitution("لَّا","لاَّ"));// EX: (انْشَلاَّ)
        substitutions.add(new InfixSubstitution("لَأ","لأ"));// EX: (مَلأَ، مَلأْتُ)
        substitutions.add(new InfixSubstitution("لًا","لاً"));// EX: (حملاً)
    }

    public void apply(ConjugationResult conjResult) {
        apply(conjResult.getFinalResult(), null);
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

}
