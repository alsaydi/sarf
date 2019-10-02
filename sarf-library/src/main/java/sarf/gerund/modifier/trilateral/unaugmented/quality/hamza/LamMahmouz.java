package sarf.gerund.modifier.trilateral.unaugmented.quality.hamza;

import sarf.noun.trilateral.unaugmented.modifier.AbstractLamMahmouz;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;

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
        substitutions.add(new InfixSubstitution("يءَ", "يئَ")); // EX: (هِيئَة، بِيئَة)
        substitutions.add(new InfixSubstitution("ْءَ", "ْأَ")); // EX: (بِدأة، وِطأة)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
