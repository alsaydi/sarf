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
public class ActivePastMahmouz extends AbstractEinMahmouz {
    private List substitutions = new ArrayList();

    public ActivePastMahmouz() {
        substitutions.add(new InfixSubstitution("óÁó", "óÃó")); // EX: (ÓÃá)
        substitutions.add(new InfixSubstitution("óÁö", "óÆö")); // EX: (ÓóÆöãó)
        substitutions.add(new InfixSubstitution("óÁõ", "óÄõ")); // EX: (ÖóÄõáó)
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
