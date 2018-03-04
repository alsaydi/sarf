package sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.yaei;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.unaugmented.*;
import sarf.verb.trilateral.unaugmented.modifier.*;
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
public class ImperativeAjwafYaeiVocalizer extends AbstractAjwafYaeiVocalizer {
    private List substitutions = new LinkedList();

    public ImperativeAjwafYaeiVocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("ÇC1úíöC3õ", "C1öíC3õ")); // EX: (ÈöíÚõæÇ¡ ÈöíÚõäøó)
        substitutions.add(new ExpressionInfixSubstitution("ÇC1úíöC3ö", "C1öíC3ö")); // EX: (ÈíÚí¡ ÈíÚöäøó)
        substitutions.add(new ExpressionInfixSubstitution("ÇC1úíöC3ó", "C1öíC3ó")); // EX: (ÈíÚÇ¡ ÈíÚÇäøó)
        substitutions.add(new ExpressionInfixSubstitution("ÇC1úíöC3ú", "C1öC3ú")); // EX: (ÈöÚú¡ ÈöÚúäÇäøö)
        substitutions.add(new ExpressionInfixSubstitution("ÇC1úíöC3ø", "C1öC3ø")); // EX: (ÃäÊä áöäøó)
    }

    public List getSubstitutions() {
        return substitutions;
    }

}
