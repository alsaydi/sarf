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
public class Present2Vocalizer extends SubstitutionsApplier implements IQuadrilateralModifier {

    private List substitutions = new LinkedList();

    public Present2Vocalizer() {
        substitutions.add(new SuffixSubstitution("íõ", "ì")); // EX: (íóÊóŞóáúÓóì)
        substitutions.add(new SuffixSubstitution("íó", "ì")); // EX: (áä íóÊóŞóáúÓóì)
        substitutions.add(new SuffixSubstitution("íú", "")); // EX: (áã íóÊóŞóáúÓó)
        substitutions.add(new InfixSubstitution("íöí", "íú")); // EX: (ÃäÊö ÊóÊóŞóáúÓóíúäó)
        substitutions.add(new InfixSubstitution("íõæ", "æú")); // EX: (ÃäÊã ÊóÊóŞóáúÓóæúäó)
        substitutions.add(new InfixSubstitution("íõä", "æõä")); // EX: (ÃäÊã ÊóÊóŞóáúÓóæõäøó)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        if (conjugationResult.getRoot().getC4() == 'í' && conjugationResult.getFormulaNo() == 1) {
            return true;
        }
        return false;
    }
}
