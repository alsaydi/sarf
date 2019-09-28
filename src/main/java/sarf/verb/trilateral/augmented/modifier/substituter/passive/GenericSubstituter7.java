package sarf.verb.trilateral.augmented.modifier.substituter.passive;

import java.util.*;
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
public class GenericSubstituter7 extends AbstractGenericSubstituter {
    private final List<Substitution> substitutions = new ArrayList<>();

    public GenericSubstituter7() {

        substitutions.add(new InfixSubstitution("ضْت", "ضْط")); // EX: (اضْطُلِعَ)
    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        return triAugmentedConjugationResult.getRoot().getC1() == 'ض' && super.isApplied(triAugmentedConjugationResult);
    }
}
