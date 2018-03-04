package sarf.noun.trilateral.unaugmented.modifier.assimilate;

import java.util.*;

import sarf.noun.trilateral.unaugmented.modifier.*;
import sarf.verb.trilateral.Substitution.*;

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
        substitutions.add(new ExpressionInfixSubstitution("úC3óC3","óC3ø"));// EX: (ÃÕóãø)
        substitutions.add(new ExpressionInfixSubstitution("óC3úC3","óC3ø"));// EX: (ÕóãøóÇÁ¡ ÑóíøóÇä¡ ÑóËøñ)
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
