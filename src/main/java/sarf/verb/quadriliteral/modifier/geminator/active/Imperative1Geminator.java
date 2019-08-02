package sarf.verb.quadriliteral.modifier.geminator.active;

import java.util.*;
import sarf.verb.quadriliteral.substitution.*;
import sarf.verb.quadriliteral.modifier.*;
import sarf.verb.quadriliteral.*;

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
public class Imperative1Geminator extends SubstitutionsApplier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Imperative1Geminator() {
        substitutions.add(new ExpressionSuffixSubstitution("C3ْC4ِC4ْ", "C3ِC4َّ")); // EX: (اقْشَعِرَّ)
        substitutions.add(new ExpressionInfixSubstitution("C3ْC4ِC4َ", "C3ِC4َّ")); // EX: (اقْشَعِرَّا)
        substitutions.add(new ExpressionInfixSubstitution("C3ْC4ِC4ُ", "C3ِC4ُّ")); // EX: (اقْشَعِرُّوا)
        substitutions.add(new ExpressionInfixSubstitution("C3ْC4ِC4ِ", "C3ِC4ِّ")); // EX: (اقْشَعِرِّي)

    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        return conjugationResult.getFormulaNo() == 3;
    }
}
