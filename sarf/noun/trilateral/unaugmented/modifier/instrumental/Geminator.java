package sarf.noun.trilateral.unaugmented.modifier.instrumental;

import java.util.*;

import sarf.noun.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.noun.trilateral.unaugmented.modifier.IUnaugmentedTrilateralNounModificationApplier;
import sarf.noun.trilateral.unaugmented.modifier.*;

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
public class Geminator extends AbstractGeminator {
    List substitutions = new LinkedList();

    public Geminator() {
        substitutions.add(new ExpressionInfixSubstitution("úC3óC3","óC3ø"));// EX: (ãöÌóäø)
        substitutions.add(new ExpressionInfixSubstitution("úC3õC3","õC3ø"));// EX: (ãõÏõŞø)
        substitutions.add(new ExpressionInfixSubstitution("óC3úC3","óC3ø"));// EX: (ÏóİøóÉ)
        substitutions.add(new ExpressionInfixSubstitution("õC3úC3","õC3ø"));// EX: (ÌõÑøóÉ)
        substitutions.add(new ExpressionInfixSubstitution("öC3úC3","öC3ø"));// EX: (ÓößøóÉ)
        substitutions.add(new ExpressionInfixSubstitution("ÇC3öC3","ÇC3ø"));// EX: (ãóÇÕøóÉ)
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
