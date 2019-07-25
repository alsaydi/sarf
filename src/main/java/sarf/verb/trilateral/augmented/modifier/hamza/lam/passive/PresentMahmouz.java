package sarf.verb.trilateral.augmented.modifier.hamza.lam.passive;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.hamza.lam.*;

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
public class PresentMahmouz extends AbstractLamMahmouz {

    private List<Substitution> substitutions = new ArrayList<>();

    public PresentMahmouz() {
        substitutions.add(new SuffixSubstitution("اءُ","اءُ"));// EX: (يُسْتَاءُ، يُساءُ)
        substitutions.add(new SuffixSubstitution("َءُ","َأُ"));// EX: (يُجْزَأُ، يُكافَأُ، يُنْفَقَأُ، يُبْتَدَأُ، يُتَدارَأُ، يُسْتَهْزَأُ، يُحْزَوْزَأُ، )
        substitutions.add(new SuffixSubstitution("َّءُ","َّأُ"));// EX: (يُجَزَّأُ، يُخَبَّأُ، )
        substitutions.add(new InfixSubstitution("اءُ","اؤُ"));// EX: (يُسْتَاؤُونَ، يُساؤُونَ)
        substitutions.add(new InfixSubstitution("اءِ","ائِ"));// EX: (تُسْتَائِينَ،  تُسائِينَ)
        substitutions.add(new InfixSubstitution("َءْ","َأْ"));// EX: (يُجْزَأْنَ، لم يُجْزَأْ، يُكافَأْنَ، يُنْفَقَأْنَ، يُبْتَدَأْنَ، يُتَدَارَأْنَ، يُسْتَهْزَأْنَ، يُحْزَوْزَأْنَ)
        substitutions.add(new InfixSubstitution("َءَ","َأَ"));// EX: ( يُجْزَأَانِ، لن يُجْزَأَ، يُكافَأَانِ، يُنْفَقَأَانِ، يُبْتَدَأَانِ، يُتَدَارَأَانِ، يُسْتَهْزَأَانِ، يُحْزَوْزَأَانِ، )
        substitutions.add(new InfixSubstitution("َءُ","َؤُ"));// EX: (يُجْزَؤُونَ، يُكافَؤُونَ، يُنْفَقَؤُونَ، يُبْتَدَؤُونَ، يُتَدَارَؤُونَ، يُسْتَهْزَؤُونَ، يُحْزَوْزَؤُونَ، )
        substitutions.add(new InfixSubstitution("َّءْ","َّأْ"));// EX: (يُجَزَّأْنَ، لم يُجَزَّأْ، يُخَبَّأْنَ، )
        substitutions.add(new InfixSubstitution("َّءَ","َّأَ"));// EX: ( يُجَزَّأَانِ، لن يُجَزَّأَ، يُخَبَّأَانِ، )
        substitutions.add(new InfixSubstitution("َّءُ","َّؤُ"));// EX: (يُجَزَّؤُونَ، يُخَبَّؤُونَ، )
        substitutions.add(new InfixSubstitution("ءِ","ئِ"));// EX: (تُجْزَئِينَ، تُجَزَّئِينَ، تُكافَئِينَ، تُنْفَقَئِينَ، تُبْتَدَئِينَ، تُتَدارَئِينَ، تُخَبَّئِينَ، تُسْتَهْزَئِينَ، تُحْزَوْزَئِينَ، )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
