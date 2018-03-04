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
public class GenericSubstituter3 extends AbstractGenericSubstituter {
    private List substitutions = new LinkedList();

    public GenericSubstituter3() {

        substitutions.add(new InfixSubstitution("ØúÊ", "Øø")); // EX: (ÇØøöáÇÈ¡ )
    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        return conjugationResult.getRoot().getC1() == 'Ø' && super.isApplied(conjugationResult);
    }
}
