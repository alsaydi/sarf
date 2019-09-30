package sarf.gerund.modifier.trilateral.unaugmented.meem.hamza;

import sarf.noun.trilateral.unaugmented.modifier.AbstractFaaMahmouz;
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
public class FaaMahmouz extends AbstractFaaMahmouz {
    private final List<Substitution> substitutions = new ArrayList<>();

    public FaaMahmouz() {
        substitutions.add(new InfixSubstitution("َءَا", "َآ"));// EX: (مَآب،  )
        substitutions.add(new InfixSubstitution("َءَ", "َأَ"));// EX: (مَأَبّ )
        substitutions.add(new InfixSubstitution("َءْ", "َأْ"));// EX: (مَأْكَل، مَأْوَى )
        substitutions.add(new InfixSubstitution("ءِ", "ئِ"));// EX: (مَئِين، )
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
