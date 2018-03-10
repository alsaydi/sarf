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
public class ImperativeMahmouz extends AbstractLamMahmouz {

    private List substitutions = new LinkedList();

    public ImperativeMahmouz() {
        substitutions.add(new InfixSubstitution("يءَ","يئَ"));// EX: (أَسِيئَا، )
        substitutions.add(new InfixSubstitution("يءُ","يئُ"));// EX: (أَسِيئُوا، )
        substitutions.add(new InfixSubstitution("ِء","ِئ"));// EX: (أُجْزِئْ، كافِئْ، انْفَقِئْ، ابتَدِئْ، استهزِئْ، احْزَوْزِئْ، أَسِئْ، )
        substitutions.add(new InfixSubstitution("ءِ","ئِ"));// EX: (تكافئي )
        substitutions.add(new InfixSubstitution("ِّء","ِّئ"));// EX: (جَزِّئْ، )
        substitutions.add(new InfixSubstitution("َءْ","َأْ"));// EX: (تدارَأْ، تدارَأْنَ، اسْتَأْ)
        substitutions.add(new InfixSubstitution("َءَ","َأَ"));// EX: (تدارَأَا، )
        substitutions.add(new InfixSubstitution("َءُ","َؤُ"));// EX: (تدارَؤُوا، )
        substitutions.add(new InfixSubstitution("َّءْ","َّأْ"));// EX: (تَخَبَّأْ، تَخَبَّأْنَ، )
        substitutions.add(new InfixSubstitution("َّءَ","َّأَ"));// EX: (تَخَبَّأَا، )
        substitutions.add(new InfixSubstitution("َّءُ","َّؤُ"));// EX: (تَخَبَّؤُوا، )
        substitutions.add(new InfixSubstitution("اءُ","اؤُ"));// EX: (اسْتاؤُوا، )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
