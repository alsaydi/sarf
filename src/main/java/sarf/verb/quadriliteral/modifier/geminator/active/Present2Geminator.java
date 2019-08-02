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
public class Present2Geminator extends SubstitutionsApplier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Present2Geminator() {
        substitutions.add(new InfixSubstitution("نْنَ", "نَّ")); // EX: (أنتن تَطْمَأْنِنَّ، هنَّ يَطْمَأْنِنَّ)
        substitutions.add(new ExpressionInfixSubstitution("ْC4ِC4ُ", "ِC4ُّ")); // EX: (هو يَقْشَعِرُّ)
        substitutions.add(new ExpressionInfixSubstitution("ْC4ِC4َ", "ِC4َّ")); // EX: (هما يَقْشَعِرَّانِ)
        substitutions.add(new ExpressionInfixSubstitution("ْC4ِC4ِ", "ِC4ِّ")); // EX: (أنتِ تَقْشَعِرِّينَ)
        substitutions.add(new ExpressionSuffixSubstitution("ْC4ِC4ْ", "ِC4َّ")); // EX: (لم يَقْشَعِرَّ)

    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        return conjugationResult.getRoot().getC4() == 'ن';
    }
}
