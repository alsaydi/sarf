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
public class Past2Geminator extends SubstitutionsApplier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Past2Geminator() {
        substitutions.add(new InfixSubstitution("تْتُ", "تُّ")); // EX: (أنا كَبْرَتُّ)
        substitutions.add(new InfixSubstitution("تْتَ", "تَّ")); // EX: (أنتَ كَبْرَتَّ)
        substitutions.add(new InfixSubstitution("تْتِ", "تِّ")); // EX: (أنتِ كَبْرَتِّ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        return conjugationResult.getRoot().getC4() == 'ت';
    }
}
