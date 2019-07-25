package sarf.verb.quadriliteral.modifier.hamza.ended.active;

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
        substitutions.add(new InfixSubstitution("ِء", "ِئ")); // EX: (غَرْقِئْ، احْبَنْطِئْ)
        substitutions.add(new InfixSubstitution("ءِ", "ئِ")); // EX: (أنتِ تَدَرْبَئِي، )
        substitutions.add(new SuffixSubstitution("َءُ", "َأُ")); // EX: (أنتَ تَدَرْبَأْ، )
        substitutions.add(new InfixSubstitution("َءَ", "َأَ")); // EX: (أنتما تَدَرْبَأَا، )
        substitutions.add(new InfixSubstitution("َءْ", "َأْ")); // EX: (أنتن تَدَرْبَأْنَ، )
        substitutions.add(new InfixSubstitution("َءُ", "َؤُ")); // EX: (أنتم تَدَرْبَؤُوا، )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
