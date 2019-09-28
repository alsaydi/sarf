package sarf.noun.trilateral.unaugmented.modifier.assimilate.hamza;

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

        substitutions.add(new SuffixSubstitution("يءُ","يءُ"));// EX: (الجريءُ، )
        substitutions.add(new SuffixSubstitution("يءَ","يءَ"));// EX: (الجريءَ، )
        substitutions.add(new SuffixSubstitution("يءِ","يءِ"));// EX: (الجريءِ، )
        substitutions.add(new InfixSubstitution("يءٌ","يءٌ"));// EX: (جريءٌ، )
        substitutions.add(new InfixSubstitution("يءٍ","يءٍ"));// EX: (جريءٍ، )
        substitutions.add(new InfixSubstitution("يء","يئ"));// EX: (جَريئاً، جَرِيئَةً، جَرِيئان)
        substitutions.add(new InfixSubstitution("ِء","ِئ"));// EX: (ظَمِئٌ، )
        substitutions.add(new InfixSubstitution("ْءَا","ْآ"));// EX: (ظَمْآن، )

    }


    public List getSubstitutions() {
        return substitutions;
    }
}
