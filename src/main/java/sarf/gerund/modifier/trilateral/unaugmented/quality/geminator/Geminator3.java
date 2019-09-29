package sarf.gerund.modifier.trilateral.unaugmented.quality.geminator;

import sarf.ConjugationResult;
import sarf.noun.TrilateralNounSubstitutionApplier;
import sarf.substitution.ExpressionInfixSubstitution;
import sarf.substitution.Substitution;

import java.util.ArrayList;
import java.util.List;

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
public class Geminator3 extends TrilateralNounSubstitutionApplier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Geminator3() {
        substitutions.add(new ExpressionInfixSubstitution("ِC3ْC3َ", "ِC3َّ"));// EX: (مِدَّة، حِيَّة)
    }

    @Override
    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    @Override
    public boolean isApplied(ConjugationResult conjugationResult) {
        return conjugationResult.getRoot().getC2() == conjugationResult.getRoot().getC3();
    }
}
