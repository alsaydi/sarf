package sarf.verb.trilateral.augmented.modifier.substituter.active;

import java.util.*;

import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.verb.trilateral.Substitution.*;
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
public class GenericSubstituter1 extends AbstractGenericSubstituter {
    private final List<Substitution> substitutions = new LinkedList<>();

    public GenericSubstituter1() {
        substitutions.add(new InfixSubstitution("ثْتَ","ثَّ"));// EX: (اثَّمَدَ، يَثَّمِدُ، اثَّمِدْ)
    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        return triAugmentedConjugationResult.getRoot().getC1() == 'ث' && super.isApplied(triAugmentedConjugationResult);
    }
}
