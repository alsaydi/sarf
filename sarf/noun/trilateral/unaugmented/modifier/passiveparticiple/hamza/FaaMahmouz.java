package sarf.noun.trilateral.unaugmented.modifier.passiveparticiple.hamza;

import java.util.*;

import sarf.noun.*;
import sarf.verb.trilateral.unaugmented.modifier.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.noun.trilateral.unaugmented.modifier.*;

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
public class FaaMahmouz extends AbstractFaaMahmouz {
    List substitutions = new LinkedList();

    public FaaMahmouz() {
        substitutions.add(new InfixSubstitution("óÁú", "óÃú")); // EX: (ãóÃúßõæá)
        substitutions.add(new InfixSubstitution("óÁõ", "óÄõ")); // EX: (ãóÄõæÈ)
        substitutions.add(new InfixSubstitution("óÁö","óÆö"));// EX: (ãóÆöíä)
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
