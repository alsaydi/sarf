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
public class PassivePresentAjwafWawiVocalizer extends AbstractAjwafWawiVocalizer {
    private List substitutions = new LinkedList();

    public PassivePresentAjwafWawiVocalizer() {
        //äİÓ ÇáŞÇÆãÉ İí listed

        substitutions.add(new ExpressionInfixSubstitution("úæóC3õ","óÇC3õ"));// EX: (íõŞÇã¡ íõÎÇİ¡ áä ÊõÎÇİõæÇ¡ íõÏÇÁ)
        substitutions.add(new ExpressionInfixSubstitution("úæóC3ö","óÇC3ö"));// EX: (ÊõŞÇãíä¡ ÊõÎÇİíä¡ áä ÊõÎÇİí¡ )
        substitutions.add(new ExpressionInfixSubstitution("úæóC3ó","óÇC3ó"));// EX: (ÊõŞÇãÇä¡ ÊõÎÇİÇä¡ áä íõÎÇİó¡ íõÎÇİóäøó)
        substitutions.add(new ExpressionInfixSubstitution("úæóC3ú","óC3ú"));// EX: (ÊõŞóãúäó¡ ÊõÎóİúäó¡ áã ÊõÎóİú)
        substitutions.add(new ExpressionInfixSubstitution("úæóC3ø","óC3ø"));// EX: (ÃäÊä ÊõÕóäøó¡ åä íõÕóäøó)

    }

    public List getSubstitutions() {
        return substitutions;
    }

}
