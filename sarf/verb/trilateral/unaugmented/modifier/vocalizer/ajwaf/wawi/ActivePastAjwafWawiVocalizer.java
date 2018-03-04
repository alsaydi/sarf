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
public class ActivePastAjwafWawiVocalizer extends AbstractAjwafWawiVocalizer {
    private List substitutions = new LinkedList();

    public ActivePastAjwafWawiVocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("óæóC3ú", "õC3ú")); // EX: (ŞõãúÊõ¡ ÈõÄúÊõ¡ ÃõÈúÊõ)
        substitutions.add(new ExpressionInfixSubstitution("óæóC3ø", "õC3ø")); // EX: (äÍä ÕõäøóÇ¡ åäø Õõäøó¡ ÃäÇ İõÊøõ)
        substitutions.add(new ExpressionInfixSubstitution("óæóC3ó", "óÇC3ó")); // EX: (ŞÇã¡ ÈÇÁ¡ ÂÈ)
        substitutions.add(new ExpressionInfixSubstitution("óæóC3õ", "óÇC3õ")); // EX: (ŞÇãæÇ¡ ÈÇÄæÇ¡ ÂÈæÇ)
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
