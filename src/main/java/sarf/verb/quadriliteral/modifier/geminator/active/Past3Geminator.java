package sarf.verb.quadriliteral.modifier.geminator.active;

import java.util.*;
import sarf.verb.quadriliteral.substitution.*;
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
public class Past3Geminator extends SubstitutionsApplier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Past3Geminator() {
        substitutions.add(new InfixSubstitution("نْنَ", "نَّ"));// EX: (نحن طَمْأنَّا، هنَّ طَمْأنَّ)
        substitutions.add(new ExpressionInfixSubstitution("ْC4َC4َ", "َC4َّ"));// EX: (ازيأنَ)
        substitutions.add(new ExpressionInfixSubstitution("ْC4َC4ُ", "َC4ُّ"));// EX: (ازيأنَوا)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(QuadriConjugationResult quadriConjugationResult) {
        return quadriConjugationResult.getRoot().getC4() == 'ن';
    }
}
