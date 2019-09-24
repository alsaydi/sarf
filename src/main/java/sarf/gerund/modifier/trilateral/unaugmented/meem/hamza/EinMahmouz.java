package sarf.gerund.modifier.trilateral.unaugmented.meem.hamza;

import sarf.noun.trilateral.unaugmented.modifier.AbstractEinMahmouz;
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
public class EinMahmouz extends AbstractEinMahmouz {
    private final List<Substitution> substitutions = new ArrayList<>();

    public EinMahmouz() {
        substitutions.add(new InfixSubstitution("وْءَ", "وْءَ")); // EX: (مَوْءَل، مَوْءَى)
        substitutions.add(new InfixSubstitution("وْءً", "وْءً")); // EX: ( مَوْءًى)
        substitutions.add(new InfixSubstitution("يْءَ", "يْئَ")); // EX: (مَيْئَس)
        substitutions.add(new InfixSubstitution("ْءَ", "ْأَ")); // EX: (مَنْأَم)
        substitutions.add(new InfixSubstitution("ْءً", "ْأً"));// EX: (مَجْأًى)
        substitutions.add(new InfixSubstitution("ءِ", "ئِ")); // EX: (مَوْئِد)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
