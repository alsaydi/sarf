package sarf.verb.quadriliteral.modifier.geminator.active;

import java.util.*;
import sarf.verb.quadriliteral.substitution.*;
import sarf.substitution.ExpressionInfixSubstitution;
import sarf.substitution.ExpressionSuffixSubstitution;
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
public class Imperative2Geminator extends SubstitutionsApplier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Imperative2Geminator() {
        substitutions.add(new InfixSubstitution("نْنَ", "نَّ")); // EX: (أنتن اطْمَأْنِنَّ)
        substitutions.add(new ExpressionSuffixSubstitution("C3ْC4ِC4ْ", "C3ِC4َّ")); // EX: (اقْشَعِرَّ)
        substitutions.add(new ExpressionInfixSubstitution("C3ْC4ِC4َ", "C3ِC4َّ")); // EX: (اقْشَعِرَّا)
        substitutions.add(new ExpressionInfixSubstitution("C3ْC4ِC4ُ", "C3ِC4ُّ")); // EX: (اقْشَعِرُّوا)
        substitutions.add(new ExpressionInfixSubstitution("C3ْC4ِC4ِ", "C3ِC4ِّ")); // EX: (اقْشَعِرِّي)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        if (conjugationResult.getRoot().getCharacters().isEmpty()) {
            return false;
        }
        if (conjugationResult.getRoot().getCharacters().size() < 4) {
            return false;
        }
        return conjugationResult.getRoot().getCharacters().get(3).getValue() == 'ن';
    }
}
