package sarf.noun.trilateral.augmented.modifier.substituter;

import java.util.*;

import sarf.verb.trilateral.Substitution.Substitution;
import sarf.ConjugationResult;
import sarf.noun.trilateral.augmented.modifier.AbstractGenericSubstituter;
import sarf.verb.trilateral.Substitution.InfixSubstitution;

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
public class GenericSubstituter1 extends AbstractGenericSubstituter {
    private final List<Substitution> substitutions = new ArrayList<>();

    public GenericSubstituter1() {
        substitutions.add(new InfixSubstitution("ثْت","ثّ"));// EX: (اثِّمادٌ،)
    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        return triAugmentedConjugationResult.getRoot().getC1() == 'ث' && super.isApplied(triAugmentedConjugationResult);
    }
}
