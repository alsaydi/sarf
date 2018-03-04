package sarf.noun.trilateral.augmented.modifier.substituter;

import java.util.*;
import sarf.verb.trilateral.augmented.ConjugationResult;
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
    private List substitutions = new LinkedList();

    public GenericSubstituter1() {
        substitutions.add(new InfixSubstitution("ËúÊ","Ëø"));// EX: (ÇËøöãÇÏñ¡)
    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        return conjugationResult.getRoot().getC1() == 'Ë' && super.isApplied(conjugationResult);
    }
}
