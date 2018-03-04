package sarf.verb.quadriliteral.modifier.vocalizer.nakes.passive;

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
public class PastVocalizer extends SubstitutionsApplier implements IQuadrilateralModifier {

    private List substitutions = new LinkedList();

    public PastVocalizer() {
        substitutions.add(new InfixSubstitution("öíú","öí"));// EX: (ÃäÇ ŞõáúÓöíÊõ¡ ÊõŞõáúÓöíÊõ¡ ÇÓáõäúŞöíÊõ)
        substitutions.add(new InfixSubstitution("öíõ", "õ")); // EX: (åã ŞõáúÓõæÇ¡ ÊõŞõáúÓõæÇ¡ ÇÓúáõäúŞõæÇ)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        if (conjugationResult.getRoot().getC4() != 'í')
            return false;

        switch (conjugationResult.getFormulaNo()) {
        case 0:
        case 1:
        case 2:
            return true;
        }

        return false;
    }
}
