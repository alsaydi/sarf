package sarf.noun.trilateral.unaugmented.modifier.assimilate.hamza;

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
        substitutions.add(new InfixSubstitution("أَء","آ"));// EX: (آدَم، آوَد)
        substitutions.add(new InfixSubstitution("ءَ","أ"));// EX: (أبِدٌ، أسْفان، أمِين، )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
