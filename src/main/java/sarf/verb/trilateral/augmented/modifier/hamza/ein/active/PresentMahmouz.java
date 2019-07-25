package sarf.verb.trilateral.augmented.modifier.hamza.ein.active;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
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
public class PresentMahmouz extends AbstractEinMahmouz {

    private final List<Substitution> substitutions = new ArrayList<>();

    public PresentMahmouz() {
        substitutions.add(new InfixSubstitution("وْءُ","وْءُ"));// EX: (يَسْتَوْءُونَ)
        substitutions.add(new InfixSubstitution("يْءَ","يْئَ"));// EX: (يَيْئَسَ)
        substitutions.add(new SuffixSubstitution("اءِ","اءِ"));// EX: (لم يُراءِ،)
        substitutions.add(new SuffixSubstitution("َءِ","َئِ"));// EX: (لم يَنْفَئِ، لم يَشْتَئِ،)
        substitutions.add(new SuffixSubstitution("َءِّ","َئِّ"));// EX: (لم يُرَئِّ)
        substitutions.add(new SuffixSubstitution("ْءِ","ْئِ"));// EX: (لم يُنْئِ، )
        substitutions.add(new InfixSubstitution("ءِ","ئِ"));// EX: (يُسْئِم، يَسْتَرئِفُ، يُوئِبُ، يَنْذَئِجُ، يَبْتَئِسُ، يَتَّئِدُ، يُلائِمُ)
        substitutions.add(new InfixSubstitution("ْءُ","ْؤُ"));// EX: (يُنْؤُونَ، )
        substitutions.add(new InfixSubstitution("ْءَ","ْأَ"));// EX: (يَجْأَلُّ، يَجْأوِّي، )
        substitutions.add(new InfixSubstitution("َءَّ","َأَّ"));// EX: (يترَأَّفُ، )
        substitutions.add(new InfixSubstitution("َءُّ","َؤُّ"));// EX: (يُرَؤُّونَ، )
        substitutions.add(new InfixSubstitution("َءُ","َؤُ"));// EX: (يَنْفَؤُونَ، يَرْتَؤُونَ)
        substitutions.add(new InfixSubstitution("َءِّ","َئِّ"));// EX: (يُرَئِّسُ، )
        substitutions.add(new InfixSubstitution("اءَ","اءَ"));// EX: (يَتَفاءَلُ، )
        substitutions.add(new InfixSubstitution("اءُ","اؤُ"));// EX: (يُراؤُونَ، )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
