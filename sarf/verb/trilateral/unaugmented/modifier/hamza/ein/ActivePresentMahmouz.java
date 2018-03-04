package sarf.verb.trilateral.unaugmented.modifier.hamza.ein;

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
public class ActivePresentMahmouz extends AbstractEinMahmouz {
    private List substitutions = new ArrayList();

    public ActivePresentMahmouz() {
        substitutions.add(new SuffixSubstitution("úÁõ", "úÄõ")); // EX: (áã íóãúÄõ)
        substitutions.add(new InfixSubstitution("íúÁó","íúÆó"));// EX: (íóíúÆóÓ)
        substitutions.add(new InfixSubstitution("úÁó", "úÃó")); // EX: (íóÓúÃóá)
        substitutions.add(new InfixSubstitution("Áö", "Æö")); // EX: (íóäúÆöãõ¡ íóÆöÏõ)
        substitutions.add(new InfixSubstitution("úÁõ", "úÄõ")); // EX: (íóÖúÄõá)
        substitutions.add(new InfixSubstitution("óÁõ", "óÄõ")); // EX: (ÃäÊã ÊóÄõæÇ¡ åã íóÄõæÇ)
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
