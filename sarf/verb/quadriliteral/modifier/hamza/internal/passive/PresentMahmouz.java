package sarf.verb.quadriliteral.modifier.hamza.internal.passive;

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
        substitutions.add(new InfixSubstitution("óÁú", "óÃú")); // EX: (íõÈóÃúÏóáõ¡ íõÊóËóÃúáóáõ)
        substitutions.add(new InfixSubstitution("óÁó", "óÃó")); // EX: (íõØúãóÃóäøõ)
        substitutions.add(new InfixSubstitution("úÁó", "úÃó")); // EX: (íõØóãúÃóäõ¡ íõÊóØóãúÃóäõ¡ íõÊóãóÑúÃóì)

    }


    public List getSubstitutions() {
        return substitutions;
    }
}
