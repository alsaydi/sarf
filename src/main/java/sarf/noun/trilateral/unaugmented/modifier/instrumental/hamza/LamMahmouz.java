package sarf.noun.trilateral.unaugmented.modifier.instrumental.hamza;

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

        substitutions.add(new SuffixSubstitution("َءُ","َأُ"));// EX: (المِقْرأُ)
        substitutions.add(new SuffixSubstitution("َءِ","َأِ"));// EX: (المِقْرأِ)
        substitutions.add(new InfixSubstitution("اءًا","اءً"));// EX: (مئثاءً)
        substitutions.add(new InfixSubstitution("َءٌ", "َأٌ")); // EX: (مِفْقَأٌ)
        substitutions.add(new InfixSubstitution("َءًا", "َأً")); // EX: (مِفْقَأً)
        substitutions.add(new InfixSubstitution("َءٍ", "َأٍ")); // EX: (مِفْقَأٍ)
        substitutions.add(new InfixSubstitution("َءَا", "َآ")); // EX: (مِفْقآن)
        substitutions.add(new InfixSubstitution("َءَ", "َأَ")); // EX: (مِفقأيْن، مِفقأة، مِفقأتان)
        substitutions.add(new InfixSubstitution("ِء", "ِئ")); // EX: (قارئة)
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
