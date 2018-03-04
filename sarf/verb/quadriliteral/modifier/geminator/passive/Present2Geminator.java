package sarf.verb.quadriliteral.modifier.geminator.passive;

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
        substitutions.add(new InfixSubstitution("äúäó", "äøó")); // EX: (ÃäÊä ÊõØúãóÃúäóäøó¡ åäøó íõØúãóÃúäóäøó)
        substitutions.add(new ExpressionInfixSubstitution("úC4óC4õ", "óC4øõ")); // EX: (åæ íõŞúÔóÚóÑøõ)
        substitutions.add(new ExpressionInfixSubstitution("úC4óC4ó", "óC4øó")); // EX: (åãÇ íõŞúÔóÚóÑøóÇäö)
        substitutions.add(new ExpressionInfixSubstitution("úC4óC4ö", "óC4øö")); // EX: (ÃäÊö ÊõŞúÔóÚóÑøöíäó)
        substitutions.add(new ExpressionSuffixSubstitution("úC4óC4ú", "óC4øó")); // EX: (áã íõŞúÔóÚóÑøó)
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
