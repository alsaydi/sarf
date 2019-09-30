package sarf.gerund.modifier.trilateral.augmented.standard.geminator;

import sarf.noun.TrilateralNounSubstitutionApplier;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.ConjugationResult;


import java.util.LinkedList;
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
public class Geminator0 extends TrilateralNounSubstitutionApplier{

    private final List<Substitution> substitutions = new LinkedList<>();

    public Geminator0() {
        substitutions.add(new InfixSubstitution("ْيِييَ", "ِيَّ"));// EX: (تحيَّة)
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        return triAugmentedConjugationResult.getFormulaNo() == 2
                && triAugmentedConjugationResult.getRoot().getC2() == 'ي'
                && triAugmentedConjugationResult.getRoot().getC3() == 'ي';
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
