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
public class PassivePastAjwafYaeiVocalizer extends AbstractAjwafYaeiVocalizer {
    private List substitutions = new LinkedList();

    public PassivePastAjwafYaeiVocalizer() {

        substitutions.add(new ExpressionInfixSubstitution("õíöC3ø","õC3ø"));// EX: ( ÈõÊøõ)
        substitutions.add(new ExpressionInfixSubstitution("õíöC3ú","õC3ú"));// EX: (ÈõÚúÊõ¡ ŞõÆÊõ¡ ÃõäúÊõ¡ ÔõÆúÊõ)
        substitutions.add(new ExpressionInfixSubstitution("õíöC3ø","õC3ø"));// EX: (äÍä áõäøóÇ¡ åä áõäøó¡ ÃäÇ áöÊøõ)
        substitutions.add(new ExpressionInfixSubstitution("õíöC3ó","öíC3ó"));// EX: (ÈöíÚ¡ ŞöíÁ¡ Åíä¡ ÔöíÁ¡ ÈöíÊ)
        substitutions.add(new ExpressionInfixSubstitution("õíöC3õ","öíC3õ"));// EX: (ÈöíÚæÇ¡ ŞöíÆæÇ¡ ÅíäæÇ¡ ÔöíÆæÇ¡ ÈöíÊæÇ)

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
