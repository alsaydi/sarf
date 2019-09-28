package sarf.verb.trilateral.augmented.modifier.substituter.passive;

import java.util.*;

import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;

import sarf.ConjugationResult;
import sarf.verb.trilateral.augmented.modifier.substituter.*;

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
        substitutions.add(new InfixSubstitution("ذْت","ذْد"));// EX: (اذْدُكِرَ)
    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        return triAugmentedConjugationResult.getRoot().getC1() == 'ذ' && super.isApplied(triAugmentedConjugationResult);
    }
}
