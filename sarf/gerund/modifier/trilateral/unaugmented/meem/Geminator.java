package sarf.gerund.modifier.trilateral.unaugmented.meem;

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
        substitutions.add(new ExpressionInfixSubstitution("ъC3уC3", "уC3ш")); // EX: (гу—уѕш° )
        substitutions.add(new ExpressionInfixSubstitution("ъC3цC3", "уC3ш")); // EX: (гужуѕш° )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
