package sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.wawi;

import sarf.verb.trilateral.unaugmented.modifier.vocalizer.ListedVocalizer;
import java.util.List;
import java.util.LinkedList;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.AbstractAjwafWawiListedVocalizer;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description:ÝÍÕ ÇáÃÌæÝ ÍÓÈ ÞÇÆãÉ    </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class ImperativeAjwafWawiListedVocalizer extends AbstractAjwafWawiListedVocalizer {
    private List substitutions = new LinkedList();

    public ImperativeAjwafWawiListedVocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("ÇC1úæóC3õ", "C1óÇC3õ"));
        substitutions.add(new ExpressionInfixSubstitution("ÇC1úæóC3ö", "C1óÇC3ö"));
        substitutions.add(new ExpressionInfixSubstitution("ÇC1úæóC3ó", "C1óÇC3ó"));
        substitutions.add(new ExpressionInfixSubstitution("ÇC1úæóC3ú", "C1óC3ú"));

    }

    public List getSubstitutions() {
        return substitutions;
    }
}
