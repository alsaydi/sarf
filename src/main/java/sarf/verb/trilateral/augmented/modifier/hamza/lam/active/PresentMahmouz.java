package sarf.verb.trilateral.augmented.modifier.hamza.lam.active;

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

    private final List<Substitution> substitutions = new ArrayList<>();

    public PresentMahmouz() {
        substitutions.add(new SuffixSubstitution("يءُ", "يءُ")); // EX: (يُسِيءُ، )
        substitutions.add(new SuffixSubstitution("يءَ", "يءَ")); // EX: (لن يُسِيءَ، )
        substitutions.add(new InfixSubstitution("يء", "يئ")); // EX: (يُسِيئَانِ، يُسِيئُونِ)
        substitutions.add(new SuffixSubstitution("َءُ", "َأُ")); // EX: (يَتَدارَأُ، )
        substitutions.add(new SuffixSubstitution("َّءُ", "َّأُ")); // EX: (يَتَخَبَّأُ، )
        substitutions.add(new InfixSubstitution("َءَ", "َأَ")); // EX: (لن يَتَدارَأَ، يَتَدارَأَانِ، )
        substitutions.add(new InfixSubstitution("َءُ", "َؤُ")); // EX: (تَتَدارَؤُونَ، )
        substitutions.add(new InfixSubstitution("َءْ", "َأْ")); // EX: (لم يَتَدارَأْ، تَتَدارَأْنَ، )
        substitutions.add(new InfixSubstitution("َّءَ", "َّأَ")); // EX: (لن يتخبَّأَ، يَتَخَبَّأَانِ، )
        substitutions.add(new InfixSubstitution("َّءُ", "َّؤُ")); // EX: (تتخبَّؤُونَ، )
        substitutions.add(new InfixSubstitution("َّءْ", "َّأْ")); // EX: (لم يتخبَّأْ، تتخبَّأْنَ، )
        substitutions.add(new SuffixSubstitution("اءُ", "اءُ")); // EX: (يَسْتاءُ، )
        substitutions.add(new InfixSubstitution("اءُ", "اؤُ")); // EX: (يَسْتاؤُونَ، )
        substitutions.add(new InfixSubstitution("ءِ", "ئِ")); // EX: (تَسْتائِينَ، تُسِيئِينَ، تتدارَئِينَ، تتخبَّئِينَ، )
        substitutions.add(new InfixSubstitution("ِء", "ِئ")); // EX: (يُجْزِئُ، لن يُجْزِئَ، لم يُجْزِئْ، يكافِئُ، يَنْفقِئُ، يَبْتدِئُ، يستهزِئُ، يَحْزَوْزِئُ، )
        substitutions.add(new InfixSubstitution("ِّء", "ِّئ")); // EX: (يُجْزِّئُ، لن يُجْزِّئَ، لم يُجْزِّئْ، )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
