package sarf.verb.trilateral.augmented.modifier.geminator.generic;

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
public class ActivePastGeminator extends SubstitutionsApplier {

    private List substitutions = new LinkedList();

    public ActivePastGeminator() {
        substitutions.add(new ExpressionInfixSubstitution("úC3óC3ó","óC3øó"));// EX: (ÃóãóÏøó¡)
        substitutions.add(new ExpressionInfixSubstitution("úC3óC3õ","óC3øõ"));// EX: (ÃóãóÏøõæÇ¡)
        substitutions.add(new ExpressionInfixSubstitution("ÇC3óC3ó","ÇC3øó"));// EX: (ÍÇÌøó¡ ÇÍãÇÑøó)
        substitutions.add(new ExpressionInfixSubstitution("ÇC3óC3õ","ÇC3øõ"));// EX: (ÍÇÌøõæÇ¡ ÇÍãÇÑøõæÇ)
        substitutions.add(new ExpressionInfixSubstitution("óC3óC3ó","óC3øó"));// EX: (ÇÍãÑøó)
        substitutions.add(new ExpressionInfixSubstitution("óC3óC3õ","óC3øõ"));// EX: (ÇÍãÑøõæÇ)
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
