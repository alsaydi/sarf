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
public class ActivePastMahmouz extends AbstractFaaMahmouz {
    private List substitutions = new ArrayList();

    public ActivePastMahmouz() {
        substitutions.add(new PrefixSubstitution("ءَا", "آ")); // EX: (آبَ)
        substitutions.add(new InfixSubstitution("ءَ", "أَ")); // EX: (أكَلَ)
        substitutions.add(new InfixSubstitution("ءُ", "أُ")); // EX: (أُلْتُ من آل يؤول)
        substitutions.add(new PrefixSubstitution("ءِ", "إِ")); // EX: (إمْتُ)
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
