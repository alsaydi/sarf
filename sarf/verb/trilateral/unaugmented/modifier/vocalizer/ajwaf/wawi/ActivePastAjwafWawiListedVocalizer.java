package sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.wawi;

import java.util.*;
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
public class ActivePastAjwafWawiListedVocalizer extends AbstractAjwafWawiListedVocalizer {
    private List substitutions = new LinkedList();

    public ActivePastAjwafWawiListedVocalizer() {

        substitutions.add(new ExpressionInfixSubstitution("óæöC3ú","öC3ú"));// EX: ( ÈöåúÊõ¡ ÏöÆúÊõ)
        substitutions.add(new ExpressionInfixSubstitution("óæöC3ø","öC3ø"));// EX: ( ÕöÊøõ)
        substitutions.add(new ExpressionInfixSubstitution("óæöC3ó","óÇC3ó"));// EX: ( ÈÇå¡ ÏÇÁ)
        substitutions.add(new ExpressionInfixSubstitution("óæöC3õ","óÇC3õ"));// EX: ( ÈÇåæÇ¡ ÏÇÄæÇ)

    }

    public List getSubstitutions() {
        return substitutions;
    }
}
