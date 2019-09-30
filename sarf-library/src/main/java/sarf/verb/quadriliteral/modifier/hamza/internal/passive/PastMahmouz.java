package sarf.verb.quadriliteral.modifier.hamza.internal.passive;

import java.util.*;

import sarf.verb.quadriliteral.modifier.hamza.internal.AbstractQuadrilateralInternalMahmouzModifier;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;

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
public class PastMahmouz extends AbstractQuadrilateralInternalMahmouzModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public PastMahmouz() {
        substitutions.add(new InfixSubstitution("ءِ", "ئِ")); // EX: (طُمْئِنَ، تُطُمْئِنَ، تُمُرْئِيَ، اطْمُئِنَّ)
        substitutions.add(new InfixSubstitution("ُءْ", "ُؤْ")); // EX: (بُؤْدِلَ، تُثُؤْلِلَ، اطْمُؤْنِنْتُ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
