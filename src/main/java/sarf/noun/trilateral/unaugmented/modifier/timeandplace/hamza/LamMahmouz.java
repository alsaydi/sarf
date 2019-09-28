package sarf.noun.trilateral.unaugmented.modifier.timeandplace.hamza;

import java.util.*;

import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SuffixSubstitution;

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
        substitutions.add(new InfixSubstitution("َءًا", "َأً")); // EX: (ملجأً، )
        substitutions.add(new InfixSubstitution("َءٌ", "َأٌ")); // EX: (ملجأٌ، )
        substitutions.add(new InfixSubstitution("َءٍ", "َأٍ")); // EX: (ملجأٍ، )
        substitutions.add(new SuffixSubstitution("َءُ", "َأُ")); // EX: (الملجأُ، )
        substitutions.add(new SuffixSubstitution("َءَ", "َأَ")); // EX: (الملجأَ ، )
        substitutions.add(new SuffixSubstitution("َءِ", "َأِ")); // EX: (الملجأِ ، )
        substitutions.add(new InfixSubstitution("َءَا", "َآ")); // EX: (مَلْجَآن، )
        substitutions.add(new InfixSubstitution("َءَ", "َأَ")); // EX: (مَكْمَأَة، مَلْجَأَيْن، )
        substitutions.add(new InfixSubstitution("ِء", "ِئ")); // EX: (مَوْطِئ،)
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
