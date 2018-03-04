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
public class PresentVocalizer extends SubstitutionsApplier implements IQuadrilateralModifier {

    private List substitutions = new LinkedList();

    public PresentVocalizer() {
        substitutions.add(new SuffixSubstitution("íõ", "ì")); // EX: (íõŞóáúÓóì¡ íõÊóŞóáúÓóì¡ íõÓúáóäúŞóì)
        substitutions.add(new SuffixSubstitution("íó", "ì")); // EX: (áä íõŞóáúÓóì¡ íõÊóŞóáúÓóì¡ íõÓúáóäúŞóì)
        substitutions.add(new SuffixSubstitution("íú", "")); // EX: (áã íõŞóáúÓó¡ íõÊóŞóáúÓó¡ íõÓúáóäúŞó)
        substitutions.add(new InfixSubstitution("íöí", "íú")); // EX: (ÃäÊö ÊõŞóáúÓóíúäó¡ ÊõõÊóŞóáúÓóíúäó¡ ÊõÓúáóäúŞóíúäó)
        substitutions.add(new InfixSubstitution("íõæ", "æú")); // EX: (ÃäÊã ÊõŞóáúÓóæúäó¡ ÊõõÊóŞóáúÓóæúäó¡ ÊõÓúáóäúŞóæúäó)
        substitutions.add(new InfixSubstitution("íõä", "æõä")); // EX: (ÃäÊä ÊõŞóáúÓóæõäøó¡ ÊõõÊóŞóáúÓóæõäøó¡ ÊõÓúáóäúŞóæõäøó)
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
