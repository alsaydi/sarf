package sarf.verb.quadriliteral.modifier.hamza.internal.active;

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
public class PresentMahmouz extends AbstractQuadrilateralInternalMahmouzModifier {
    private final List<Substitution> substitutions = new ArrayList<>();
    public PresentMahmouz() {
        substitutions.add(new InfixSubstitution("َءْ", "َأْ")); // EX: (يُبَأْدِلُ، يَتَثَأْلَلُ، أنتن تَطْمَأْنِنَّ)
        substitutions.add(new InfixSubstitution("ْءَ", "ْأَ")); // EX: (يَتَطَمْأَنُ، يَتَمَرْأَى، )
        substitutions.add(new InfixSubstitution("ءِ", "ئِ")); // EX: (يُطَمْئِنُ، يَطْمَئِنُّ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
