package sarf.verb.quadriliteral.modifier.geminator.passive;

import java.util.*;

import sarf.substitution.ExpressionInfixSubstitution;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.ConjugationResult;
import sarf.substitution.SubstitutionsApplier;

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
        substitutions.add(new InfixSubstitution("نْنَ", "نَّ")); // EX: (نحن طُمْئِنَّا، هنَّ طُمْئِنَّ)
        substitutions.add(new ExpressionInfixSubstitution("ْC4ِC4َ", "ِC4َّ"));// EX: (ازيئن)
        substitutions.add(new ExpressionInfixSubstitution("ْC4ِC4ُ", "ِC4ُّ"));// EX: (ازيئنوا)
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
