package sarf.verb.quadriliteral.modifier.hamza.internal.active;

import java.util.*;

import sarf.verb.quadriliteral.substitution.*;

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
public class ImperativeMahmouz extends SubstitutionsApplier {

    private final List<Substitution> substitutions = new ArrayList<>();

    public ImperativeMahmouz() {
        substitutions.add(new InfixSubstitution("َءْ", "َأْ")); // EX: (بَأْدِلْ، تَثَأْلَلْ، أنتن اطْمَأْنِنَّ)
        substitutions.add(new InfixSubstitution("ْءَ", "ْأَ")); // EX: (تَطَمْأَنْ، تَمَرْأَ)
        substitutions.add(new InfixSubstitution("ءِ", "ئِ")); // EX: (طَمْئِنْ، اطْمَئِنُّوا)
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
