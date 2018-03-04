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
public class ActivePresentAjwafWawiListedVocalizer extends AbstractAjwafWawiListedVocalizer {
    private List substitutions = new LinkedList();

    public ActivePresentAjwafWawiListedVocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("úæóC3õ","óÇC3õ"));
        substitutions.add(new ExpressionInfixSubstitution("úæóC3ö","óÇC3ö"));
        substitutions.add(new ExpressionInfixSubstitution("úæóC3ó","óÇC3ó"));
        substitutions.add(new ExpressionInfixSubstitution("úæóC3ú","óC3ú"));
    }

    public List getSubstitutions() {
        return substitutions;
    }


}
