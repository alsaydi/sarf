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
public class PassivePastAjwafWawiVocalizer extends AbstractAjwafWawiVocalizer {
    private List substitutions = new LinkedList();

    public PassivePastAjwafWawiVocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("õæöC3ú","öC3ú"));// EX: (ŞöãúÊõ¡ ÈöÆúÊõ¡ ÅöÈúÊõ)
        substitutions.add(new ExpressionInfixSubstitution("õæöC3ø","öC3ø"));// EX: (äÍä ÕöäøóÇ¡ åä Õöäøó¡ ÃäÇ İöÊøõ)
        substitutions.add(new ExpressionInfixSubstitution("õæöC3ó","öíC3ó"));// EX: (Şöíãó¡ ÈöíÁ¡ ÅíÈó)
        substitutions.add(new ExpressionInfixSubstitution("õæöC3õ","öíC3õ"));// EX: (ŞöíãæÇ¡ ÈöíÆæÇ¡ ÅíÈæÇ)
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
