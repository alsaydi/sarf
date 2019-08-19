package sarf.noun.trilateral.augmented.modifier.activeparticiple.hamza;

import sarf.noun.trilateral.augmented.modifier.AbstractLamMahmouz;
import sarf.verb.trilateral.Substitution.InfixSubstitution;
import sarf.verb.trilateral.Substitution.Substitution;
import sarf.verb.trilateral.Substitution.SuffixSubstitution;

import java.util.ArrayList;
import java.util.List;

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
        substitutions.add(new SuffixSubstitution("اءَ", "اءَ"));// EX: (مستاءَ)
        substitutions.add(new SuffixSubstitution("اءُ", "اءُ"));// EX: (مستاءُ)
        substitutions.add(new SuffixSubstitution("اءِ", "اءِ"));// EX: (مستاءِ)
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

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
