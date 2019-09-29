package sarf.gerund.modifier.trilateral.unaugmented.nomen.hamza;

import sarf.noun.trilateral.unaugmented.modifier.AbstractEinMahmouz;
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
public class EinMahmouz extends AbstractEinMahmouz {
    private final List<Substitution> substitutions = new ArrayList<>();

    public EinMahmouz() {
        substitutions.add(new InfixSubstitution("َءْ", "َأْ"));// EX: (نأْمَة، وَأْدَة)
        substitutions.add(new InfixSubstitution("َءَ", "َأَ"));// EX: (نأَمات)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
