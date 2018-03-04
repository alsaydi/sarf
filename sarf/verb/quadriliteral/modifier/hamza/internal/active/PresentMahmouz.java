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
public class PresentMahmouz extends SubstitutionsApplier {

    private List substitutions = new LinkedList();

    public PresentMahmouz() {
        substitutions.add(new InfixSubstitution("óÁú", "óÃú")); // EX: (íõÈóÃúÏöáõ¡ íóÊóËóÃúáóáõ¡ ÃäÊä ÊóØúãóÃúäöäøó)
        substitutions.add(new InfixSubstitution("úÁó", "úÃó")); // EX: (íóÊóØóãúÃóäõ¡ íóÊóãóÑúÃóì¡ )
        substitutions.add(new InfixSubstitution("Áö", "Æö")); // EX: (íõØóãúÆöäõ¡ íóØúãóÆöäøõ)
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
