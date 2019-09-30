package sarf.verb.trilateral.augmented.modifier.geminator.generic;

import java.util.*;

import sarf.ConjugationResult;
import sarf.substitution.ExpressionInfixSubstitution;
import sarf.substitution.Substitution;
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
public class PassivePastGeminator extends SubstitutionsApplier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public PassivePastGeminator() {
        substitutions.add(new ExpressionInfixSubstitution("ْC3ِC3َ", "ِC3َّ")); // EX: (أُحِبَّ،)
        substitutions.add(new ExpressionInfixSubstitution("ْC3ِC3ُ", "ِC3ُّ")); // EX: (أُحِبُّوا،)
        substitutions.add(new ExpressionInfixSubstitution("ُC3ِC3َ", "ُC3َّ")); // EX: (انْقُضَّ)
        substitutions.add(new ExpressionInfixSubstitution("ُC3ِC3ُ", "ُC3ُّ")); // EX: (انْقُضُّوا)
        substitutions.add(new ExpressionInfixSubstitution("وC3ِC3َ", "وC3َّ")); // EX: (حُوجَّ، احْمُورَّ)
        substitutions.add(new ExpressionInfixSubstitution("وC3ِC3ُ", "وC3ُّ")); // EX: (حُوجُّوا، احْمُورُّوا)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    @Override
    public boolean isApplied(ConjugationResult conjugationResult) {
        return false;
    }
}
