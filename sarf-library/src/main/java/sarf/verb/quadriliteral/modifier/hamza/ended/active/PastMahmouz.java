package sarf.verb.quadriliteral.modifier.hamza.ended.active;

import java.util.*;

import sarf.verb.quadriliteral.modifier.hamza.ended.AbstractQuadrilateralEndedMahmouzModifier;
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
public class PastMahmouz extends AbstractQuadrilateralEndedMahmouzModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public PastMahmouz() {
        substitutions.add(new InfixSubstitution("َءْ", "َأْ")); // EX: (غَرْقَأْتُ، تَدَرْبَأْتُ، احْبَنطَأْتُ)
        substitutions.add(new InfixSubstitution("َءَ", "َأَ")); // EX: (غَرْقَأَ، تَدَرْبَأَ، احْبَنْطَأَ)
        substitutions.add(new InfixSubstitution("َءُ", "َؤُ")); // EX: (غَرْقَؤُوا، تَدَرْبَؤُوا، احْبَنْطَؤُوا)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
