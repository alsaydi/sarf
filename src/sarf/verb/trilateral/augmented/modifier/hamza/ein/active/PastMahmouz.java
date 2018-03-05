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
public class PastMahmouz extends AbstractEinMahmouz {

    private List substitutions = new LinkedList();

    public PastMahmouz() {
        substitutions.add(new InfixSubstitution("وْءَ", "وْءَ")); // EX: (اسْتَوْءَى)
        substitutions.add(new InfixSubstitution("يْءَ", "يْئَ")); // EX: (ايْئَسَ)
        substitutions.add(new InfixSubstitution("ْءَ", "ْأَ")); // EX: (أسْأمَ، اجْأَلَّ، استرْأَفَ، اجْأَوَّى)
        substitutions.add(new InfixSubstitution("َءَّ", "َأَّ")); // EX: (رأَّسَ، ترأَّفَ، )
        substitutions.add(new InfixSubstitution("َءَ", "َأَ")); // EX: (انذَأَجَ، ابتَأَسَ، )
        substitutions.add(new InfixSubstitution("َّءَ", "َّأَ")); // EX: (اتَّأَدَ، )
        substitutions.add(new InfixSubstitution("اءَ", "اءَ")); // EX: (لاءَمَ، تفاءَلَ، )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
