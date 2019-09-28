package sarf.noun.trilateral.unaugmented.modifier.passiveparticiple.hamza;

import java.util.*;

import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
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
private final List<Substitution> substitutions = new ArrayList<>();

    public EinMahmouz() {
        substitutions.add(new InfixSubstitution("وْءُ", "وْءُ")); // EX: (مَوْءُود)
        substitutions.add(new InfixSubstitution("يْءُ", "يْئُ")); // EX: (مَيْئُوس)
        substitutions.add(new InfixSubstitution("ْءُ", "ْؤُ")); // EX: (مَسْؤُول)
        substitutions.add(new InfixSubstitution("ْءِ", "ْئِ")); // EX: (مَرْئِيّ)
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
