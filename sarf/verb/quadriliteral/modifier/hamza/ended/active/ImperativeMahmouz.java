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
public class ImperativeMahmouz extends SubstitutionsApplier {

    private List substitutions = new LinkedList();

    public ImperativeMahmouz() {
        substitutions.add(new InfixSubstitution("öÁ", "öÆ")); // EX: (ÛóÑúŞöÆú¡ ÇÍúÈóäúØöÆú)
        substitutions.add(new InfixSubstitution("Áö", "Æö")); // EX: (ÃäÊö ÊóÏóÑúÈóÆöí¡ )
        substitutions.add(new SuffixSubstitution("óÁõ", "óÃõ")); // EX: (ÃäÊó ÊóÏóÑúÈóÃú¡ )
        substitutions.add(new InfixSubstitution("óÁó", "óÃó")); // EX: (ÃäÊãÇ ÊóÏóÑúÈóÃóÇ¡ )
        substitutions.add(new InfixSubstitution("óÁú", "óÃú")); // EX: (ÃäÊä ÊóÏóÑúÈóÃúäó¡ )
        substitutions.add(new InfixSubstitution("óÁõ", "óÄõ")); // EX: (ÃäÊã ÊóÏóÑúÈóÄõæÇ¡ )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
