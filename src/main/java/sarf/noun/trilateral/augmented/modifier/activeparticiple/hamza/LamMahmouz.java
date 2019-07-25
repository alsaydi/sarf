package sarf.noun.trilateral.augmented.modifier.activeparticiple.hamza;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.noun.trilateral.augmented.modifier.*;

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

        substitutions.add(new SuffixSubstitution("اءَ","اءَ"));// EX: (مستاءَ)
        substitutions.add(new SuffixSubstitution("اءُ","اءُ"));// EX: (مستاءُ)
        substitutions.add(new SuffixSubstitution("اءِ","اءِ"));// EX: (مستاءِ)
        substitutions.add(new SuffixSubstitution("يءَ", "يءَ")); // EX: (مُدِيءَ)
        substitutions.add(new SuffixSubstitution("يءُ", "يءُ")); // EX: (مُدِيءُ)
        substitutions.add(new SuffixSubstitution("يءِ", "يءِ")); // EX: (مُدِيءِ)
        substitutions.add(new InfixSubstitution("اءًا", "اءً")); // EX: (مُسْتاءً)
        substitutions.add(new InfixSubstitution("اءُ", "اؤُ")); // EX: (مُسْتاؤُون)
        substitutions.add(new InfixSubstitution("اءِ", "ائِ")); // EX: (مُسْتائين)
        substitutions.add(new InfixSubstitution("يءٌ", "يءٌ")); // EX: (مُدِيءٌ)
        substitutions.add(new InfixSubstitution("يءٍ", "يءٍ")); // EX: (مُدِيءٍ)
        substitutions.add(new InfixSubstitution("يء", "يئ")); // EX: (مُديئاً)
        substitutions.add(new InfixSubstitution("ِء", "ِئ")); // EX: (مُجْزِئٌ، مُستَهْزِئٌ)
        substitutions.add(new InfixSubstitution("ِّء", "ِّئ")); // EX: (مُجَزِّئٌ، مُتَخَبِّئٌ )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
