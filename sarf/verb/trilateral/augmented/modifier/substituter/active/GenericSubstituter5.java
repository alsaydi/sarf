package sarf.verb.trilateral.augmented.modifier.substituter.active;

import java.util.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.substituter.*;
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
    private List substitutions = new LinkedList();

    public GenericSubstituter5() {
        substitutions.add(new InfixSubstitution("ÒúÊó","ÒúÏó"));// EX: (ÇÒúÏóÑóÏó¡ íóÒúÏóÑöÏõ¡ ÇÒúÏóÑöÏú)
    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        return conjugationResult.getRoot().getC1() == 'Ò' && super.isApplied(conjugationResult);
    }
}
