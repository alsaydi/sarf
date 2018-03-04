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
public class PastMahmouz extends SubstitutionsApplier {

    private List substitutions = new LinkedList();

    public PastMahmouz() {
        substitutions.add(new InfixSubstitution("óÁú", "óÃú")); // EX: (ÈóÃúÏóáó¡ ÊóËóÃúáóáó)
        substitutions.add(new InfixSubstitution("úÁó", "úÃó")); // EX: (ØóãúÃóäó¡ ÊóØóãúÃóäó¡ ÊóãóÑúÃóì¡ ÇÔÑóÃúÈóÈúÊõ)
        substitutions.add(new InfixSubstitution("óÁó", "óÃó")); // EX: (ÇØúãóÃóäøó)
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
