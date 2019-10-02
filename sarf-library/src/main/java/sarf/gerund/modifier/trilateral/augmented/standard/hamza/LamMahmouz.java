package sarf.gerund.modifier.trilateral.augmented.standard.hamza;

import java.util.*;

import sarf.noun.trilateral.augmented.modifier.*;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SuffixSubstitution;


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
    private final List<Substitution> substitutions = new LinkedList<>();

    public LamMahmouz() {
        substitutions.add(new InfixSubstitution("اءًا","اءً"));// EX: (اجتزاءً، )
        substitutions.add(new InfixSubstitution("َءَا","َآ"));// EX: (مُواطآت، )
        substitutions.add(new InfixSubstitution("ِءَ","ِئَ"));// EX: (تجزئة، تجزئتان، )
        substitutions.add(new InfixSubstitution("َءَ","َأَ"));// EX: (مكافأة، )
        substitutions.add(new InfixSubstitution("َوُّء","َوُّء"));// EX: (تَبَوُّء، )
        substitutions.add(new InfixSubstitution("ُء","ُؤ"));// EX: (تدارؤ، )
        substitutions.add(new SuffixSubstitution("ِيءَ","ِيءَ"));// EX: (تجزيءَ)
        substitutions.add(new SuffixSubstitution("ِيءُ","ِيءُ"));// EX: (تجزيءُ)
        substitutions.add(new SuffixSubstitution("ِيءِ","ِيءِ"));// EX: (تجزيءِ)
        substitutions.add(new InfixSubstitution("ِيءٌ","ِيءٌ"));// EX: (تجزيءٌ)
        substitutions.add(new InfixSubstitution("ِيءٍ","ِيءٍ"));// EX: (تجزيءٍ)
        substitutions.add(new InfixSubstitution("ِيء","ِيئ"));// EX: (تجزيئًا، تجزيئا)
    }


    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
