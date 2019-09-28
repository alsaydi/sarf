package sarf.noun.trilateral.unaugmented.modifier.passiveparticiple.hamza;

import java.util.*;

import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SuffixSubstitution;
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
public class LamMahmouz extends AbstractLamMahmouz {
    private final List<Substitution> substitutions = new ArrayList<>();

    public LamMahmouz() {

        substitutions.add(new SuffixSubstitution("ُوءِ","ُوءِ"));// EX: (المَبْدُوءِ )
        substitutions.add(new InfixSubstitution("ُوءِ","ُوئِ"));// EX: (مَبْدُوئِينَ )
        substitutions.add(new SuffixSubstitution("ِيءَ","ِيءَ"));// EX: (المَقِيءَ )
        substitutions.add(new SuffixSubstitution("ِيءُ","ِيءُ"));// EX: (المَقِيءُ )
        substitutions.add(new SuffixSubstitution("ِيءِ","ِيءِ"));// EX: (المَقِيءِ )
        substitutions.add(new InfixSubstitution("ِيءٌ","ِيءٌ"));// EX: (مَقِيءٌ )
        substitutions.add(new InfixSubstitution("ِيءٍ","ِيءٍ"));// EX: (مَقِيءٍ )
        substitutions.add(new InfixSubstitution("ِيء","ِيئ"));// EX: (مَقِيئَةٌ )

    }


    public List getSubstitutions() {
        return substitutions;
    }

}
