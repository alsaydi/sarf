package sarf.verb.quadriliteral.modifier.hamza.internal.passive;

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
public class PresentMahmouz extends AbstractQuadrilateralInternalMahmouzModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public PresentMahmouz() {
        substitutions.add(new InfixSubstitution("َءْ", "َأْ")); // EX: (يُبَأْدَلُ، يُتَثَأْلَلُ)
        substitutions.add(new InfixSubstitution("َءَ", "َأَ")); // EX: (يُطْمَأَنُّ)
        substitutions.add(new InfixSubstitution("ْءَ", "ْأَ")); // EX: (يُطَمْأَنُ، يُتَطَمْأَنُ، يُتَمَرْأَى)

    }

    public List getSubstitutions() {
        return substitutions;
    }
}
