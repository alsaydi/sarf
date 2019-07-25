package sarf.noun.trilateral.augmented.modifier.substituter;

import java.util.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.noun.trilateral.augmented.modifier.AbstractGenericSubstituter;
import sarf.verb.trilateral.augmented.ConjugationResult;

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
public class GenericSubstituter5 extends AbstractGenericSubstituter {
    private final List<Substitution> substitutions = new ArrayList<>();

    public GenericSubstituter5() {
        substitutions.add(new InfixSubstitution("زْت","زْد"));// EX: (ازدِراد، )
    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        return conjugationResult.getRoot().getC1() == 'ز' && super.isApplied(conjugationResult);
    }
}
