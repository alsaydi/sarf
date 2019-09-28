package sarf.verb.quadriliteral.modifier.hamza.ended.active;

import java.util.*;

import sarf.verb.quadriliteral.modifier.hamza.ended.AbstractQuadrilateralEndedMahmouzModifier;
import sarf.verb.quadriliteral.substitution.*;
import sarf.verb.trilateral.Substitution.InfixSubstitution;
import sarf.verb.trilateral.Substitution.Substitution;
import sarf.verb.trilateral.Substitution.SuffixSubstitution;

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
public class PresentMahmouz extends AbstractQuadrilateralEndedMahmouzModifier {

    private final List<Substitution> substitutions = new ArrayList<>();

    public PresentMahmouz() {
        substitutions.add(new InfixSubstitution("ِء", "ِئ")); // EX: (يُغَرْقِئُ، يَحْبَنْطِئُ)
        substitutions.add(new InfixSubstitution("ءِ", "ئِ")); // EX: (أنتِ تَتَدَرْبَئِينَ، )
        substitutions.add(new SuffixSubstitution("َءُ", "َأُ")); // EX: (يَتَدَرْبَأُ، )
        substitutions.add(new InfixSubstitution("َءَ", "َأَ")); // EX: (أنتما تَتَدَرْبَأَانِ، )
        substitutions.add(new InfixSubstitution("َءْ", "َأْ")); // EX: (أنتن تَتَدَرْبَأْنَ، )
        substitutions.add(new InfixSubstitution("َءُ", "َؤُ")); // EX: (أنتم تَتَدَرْبَؤُونَ، )
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
