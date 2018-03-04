package sarf.verb.trilateral.unaugmented.modifier.geminator.generic;

import sarf.verb.trilateral.Substitution.*;
import java.util.List;
import java.util.*;
import sarf.verb.trilateral.unaugmented.active.*;
import sarf.verb.trilateral.unaugmented.*;

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
public class ActivePastGeminator extends SubstitutionsApplier{

    private List substitutions = new LinkedList();

    public ActivePastGeminator() {
        substitutions.add(new ExpressionInfixSubstitution("C2óC3ó","C3øó"));
        substitutions.add(new ExpressionInfixSubstitution("C2óC3õ","C3øõ"));
        substitutions.add(new ExpressionInfixSubstitution("C2öC3ó","C3øó"));
        substitutions.add(new ExpressionInfixSubstitution("C2öC3õ","C3øõ"));
        substitutions.add(new ExpressionInfixSubstitution("C2õC3ó","C3øó"));
        substitutions.add(new ExpressionInfixSubstitution("C2õC3õ","C3øõ"));

    }

    public List getSubstitutions() {
        return substitutions;
    }
}
