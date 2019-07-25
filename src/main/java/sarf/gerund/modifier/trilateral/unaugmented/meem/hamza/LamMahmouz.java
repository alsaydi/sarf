package sarf.gerund.modifier.trilateral.unaugmented.meem.hamza;

import java.util.*;

import sarf.noun.trilateral.unaugmented.modifier.*;
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
public class LamMahmouz extends AbstractLamMahmouz {
    List<Substitution> substitutions = new ArrayList<>();

    public LamMahmouz() {
        substitutions.add(new InfixSubstitution("اءًا","اءً"));// EX: (مَهاءً)
        substitutions.add(new InfixSubstitution("َءًا","َأً"));// EX: (مَبْدأً)
        substitutions.add(new InfixSubstitution("يءً","يئً"));// EX: (مَجِيئًا)
        substitutions.add(new InfixSubstitution("َء","َأ"));// EX: (مَبْدَأ)
        substitutions.add(new InfixSubstitution("ِء","ِئ"));// EX: (مَوْجِئ)
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
