package sarf.noun.trilateral.augmented.modifier.passiveparticiple.hamza;

import java.util.*;

import sarf.noun.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.noun.trilateral.augmented.modifier.*;

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
        substitutions.add(new InfixSubstitution("َءَا", "َآ")); // EX: (مُتآكَلٌ)
        substitutions.add(new InfixSubstitution("ْءَا","ْآ"));// EX: (مُنْآد)
        substitutions.add(new InfixSubstitution("َءَ", "َأَ")); // EX: (مُتأكَّد)
        substitutions.add(new InfixSubstitution("َءْ", "َأْ")); // EX: (مُستَأْمَر)
        substitutions.add(new InfixSubstitution("ْءَ", "ْأَ")); // EX: (مُنْأَطَرٌ)
        substitutions.add(new InfixSubstitution("ُء", "ُؤ")); // EX: (مُؤْثَرٌ، مُؤَثَّرٌ، مُؤَاجَرٌ)
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
