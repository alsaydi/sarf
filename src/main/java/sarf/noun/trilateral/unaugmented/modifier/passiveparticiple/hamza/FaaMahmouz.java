package sarf.noun.trilateral.unaugmented.modifier.passiveparticiple.hamza;

import java.util.*;

import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;

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
        substitutions.add(new InfixSubstitution("َءْ", "َأْ")); // EX: (مَأْكُول)
        substitutions.add(new InfixSubstitution("َءُ", "َؤُ")); // EX: (مَؤُوب)
        substitutions.add(new InfixSubstitution("َءِ","َئِ"));// EX: (مَئِين)
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
