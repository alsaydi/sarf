package sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.wawi;

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
public class ImperativeAjwafWawiVocalizer extends AbstractAjwafWawiVocalizer {
    private List substitutions = new LinkedList();

    public ImperativeAjwafWawiVocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("ÇC1úæõC3õ","C1õæC3õ"));// EX: (ŞõæãõæÇ¡ Şõæãõäøó¡ ÈæÁæÇ¡ ÃæÈæÇ)
        substitutions.add(new ExpressionInfixSubstitution("ÇC1úæõC3ö","C1õæC3ö"));// EX: (Şæãöí¡ Şæãöäøó¡ ÈæÆí¡ ÃæÈí)
        substitutions.add(new ExpressionInfixSubstitution("ÇC1úæõC3ó","C1õæC3ó"));// EX: (ŞæãÇ¡ Şæãóäøó¡ ÈæÁÇ¡ ÃæÈÇ)
        substitutions.add(new ExpressionInfixSubstitution("ÇC1úæõC3ú","C1õC3ú"));// EX: (Şõãú¡ ŞõãúäóÇäøö¡ ÈõÄú¡ ÃõÈú)
        substitutions.add(new ExpressionInfixSubstitution("ÇC1úæõC3ø","C1õC3ø"));// EX: (ÃäÊä Õõäøó)
    }

    public List getSubstitutions() {
        return substitutions;
    }

}
