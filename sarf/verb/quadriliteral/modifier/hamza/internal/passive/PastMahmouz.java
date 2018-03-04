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
public class PastMahmouz extends SubstitutionsApplier {

    private List substitutions = new LinkedList();

    public PastMahmouz() {
        substitutions.add(new InfixSubstitution("Áö", "Æö")); // EX: (ØõãúÆöäó¡ ÊõØõãúÆöäó¡ ÊõãõÑúÆöíó¡ ÇØúãõÆöäøó)
        substitutions.add(new InfixSubstitution("õÁú", "õÄú")); // EX: (ÈõÄúÏöáó¡ ÊõËõÄúáöáó¡ ÇØúãõÄúäöäúÊõ)
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
