package sarf.verb.trilateral.unaugmented.modifier.geminator.generic;

import java.util.*;
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

    private List substitutions = new LinkedList();

    public ImperativeGeminator() {
        substitutions.add(new ExpressionInfixSubstitution("اC1ْC3ُC3ُ","C1ُC3ُّ"));// EX: (مُدُّوا)
        substitutions.add(new ExpressionInfixSubstitution("اC1ْC3ُC3َ","C1ُC3َّ"));// EX: (مُدَّا)
        substitutions.add(new ExpressionInfixSubstitution("اC1ْC3ُC3ِ","C1ُC3ِّ"));// EX: (مُدِّي)
        substitutions.add(new ExpressionSuffixSubstitution("اC1ْC3ُC3ْ","C1ُC3َّ"));// EX: (مُدَّ)
        substitutions.add(new ExpressionInfixSubstitution("اC1ْC3ِC3ُ","C1ِC3ُّ"));// EX: (تِمُّوا)
        substitutions.add(new ExpressionInfixSubstitution("اC1ْC3ِC3َ","C1ِC3َّ"));// EX: (تِمَّا)
        substitutions.add(new ExpressionInfixSubstitution("اC1ْC3ِC3ِ","C1ِC3ِّ"));// EX: (تِمِّي)
        substitutions.add(new ExpressionSuffixSubstitution("اC1ْC3ِC3ْ","C1ِC3َّ"));// EX: (تِمَّ)
        substitutions.add(new ExpressionInfixSubstitution("اC1ْC3َC3ُ","C1َC3ُّ"));// EX: (عَضُّوا)
        substitutions.add(new ExpressionInfixSubstitution("اC1ْC3َC3َ","C1َC3َّ"));// EX: (عَضَّا)
        substitutions.add(new ExpressionInfixSubstitution("اC1ْC3َC3ِ","C1َC3ِّ"));// EX: (عَضِّي)
        substitutions.add(new ExpressionSuffixSubstitution("اC1ْC3َC3ْ","C1َC3َّ"));// EX: (عَضَّ)
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
