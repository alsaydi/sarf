package sarf.verb.trilateral.unaugmented.modifier.hamza.faa;

import java.util.*;
import sarf.verb.trilateral.unaugmented.modifier.hamza.*;
import sarf.verb.trilateral.Substitution.*;

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
public class ImperativeMahmouz extends AbstractFaaMahmouz {
    private List substitutions = new ArrayList();

    public ImperativeMahmouz() {
        substitutions.add(new ExpressionInfixSubstitution("ÇÁúC2ó", "ÇÆúC2ó")); // EX: (ÇÆúÈóå)
        substitutions.add(new ExpressionInfixSubstitution("ÇÁúC2ö", "ÇÆúC2ö")); // EX: (ÇÆúÓöÑ)
        substitutions.add(new ExpressionInfixSubstitution("ÇÁúC2õ", "ÇÄúC2õ")); // EX: (ÇÄúäõË)
        substitutions.add(new ExpressionInfixSubstitution("ÁõC3","ÃõC3"));// EX: (ÃõÈú)
        substitutions.add(new PrefixSubstitution("Áö", "Åö")); // EX: (ÃäÊó Åöäøó¡ Åãú)
        substitutions.add(new PrefixSubstitution("Áõ","Ãõ"));// EX: (ÃäÊö Ãõæáí)
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
