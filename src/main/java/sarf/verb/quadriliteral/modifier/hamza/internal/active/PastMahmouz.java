package sarf.verb.quadriliteral.modifier.hamza.internal.active;

import java.util.*;

import sarf.verb.quadriliteral.modifier.hamza.internal.AbstractQuadrilateralInternalMahmouzModifier;
import sarf.verb.quadriliteral.substitution.*;
import sarf.verb.trilateral.Substitution.InfixSubstitution;
import sarf.verb.trilateral.Substitution.Substitution;

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
        substitutions.add(new InfixSubstitution("َءْ", "َأْ")); // EX: (بَأْدَلَ، تَثَأْلَلَ)
        substitutions.add(new InfixSubstitution("ْءَ", "ْأَ")); // EX: (طَمْأَنَ، تَطَمْأَنَ، تَمَرْأَى، اشرَأْبَبْتُ)
        substitutions.add(new InfixSubstitution("َءَ", "َأَ")); // EX: (اطْمَأَنَّ)
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
