package sarf.verb.quadriliteral.modifier.hamza.ended.passive;

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
        substitutions.add(new SuffixSubstitution("óÁõ", "óÃõ")); // EX: (íõÛóÑúŞóÃõ¡ íõÊóÏóÑúÈóÃõ¡ íõÍúÈóäúØóÃõ)
        substitutions.add(new InfixSubstitution("óÁó", "óÃó")); // EX: (ÃäÊãÇ ÊõÛóÑúŞóÃóÇäö¡ ÊõÊóÏóÑúÈóÃóÇäö¡ ÊõÍúÈóäúØóÃóÇäö)
        substitutions.add(new InfixSubstitution("óÁú", "óÃú")); // EX: (ÃäÊä ÊõÛóÑúŞóÃúäó¡ ÊõÊóÏóÑúÈóÃúäó¡ ÊõÍúÈóäúØóÃúäó)
        substitutions.add(new InfixSubstitution("óÁõ", "óÄõ")); // EX: (ÃäÊã ÊõÛóÑúŞóÄõæäó¡ ÊõÊóÏóÑúÈóÄõæäó¡ ÊõÍúÈóäúØóÄõæäó)
        substitutions.add(new InfixSubstitution("Áö","Æö"));// EX: (ÃäÊí ÊõÛÑŞÆíä)
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
