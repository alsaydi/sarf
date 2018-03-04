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
public class Past2Geminator extends SubstitutionsApplier implements IQuadrilateralModifier {

    private List substitutions = new LinkedList();

    public Past2Geminator() {
        substitutions.add(new InfixSubstitution("ÊúÊõ", "Êøõ")); // EX: (ÃäÇ ßóÈúÑóÊøõ)
        substitutions.add(new InfixSubstitution("ÊúÊó", "Êøó")); // EX: (ÃäÊó ßóÈúÑóÊøó)
        substitutions.add(new InfixSubstitution("ÊúÊö", "Êøö")); // EX: (ÃäÊö ßóÈúÑóÊøö)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        if (conjugationResult.getRoot().getC4() != 'Ê')
            return false;
        return true;
    }
}
