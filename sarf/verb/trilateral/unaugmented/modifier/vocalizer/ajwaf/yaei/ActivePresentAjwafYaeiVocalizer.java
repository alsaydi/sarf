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
public class ActivePresentAjwafYaeiVocalizer extends AbstractAjwafYaeiVocalizer {
    private List substitutions = new LinkedList();

    public ActivePresentAjwafYaeiVocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("úíöC3õ", "öíC3õ")); // EX: (íÈíÚ¡ íŞíÁ¡ íÆíä)
        substitutions.add(new ExpressionInfixSubstitution("úíöC3ö", "öíC3ö")); // EX: (ÊÈíÚíä¡ áä ÊÈíÚí¡ ÊŞíÆíä¡ ÊÆíäíä)
        substitutions.add(new ExpressionInfixSubstitution("úíöC3ó", "öíC3ó")); // EX: (ÊÈíÚÇä¡ áä íÈíÚÇ¡ ÊŞíÆÇä¡ ÊÆíäÇä)
        substitutions.add(new ExpressionInfixSubstitution("úíöC3ú", "öC3ú")); // EX: (ÊóÈöÚúäó¡ áã íóÈöÚú¡ íóŞöÆú¡ íóÆöäú)
        substitutions.add(new ExpressionInfixSubstitution("úíöC3ø", "öC3ø")); // EX: (ÃäÊä Êóáöäøó ¡ åä íóáöäøó)
    }

    public List getSubstitutions() {
        return substitutions;
    }

}
