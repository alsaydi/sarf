package sarf.verb.quadriliteral.modifier.hamza.internal.active;

import java.util.*;

import sarf.verb.quadriliteral.substitution.*;

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
public class ImperativeMahmouz extends SubstitutionsApplier {

    private List substitutions = new LinkedList();

    public ImperativeMahmouz() {
        substitutions.add(new InfixSubstitution("óÁú", "óÃú")); // EX: (ÈóÃúÏöáú¡ ÊóËóÃúáóáú¡ ÃäÊä ÇØúãóÃúäöäøó)
        substitutions.add(new InfixSubstitution("úÁó", "úÃó")); // EX: (ÊóØóãúÃóäú¡ ÊóãóÑúÃó)
        substitutions.add(new InfixSubstitution("Áö", "Æö")); // EX: (ØóãúÆöäú¡ ÇØúãóÆöäøõæÇ)
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
