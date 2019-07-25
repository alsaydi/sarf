package sarf.verb.quadriliteral.modifier.hamza.ended.passive;

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
public class PresentMahmouz extends SubstitutionsApplier {

    private final List<Substitution> substitutions = new ArrayList<>();

    public PresentMahmouz() {
        substitutions.add(new SuffixSubstitution("َءُ", "َأُ")); // EX: (يُغَرْقَأُ، يُتَدَرْبَأُ، يُحْبَنْطَأُ)
        substitutions.add(new InfixSubstitution("َءَ", "َأَ")); // EX: (أنتما تُغَرْقَأَانِ، تُتَدَرْبَأَانِ، تُحْبَنْطَأَانِ)
        substitutions.add(new InfixSubstitution("َءْ", "َأْ")); // EX: (أنتن تُغَرْقَأْنَ، تُتَدَرْبَأْنَ، تُحْبَنْطَأْنَ)
        substitutions.add(new InfixSubstitution("َءُ", "َؤُ")); // EX: (أنتم تُغَرْقَؤُونَ، تُتَدَرْبَؤُونَ، تُحْبَنْطَؤُونَ)
        substitutions.add(new InfixSubstitution("ءِ","ئِ"));// EX: (أنتي تُغرقئين)
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
