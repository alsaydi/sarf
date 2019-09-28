package sarf.verb.trilateral.augmented.modifier.geminator.generic;

import java.util.*;

import sarf.substitution.ExpressionInfixSubstitution;
import sarf.substitution.ExpressionSuffixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SubstitutionsApplier;
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
public class ImperativeGeminator extends SubstitutionsApplier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public ImperativeGeminator() {
        substitutions.add(new ExpressionInfixSubstitution("C1ْC3ِC3ُ", "C1ِC3ُّ")); // EX: (أَتِمُّوا)
        substitutions.add(new ExpressionInfixSubstitution("C1ْC3ِC3َ", "C1ِC3َّ")); // EX: (أَتِمَّا)
        substitutions.add(new ExpressionInfixSubstitution("C1ْC3ِC3ِ", "C1ِC3ِّ")); // EX: (أَتِمِّي)
        substitutions.add(new ExpressionSuffixSubstitution("C1ْC3ِC3ْ", "C1ِC3َّ")); // EX: (أَتِمَّ)
        substitutions.add(new ExpressionInfixSubstitution("C3ِC3ُ", "C3ُّ")); // EX: (انقَضُّوا، حاجُّوا)
        substitutions.add(new ExpressionInfixSubstitution("C3ِC3َ", "C3َّ")); // EX: (انْقَضَّا، حاجَّا)
        substitutions.add(new ExpressionInfixSubstitution("C3ِC3ِ", "C3ِّ")); // EX: (انْقَضِّي، حاجِّي)
        substitutions.add(new ExpressionSuffixSubstitution("C3ِC3ْ", "C3َّ")); // EX: (انْقَضَّ، حاجَّ)
        substitutions.add(new ExpressionSuffixSubstitution("اC3َC3ْ", "اC3َّ")); // EX: (تآجَّ)
        substitutions.add(new ExpressionInfixSubstitution("اC3َC3ْن","اC3َC3ْن"));// EX: (تآجَجْنَ)
        substitutions.add(new ExpressionInfixSubstitution("اC3َC3", "اC3ّ")); // EX: (تآجُّوا، تآجَّا، تآجِّي)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
