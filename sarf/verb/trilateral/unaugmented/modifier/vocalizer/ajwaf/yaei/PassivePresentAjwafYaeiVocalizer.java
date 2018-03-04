package sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.yaei;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.unaugmented.modifier.*;
import sarf.verb.trilateral.unaugmented.ConjugationResult;
import sarf.verb.trilateral.unaugmented.modifier.vocalizer.*;
import sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.*;

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
public class PassivePresentAjwafYaeiVocalizer extends AbstractAjwafYaeiVocalizer {
    private List substitutions = new LinkedList();

    public PassivePresentAjwafYaeiVocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("úíóC3õ", "óÇC3õ")); // EX: (íõÈÇÚ¡ íõÈÇÊ¡ áä ÊõÈÇÊæÇ)
        substitutions.add(new ExpressionInfixSubstitution("úíóC3ö", "óÇC3ö")); // EX: (ÊõÈÇÚöíäó¡ ÊõÈÇÊíä¡ áä ÊõÈÇÊí )
        substitutions.add(new ExpressionInfixSubstitution("úíóC3ó", "óÇC3ó")); // EX: (ÊõÈÇÚÇä¡ ÊõÈÇÊÇä¡ áä íõÈÇÊó¡ íõÈÇÊóäøó)
        substitutions.add(new ExpressionInfixSubstitution("úíóC3ú", "óC3ú")); // EX: (íõÈóÚúäó¡ íõÈóÊúäó¡ áã ÊõÈóÊú)
        substitutions.add(new ExpressionInfixSubstitution("úíóC3ø", "óC3ø")); // EX: (ÃäÊä Êõáóäøó¡ åä íõáóäøó)
    }

    public List getSubstitutions() {
        return substitutions;
    }

}
