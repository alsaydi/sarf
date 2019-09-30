package sarf.verb.trilateral.unaugmented.modifier.geminator.generic;

import sarf.ConjugationResult;
import sarf.substitution.ExpressionInfixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SubstitutionsApplier;


import java.util.*;

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
public class ActivePastGeminator extends SubstitutionsApplier {

    private final List<Substitution> substitutions = new ArrayList<>();

    public ActivePastGeminator() {
        substitutions.add(new ExpressionInfixSubstitution("C2َC3َ","C3َّ"));
        substitutions.add(new ExpressionInfixSubstitution("C2َC3ُ","C3ُّ"));
        substitutions.add(new ExpressionInfixSubstitution("C2ِC3َ","C3َّ"));
        substitutions.add(new ExpressionInfixSubstitution("C2ِC3ُ","C3ُّ"));
        substitutions.add(new ExpressionInfixSubstitution("C2ُC3َ","C3َّ"));
        substitutions.add(new ExpressionInfixSubstitution("C2ُC3ُ","C3ُّ"));

    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    @Override
    public boolean isApplied(ConjugationResult conjugationResult) {
        return false;
    }
}
