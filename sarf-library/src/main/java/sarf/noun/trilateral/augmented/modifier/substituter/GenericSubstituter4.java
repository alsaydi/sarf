package sarf.noun.trilateral.augmented.modifier.substituter;

import sarf.ConjugationResult;
import sarf.noun.trilateral.augmented.modifier.AbstractGenericSubstituter;
import sarf.substitution.InfixSubstitution;
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
public class GenericSubstituter4 extends AbstractGenericSubstituter {
    private final List<Substitution> substitutions = new ArrayList<>();

    public GenericSubstituter4() {

        substitutions.add(new InfixSubstitution("ذْت", "ذْد")); // EX: (اذْدِكار،)
    }

    @Override
    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    @Override
    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        return triAugmentedConjugationResult.getRoot().getC1() == 'ذ' && super.isApplied(triAugmentedConjugationResult);
    }
}
