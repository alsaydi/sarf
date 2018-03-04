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
public class ActivePastAjwafYaeiVocalizer extends AbstractAjwafYaeiVocalizer {
    private List substitutions = new LinkedList();

    public ActivePastAjwafYaeiVocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("óíóC3ú","öC3ú"));// EX: (ÈöÚúÊõ¡ ŞöÆÊõ¡ ÅöäúÊõ¡)
        substitutions.add(new ExpressionInfixSubstitution("óíóC3ø","öC3ø"));// EX: (äÍä áöäøóÇ¡ åä áöäøó¡ ÃäÇ áöÊøõ)
        substitutions.add(new ExpressionInfixSubstitution("óíóC3ó","óÇC3ó"));// EX: (ÈÇÚ¡ ŞÇÁ¡ Âä¡)
        substitutions.add(new ExpressionInfixSubstitution("óíóC3õ","óÇC3õ"));// EX: (ÈÇÚæÇ¡ ŞÇÄæÇ¡ ÂäæÇ¡)
    }

    /**
     *
     * @return List
     * @todo Implement this
     *   sarf.verb.trilateral.Substitution.SubstitutionsApplier method
     */
    public List getSubstitutions() {
        return substitutions;
    }

}
