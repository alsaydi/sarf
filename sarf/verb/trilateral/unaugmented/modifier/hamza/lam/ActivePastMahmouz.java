package sarf.verb.trilateral.unaugmented.modifier.hamza.lam;

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
public class ActivePastMahmouz extends AbstractLamMahmouz {
    private List substitutions = new ArrayList();

    public ActivePastMahmouz() {
        substitutions.add(new InfixSubstitution("óÁú", "óÃú")); // EX: (ÈóÏÃÊõ¡ æÌÃÊõ)
        substitutions.add(new InfixSubstitution("óÁó", "óÃó")); // EX: (ÈóÏóÃó¡ æóÌóÃó)
        substitutions.add(new InfixSubstitution("óÁõ", "óÄõ")); // EX: (ÈóÏóÄõæÇ¡)
        substitutions.add(new InfixSubstitution("öÁ", "öÆ")); // EX: (ÙóãöÆó¡ ÙóãöÆúÊõ¡ ÙóãöÆõæÇ¡ æóØöÆó¡ åóæöÆó¡ ŞöÆúÊõ)
        substitutions.add(new InfixSubstitution("õÁ", "õÄ")); // EX: (ÌóÑõÄó¡ ÌóÑõÄúÊõ¡ ÌóÑõÄõæÇ¡ æóÖõÄó¡ ÈõÄúÊõ¡ )
        substitutions.add(new InfixSubstitution("ÇÁõ", "ÇÄõ")); // EX: (ÈÇÄæÇ¡ ŞÇÄæÇ )
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
