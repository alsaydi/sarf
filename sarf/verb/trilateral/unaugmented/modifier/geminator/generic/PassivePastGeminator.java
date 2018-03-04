package sarf.verb.trilateral.unaugmented.modifier.geminator.generic;

import java.util.*;

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
public class PassivePastGeminator extends SubstitutionsApplier {

    private List substitutions = new LinkedList();

    public PassivePastGeminator() {
        substitutions.add(new ExpressionInfixSubstitution("C3öC3ó", "C3øó"));
        substitutions.add(new ExpressionInfixSubstitution("C3öC3õ", "C3øõ"));
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
