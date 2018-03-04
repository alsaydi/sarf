package sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.yaei;

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
public class ActivePastAjwafYaeiListedVocalizer extends AbstractAjwafYaeiListedVocalizer {
    private List substitutions = new LinkedList();

    public ActivePastAjwafYaeiListedVocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("óíöC3ú","öC3ú"));// EX: ( ÔöÆúÊõ)
        substitutions.add(new ExpressionInfixSubstitution("óíöC3ø","öC3ø"));// EX: ( ÈöÊøõ)
        substitutions.add(new ExpressionInfixSubstitution("óíöC3ó","óÇC3ó"));// EX: (ÔÇÁ¡ ÈÇÊ)
        substitutions.add(new ExpressionInfixSubstitution("óíöC3õ","óÇC3õ"));// EX: (ÔÇÄæÇ¡ ÈÇÊæÇ)
    }

    public List getSubstitutions() {
        return substitutions;
    }


}
