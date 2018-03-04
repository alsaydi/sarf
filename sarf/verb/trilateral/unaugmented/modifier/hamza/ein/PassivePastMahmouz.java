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
public class PassivePastMahmouz extends AbstractEinMahmouz {
    private List substitutions = new ArrayList();

    public PassivePastMahmouz() {
        substitutions.add(new InfixSubstitution("õÁö","õÆö"));// EX: (ÓõÆöáúÊõ)
        substitutions.add(new InfixSubstitution("õÁõ","õÄõ"));// EX: (ÑõÄõæÇ)
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
