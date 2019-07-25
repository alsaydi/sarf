package sarf.verb.trilateral.augmented.modifier.hamza.ein.passive;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.hamza.ein.AbstractEinMahmouz;

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

    private List<Substitution> substitutions = new ArrayList<>();

    public PresentMahmouz() {
        substitutions.add(new InfixSubstitution("يْءَ", "يْئَ")); // EX: (يُسْتَيْئَسُ، )
        substitutions.add(new InfixSubstitution("وْءَ", "وْءَ")); // EX: (يُسْتَوْءَلُ، يُسْتَوْءَى، )
        substitutions.add(new InfixSubstitution("وءَ", "وْءَ")); // EX: (يُوءَبُ، )
        substitutions.add(new InfixSubstitution("ْءَ", "ْأَ")); // EX: (يُسْأَمُ، يُجْأَلُّ، يُسْتَرْأَفُ، )
        substitutions.add(new InfixSubstitution("َءَ", "َأَ")); // EX: (يُنْذَأجُ، يُبْتَأَسُ، )
        substitutions.add(new InfixSubstitution("َءَّ", "َأَّ")); // EX: (يُرَأَّسُ، يُتَرَأَّفُ، )
        substitutions.add(new InfixSubstitution("َّءَ", "َّأَ")); // EX: (يُتَّأدُ، )
        substitutions.add(new InfixSubstitution("اءَ", "اءَ")); // EX: (يُلاءَمُ، يُتَساءَلُ، )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
