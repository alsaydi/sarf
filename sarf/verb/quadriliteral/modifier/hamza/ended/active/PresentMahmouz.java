package sarf.verb.quadriliteral.modifier.hamza.ended.active;

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
        substitutions.add(new InfixSubstitution("öÁ", "öÆ")); // EX: (íõÛóÑúŞöÆõ¡ íóÍúÈóäúØöÆõ)
        substitutions.add(new InfixSubstitution("Áö", "Æö")); // EX: (ÃäÊö ÊóÊóÏóÑúÈóÆöíäó¡ )
        substitutions.add(new SuffixSubstitution("óÁõ", "óÃõ")); // EX: (íóÊóÏóÑúÈóÃõ¡ )
        substitutions.add(new InfixSubstitution("óÁó", "óÃó")); // EX: (ÃäÊãÇ ÊóÊóÏóÑúÈóÃóÇäö¡ )
        substitutions.add(new InfixSubstitution("óÁú", "óÃú")); // EX: (ÃäÊä ÊóÊóÏóÑúÈóÃúäó¡ )
        substitutions.add(new InfixSubstitution("óÁõ", "óÄõ")); // EX: (ÃäÊã ÊóÊóÏóÑúÈóÄõæäó¡ )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
