package sarf.noun.trilateral.unaugmented.modifier.exaggeration.hamza;

import java.util.*;

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
private final List<Substitution> substitutions = new ArrayList<>();

    public FaaMahmouz() {
        substitutions.add(new InfixSubstitution("َءَا", "َآ")); // EX: (مآنِيف،)
        substitutions.add(new PrefixSubstitution("الءَ","الأَ"));// EX: (الأَكَّال، الأكول،)
        substitutions.add(new PrefixSubstitution("الءُ","الأُ"));// EX: (الأُكَلَة،)
        substitutions.add(new PrefixSubstitution("ءَ", "أَ")); // EX: (أَكَّال، أكول،)
        substitutions.add(new PrefixSubstitution("ءُ", "أُ")); // EX: (أُكَلَة،)
        substitutions.add(new InfixSubstitution("ِءْ", "ِئْ")); // EX: (مِئْناف،)

    }


    public List getSubstitutions() {
        return substitutions;
    }
}
