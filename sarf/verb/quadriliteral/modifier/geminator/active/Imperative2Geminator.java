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
public class Imperative2Geminator extends SubstitutionsApplier implements IQuadrilateralModifier {

    private List substitutions = new LinkedList();

    public Imperative2Geminator() {
        substitutions.add(new InfixSubstitution("äúäó", "äøó")); // EX: (ÃäÊä ÇØúãóÃúäöäøó)
        substitutions.add(new ExpressionSuffixSubstitution("C3úC4öC4ú", "C3öC4øó")); // EX: (ÇŞúÔóÚöÑøó)
        substitutions.add(new ExpressionInfixSubstitution("C3úC4öC4ó", "C3öC4øó")); // EX: (ÇŞúÔóÚöÑøóÇ)
        substitutions.add(new ExpressionInfixSubstitution("C3úC4öC4õ", "C3öC4øõ")); // EX: (ÇŞúÔóÚöÑøõæÇ)
        substitutions.add(new ExpressionInfixSubstitution("C3úC4öC4ö", "C3öC4øö")); // EX: (ÇŞúÔóÚöÑøöí)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        if (conjugationResult.getRoot().getC4() != 'ä') {
            return false;
        }
        return true;
    }
}
