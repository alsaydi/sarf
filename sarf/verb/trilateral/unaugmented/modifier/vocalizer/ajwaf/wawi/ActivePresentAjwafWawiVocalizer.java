package sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.wawi;

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
public class ActivePresentAjwafWawiVocalizer extends AbstractAjwafWawiVocalizer {
    private List substitutions = new LinkedList();

    public ActivePresentAjwafWawiVocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("úæõC3õ", "õæC3õ")); // EX: (íóŞõæãõ¡ íÈæÁ¡ íÄæÈ)
        substitutions.add(new ExpressionInfixSubstitution("úæõC3ö", "õæC3ö")); // EX: (ÊŞæãíä¡ áä ÊŞæãöí¡ ÊÈæÆíä¡ ÊÄæÈíä)
        substitutions.add(new ExpressionInfixSubstitution("úæõC3ó", "õæC3ó")); // EX: (ÊŞæãÇä¡ áä íŞæãó¡ ÊÈæÁÇä¡ ÊÄæÈÇä)
        substitutions.add(new ExpressionInfixSubstitution("úæõC3ú", "õC3ú")); // EX: (ÊóŞõãúäó¡ áã íóŞõãú¡ íóÈõÄú¡ íóÄõÈú)
        substitutions.add(new ExpressionInfixSubstitution("úæõC3ø", "õC3ø")); // EX: (ÃäÊä ÊóÕõäøó¡ åäø Õõäøó)
    }

    public List getSubstitutions() {
        return substitutions;
    }

}
