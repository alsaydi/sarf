package sarf.verb.trilateral.unaugmented.modifier.hamza.faa;

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
public class PassivePastMahmouz extends AbstractFaaMahmouz {
    private List substitutions = new ArrayList();

    public PassivePastMahmouz() {
        substitutions.add(new InfixSubstitution("Áö", "Åö")); // EX: (ÅíÈó¡ ÅöÈúÊõ)
        substitutions.add(new PrefixSubstitution("Áõ", "Ãõ")); // EX: (Ãõßöáó)
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
