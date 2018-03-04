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
public class Present2Geminator extends SubstitutionsApplier implements IQuadrilateralModifier {

    private List substitutions = new LinkedList();

    public Present2Geminator() {
        substitutions.add(new InfixSubstitution("äúäó", "äøó")); // EX: (ÃäÊä ÊóØúãóÃúäöäøó¡ åäøó íóØúãóÃúäöäøó)
        substitutions.add(new ExpressionInfixSubstitution("úC4öC4õ", "öC4øõ")); // EX: (åæ íóŞúÔóÚöÑøõ)
        substitutions.add(new ExpressionInfixSubstitution("úC4öC4ó", "öC4øó")); // EX: (åãÇ íóŞúÔóÚöÑøóÇäö)
        substitutions.add(new ExpressionInfixSubstitution("úC4öC4ö", "öC4øö")); // EX: (ÃäÊö ÊóŞúÔóÚöÑøöíäó)
        substitutions.add(new ExpressionSuffixSubstitution("úC4öC4ú", "öC4øó")); // EX: (áã íóŞúÔóÚöÑøó)

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
