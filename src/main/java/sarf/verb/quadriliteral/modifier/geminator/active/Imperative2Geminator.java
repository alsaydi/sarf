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
public class Imperative2Geminator extends SubstitutionsApplier implements IQuadrilateralModifier {

    private final List<Substitution> substitutions = new ArrayList<>();

    public Imperative2Geminator() {
        substitutions.add(new InfixSubstitution("نْنَ", "نَّ")); // EX: (أنتن اطْمَأْنِنَّ)
        substitutions.add(new ExpressionSuffixSubstitution("C3ْC4ِC4ْ", "C3ِC4َّ")); // EX: (اقْشَعِرَّ)
        substitutions.add(new ExpressionInfixSubstitution("C3ْC4ِC4َ", "C3ِC4َّ")); // EX: (اقْشَعِرَّا)
        substitutions.add(new ExpressionInfixSubstitution("C3ْC4ِC4ُ", "C3ِC4ُّ")); // EX: (اقْشَعِرُّوا)
        substitutions.add(new ExpressionInfixSubstitution("C3ْC4ِC4ِ", "C3ِC4ِّ")); // EX: (اقْشَعِرِّي)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        return conjugationResult.getRoot().getC4() == 'ن';
    }
}
