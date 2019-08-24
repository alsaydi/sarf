package sarf.gerund.modifier.trilateral.augmented.standard.geminator;

import sarf.noun.TrilateralNounSubstitutionApplier;
import sarf.verb.trilateral.Substitution.InfixSubstitution;
import sarf.verb.trilateral.Substitution.Substitution;
import sarf.verb.trilateral.augmented.ConjugationResult;
import sarf.verb.trilateral.augmented.modifier.IAugmentedTrilateralModifier;

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
public class Geminator0 extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {

    private final List<Substitution> substitutions = new LinkedList<>();

    public Geminator0() {
        substitutions.add(new InfixSubstitution("ْيِييَ", "ِيَّ"));// EX: (تحيَّة)
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        return conjugationResult.getFormulaNo() == 2
                && conjugationResult.getRoot().getC2() == 'ي'
                && conjugationResult.getRoot().getC3() == 'ي';
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
