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
public class EinMahmouz extends AbstractEinMahmouz {
    List substitutions = new LinkedList();

    public EinMahmouz() {
        substitutions.add(new InfixSubstitution("æúÁõ", "æúÁõ")); // EX: (ãóæúÁõæÏ)
        substitutions.add(new InfixSubstitution("íúÁõ", "íúÆõ")); // EX: (ãóíúÆõæÓ)
        substitutions.add(new InfixSubstitution("úÁõ", "úÄõ")); // EX: (ãóÓúÄõæá)
        substitutions.add(new InfixSubstitution("úÁö", "úÆö")); // EX: (ãóÑúÆöíø)
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
