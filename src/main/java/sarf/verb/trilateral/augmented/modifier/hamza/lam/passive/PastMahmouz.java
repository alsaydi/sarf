package sarf.verb.trilateral.augmented.modifier.hamza.lam.passive;

import java.util.*;

import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SuffixSubstitution;

import sarf.verb.trilateral.augmented.modifier.hamza.lam.*;

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
public class PastMahmouz extends AbstractLamMahmouz {

    private final List<Substitution> substitutions = new ArrayList<>();

    public PastMahmouz() {
        substitutions.add(new SuffixSubstitution("يءَ", "يءَ")); // EX: (أُسِيءَ، )
        substitutions.add(new InfixSubstitution("يء", "يئ")); // EX: (أسِيئَا، أُسِيئُوا)
        substitutions.add(new InfixSubstitution("ُءْ", "ُؤْ")); // EX: (استُؤْتُ، )
        substitutions.add(new InfixSubstitution("ِء", "ِئ")); // EX: (أُجْزِئَ، كُوفِئَ، انْفُقِئَ، ابتُدِئَ، تُدُورِئَ، استُهْزِئَ، احْزُوزِئَ، )
        substitutions.add(new InfixSubstitution("ِّء", "ِّئ")); // EX: (جُزِّئَ، تُخُبِّئَ، )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
