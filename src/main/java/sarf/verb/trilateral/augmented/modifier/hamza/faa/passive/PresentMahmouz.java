package sarf.verb.trilateral.augmented.modifier.hamza.faa.passive;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.hamza.faa.*;

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
public class PresentMahmouz extends AbstractFaaMahmouz {

    private List<Substitution> substitutions = new ArrayList<>();

    public PresentMahmouz() {
        substitutions.add(new InfixSubstitution("أُءْ", "أُو")); // EX: (أُوثَرُ، أوْتَمَرُ، )
        substitutions.add(new InfixSubstitution("َءَا", "َآ")); // EX: (يُتَآكَلُ، )
        substitutions.add(new InfixSubstitution("ْءَا", "ْآ")); // EX: (يُنآدُ )
        substitutions.add(new InfixSubstitution("ُءْ", "ُؤْ")); // EX: (يُؤْثَرُ، يُؤْتَمَرُ، )
        substitutions.add(new InfixSubstitution("ُءَ", "ُؤَ")); // EX: (يُؤَثَّرُ، يُؤَاجَرُ، )
        substitutions.add(new InfixSubstitution("ْءَ", "ْأَ")); // EX: (يُنْأَطَرُ، )
        substitutions.add(new InfixSubstitution("َءَ", "َأَ")); // EX: (يُتَأكَّدُ، )
        substitutions.add(new InfixSubstitution("َءْ", "َأْ")); // EX: (يُسْتأمَرُ، )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
