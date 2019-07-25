package sarf.verb.trilateral.unaugmented.modifier.geminator.generic;

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
public class PassivePastGeminator extends SubstitutionsApplier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public PassivePastGeminator() {
        substitutions.add(new ExpressionInfixSubstitution("C3ِC3َ", "C3َّ"));
        substitutions.add(new ExpressionInfixSubstitution("C3ِC3ُ", "C3ُّ"));
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
