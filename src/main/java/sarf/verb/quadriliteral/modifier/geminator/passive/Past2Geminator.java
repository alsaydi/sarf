package sarf.verb.quadriliteral.modifier.geminator.passive;

import java.util.*;
import sarf.verb.quadriliteral.substitution.*;
import sarf.verb.trilateral.Substitution.InfixSubstitution;
import sarf.verb.trilateral.Substitution.Substitution;
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
public class Past2Geminator extends SubstitutionsApplier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Past2Geminator() {
        substitutions.add(new InfixSubstitution("تْتُ", "تُّ")); // EX: (أنا كُبْرِتُّ)
        substitutions.add(new InfixSubstitution("تْتَ", "تَّ")); // EX: (أنتَ كُبْرِتَّ)
        substitutions.add(new InfixSubstitution("تْتِ", "تِّ")); // EX: (أنتِ كُبْرِتِّ)
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
        return conjugationResult.getRoot().getCharacters().get(3).getValue() == 'ت';
    }
}
