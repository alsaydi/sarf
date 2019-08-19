package sarf.noun.trilateral.augmented.modifier.activeparticiple.hamza;

import sarf.noun.trilateral.augmented.modifier.AbstractFaaMahmouz;
import sarf.verb.trilateral.Substitution.InfixSubstitution;
import sarf.verb.trilateral.Substitution.Substitution;

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
public class FaaMahmouz extends AbstractFaaMahmouz {
    private final List<Substitution> substitutions = new ArrayList<>();

    public FaaMahmouz() {
        substitutions.add(new InfixSubstitution("َءَا", "َآ"));// EX: (مُتآكِلٌ)
        substitutions.add(new InfixSubstitution("ْءَا", "ْآ"));// EX: (مُنْآد)
        substitutions.add(new InfixSubstitution("َءَ", "َأَ"));// EX: (مُتأكِّد)
        substitutions.add(new InfixSubstitution("َءْ", "َأْ"));// EX: (مُستَأْمِر)
        substitutions.add(new InfixSubstitution("ْءَ", "ْأَ"));// EX: (مُنْأَطِرٌ)
        substitutions.add(new InfixSubstitution("ءِ", "ئِ"));// EX: (مُئِيسٌ)
        substitutions.add(new InfixSubstitution("ُء", "ُؤ"));// EX: (مُؤْثِرٌ، مُؤَثِّرٌ، مُؤَاجِرٌ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
