package sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.wawi;

import sarf.verb.trilateral.unaugmented.modifier.vocalizer.ListedVocalizer;
import java.util.List;
import java.util.LinkedList;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description:İÍÕ ÇáÃÌæİ ÍÓÈ ŞÇÆãÉ    </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class PassivePresentAjwafWawiListedVocalizer extends AbstractAjwafWawiListedVocalizer {
    private List substitutions = new LinkedList();

    public PassivePresentAjwafWawiListedVocalizer() {
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
