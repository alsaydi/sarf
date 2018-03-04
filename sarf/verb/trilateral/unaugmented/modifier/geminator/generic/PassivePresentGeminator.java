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
public class PassivePresentGeminator extends SubstitutionsApplier {

    private List substitutions = new LinkedList();

    public PassivePresentGeminator() {
        substitutions.add(new ExpressionInfixSubstitution("úC3óC3õ", "óC3øõ"));
        substitutions.add(new ExpressionInfixSubstitution("úC3óC3ó", "óC3øó"));
        substitutions.add(new ExpressionInfixSubstitution("úC3óC3ö", "óC3øö"));
        substitutions.add(new ExpressionSuffixSubstitution("úC3óC3ú", "óC3øó"));

    }

    public List getSubstitutions() {
        return substitutions;
    }
}
