package sarf.verb.trilateral.augmented.modifier.hamza.ein.active;

import java.util.*;

import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SuffixSubstitution;

import sarf.verb.trilateral.augmented.modifier.hamza.ein.*;

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
public class ImperativeMahmouz extends AbstractEinMahmouz {

    private final List<Substitution> substitutions = new ArrayList<>();

    public ImperativeMahmouz() {
        substitutions.add(new InfixSubstitution("وْءُ","وْءُ"));// EX: (اسْتَوْءُوا)
        substitutions.add(new SuffixSubstitution("اءِ","اءِ"));// EX: (رَاءِ)
        substitutions.add(new SuffixSubstitution("َءِ","َئِ"));// EX: (انْفَئِ، اشْتَئِ)
        substitutions.add(new SuffixSubstitution("ْءِ","ْئِ"));// EX: (أنْئِ)
        substitutions.add(new SuffixSubstitution("َءِّ","َئِّ"));// EX: (رَئِّ)
        substitutions.add(new InfixSubstitution("ءِ","ئِ"));// EX: (أسْئِمْ، اسْتَرْئِفْ، أوْئِبْ، انْذَئِجْ، ابْتَئِسْ، اتَّئِدْ، لائِمْ)
        substitutions.add(new InfixSubstitution("َءِّ","َئِّ"));// EX: (رَئِّسْ،  )
        substitutions.add(new InfixSubstitution("َءَّ","َأَّ"));// EX: (ترَأَّفْ، )
        substitutions.add(new InfixSubstitution("َءُّ","َؤُّ"));// EX: (رَؤُّوا،  )
        substitutions.add(new InfixSubstitution("َءُ","َؤُ"));// EX: (انْفَؤُوا، ارْتَؤُوا)
        substitutions.add(new InfixSubstitution("ْءُ","ْؤُ"));// EX: (انْؤُوا، )
        substitutions.add(new InfixSubstitution("ْءَ","ْأَ"));// EX: (اجْأَلَّ، يَجْأوِّي، )
        substitutions.add(new InfixSubstitution("اءَ","اءَ"));// EX: (تَفاءَلْ، )
        substitutions.add(new InfixSubstitution("اءُ","اؤُ"));// EX: (راؤُوا، )
    }


    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
