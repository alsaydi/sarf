package sarf.noun.quadriliteral.modifier.activeparticiple;

import java.util.*;

import sarf.noun.*;
import sarf.substitution.ExpressionInfixSubstitution;
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
public final class Geminator extends QuadrilateralNounSubstitutionApplier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Geminator() {
        substitutions.add(new ExpressionInfixSubstitution("ْC4ِC4","ِC4ّ"));// EX: (هو مُقْشَعِرٌّ)
    }

    @Override
    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    @Override
    public boolean isApplied(ConjugationResult conjugationResult) {
        return conjugationResult.getFormulaNo() == 3;
    }
}
