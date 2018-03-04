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
public class PassivePastAjwafWawiListedVocalizer extends AbstractAjwafWawiListedVocalizer {
    private List substitutions = new LinkedList();

    public PassivePastAjwafWawiListedVocalizer() {

        substitutions.add(new ExpressionInfixSubstitution("õæöC3ú","õC3ú"));// EX: ( ÈõåúÊõ¡ ÏõÆúÊõ)
        substitutions.add(new ExpressionInfixSubstitution("õæöC3ó","öíC3ó"));// EX: (Èöíå¡ ÏöíÁ)
        substitutions.add(new ExpressionInfixSubstitution("õæöC3õ","öíC3õ"));// EX: (ÈöíåæÇ¡ ÏöíÆæÇ)


    }

    public List getSubstitutions() {
        return substitutions;
    }
}
