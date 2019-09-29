package sarf.verb.quadriliteral.modifier.hamza.ended.passive;

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
        substitutions.add(new InfixSubstitution("ِء","ِئ"));// EX: (غُرْقِئَ، تُدُرْبِئَ، احْبُنْطِئَ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
