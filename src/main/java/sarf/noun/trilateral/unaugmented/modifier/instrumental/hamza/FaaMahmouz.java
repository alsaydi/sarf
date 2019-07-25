package sarf.noun.trilateral.unaugmented.modifier.instrumental.hamza;

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
        substitutions.add(new InfixSubstitution("ِء", "ِئ")); // EX: (مِئْزَر، مِئزرة، مِئزار)
        substitutions.add(new PrefixSubstitution("ءَ", "أَ")); // EX: (أزَّارة، )
        substitutions.add(new InfixSubstitution("الءَ","الأَ"));// EX: (أتَّاءَة، أثّاءة)
        substitutions.add(new InfixSubstitution("ءِ", "إِ")); // EX: (إزار، )
        substitutions.add(new InfixSubstitution("ءُ", "أُ")); // EX: (أُخْذَة، )
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
