package sarf.verb.trilateral.unaugmented.modifier.geminator.generic;

import java.util.*;

import sarf.ConjugationResult;
import sarf.substitution.ExpressionInfixSubstitution;
import sarf.substitution.ExpressionSuffixSubstitution;
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
public class ActivePresentGeminator extends SubstitutionsApplier {

    private final List<Substitution> substitutions = new ArrayList<>();

    public ActivePresentGeminator() {

        substitutions.add(new ExpressionInfixSubstitution("ْC3ُC3ُ","ُC3ُّ"));
        substitutions.add(new ExpressionInfixSubstitution("ْC3ُC3َ","ُC3َّ"));
        substitutions.add(new ExpressionInfixSubstitution("ْC3ُC3ِ","ُC3ِّ"));
        substitutions.add(new ExpressionSuffixSubstitution("ْC3ُC3ْ","ُC3َّ"));
        substitutions.add(new ExpressionInfixSubstitution("ْC3ِC3ُ","ِC3ُّ"));
        substitutions.add(new ExpressionInfixSubstitution("ْC3ِC3َ","ِC3َّ"));
        substitutions.add(new ExpressionInfixSubstitution("ْC3ِC3ِ","ِC3ِّ"));
        substitutions.add(new ExpressionSuffixSubstitution("ْC3ِC3ْ","ِC3َّ"));
        substitutions.add(new ExpressionInfixSubstitution("ْC3َC3ُ","َC3ُّ"));
        substitutions.add(new ExpressionInfixSubstitution("ْC3َC3َ","َC3َّ"));
        substitutions.add(new ExpressionInfixSubstitution("ْC3َC3ِ","َC3ِّ"));
        substitutions.add(new ExpressionSuffixSubstitution("ْC3َC3ْ","َC3َّ"));



    }

    public List getSubstitutions() {
        return substitutions;
    }

    @Override
    public boolean isApplied(ConjugationResult conjugationResult) {
        return false;
    }
}
