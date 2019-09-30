package sarf.verb.trilateral.unaugmented.modifier.hamza.lam;

import java.util.*;

import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SuffixSubstitution;
import sarf.verb.trilateral.unaugmented.modifier.hamza.*;


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
public class PassivePastMahmouz extends AbstractLamMahmouz {
    private final List<Substitution> substitutions = new ArrayList<>();

    public PassivePastMahmouz() {
        substitutions.add(new InfixSubstitution("ِء", "ِئ")); // EX: (بُدِئَ، ظُمِئَ، جُرِئَ، هُوِئَ)
        substitutions.add(new InfixSubstitution("يءُو", "يئُو")); // EX: (بِيئُوا، قِيئُوا، شِيئُوا)
        substitutions.add(new SuffixSubstitution("يءَ", "يءَ")); // EX: (بِيءَ، قِيءَ، شِيءَ، سِيءَ)
        substitutions.add(new InfixSubstitution("يءَ", "يئَ")); // EX: (بِيئَا، قِيئَا، شِيئَا، سِيئَتْ)
        substitutions.add(new InfixSubstitution("ُءْ", "ُؤْ")); // EX: (جُؤْتُ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
