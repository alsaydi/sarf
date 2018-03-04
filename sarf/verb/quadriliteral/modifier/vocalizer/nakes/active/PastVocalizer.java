package sarf.verb.quadriliteral.modifier.vocalizer.nakes.active;

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
        substitutions.add(new SuffixSubstitution("íó","ì"));// EX: (åæ ŞóáúÓóì¡ ÊóŞóáúÓóì¡ ÇÓáäŞóì)
        substitutions.add(new InfixSubstitution("íõæ", "æú")); // EX: (åã ŞóáúÓóæúÇ¡ ÊóŞóáúÓóæúÇ¡ ÇÓúáóäúŞóæúÇ)
        substitutions.add(new InfixSubstitution("íóÊ", "Ê")); // EX: (åí ŞóáúÓóÊú¡ ÊóŞóáúÓóÊú¡ ÇÓúáóäúŞóÊú)
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
