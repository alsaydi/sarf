package sarf.verb.quadriliteral.modifier.geminator.active;

import java.util.*;
import sarf.verb.quadriliteral.substitution.*;
import sarf.verb.quadriliteral.modifier.*;
import sarf.verb.quadriliteral.*;

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
public class Past3Geminator extends SubstitutionsApplier implements IQuadrilateralModifier {

    private List substitutions = new LinkedList();

    public Past3Geminator() {
        substitutions.add(new InfixSubstitution("äúäó","äøó"));// EX: (äÍä ØóãúÃäøóÇ¡ åäøó ØóãúÃäøó)
        substitutions.add(new ExpressionInfixSubstitution("úC4óC4ó","óC4øó"));// EX: (ÇÒíÃäó)
        substitutions.add(new ExpressionInfixSubstitution("úC4óC4õ","óC4øõ"));// EX: (ÇÒíÃäóæÇ)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        if (conjugationResult.getRoot().getC4() != 'ä')
            return false;
        return true;
    }
}
