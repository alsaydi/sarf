package sarf.verb.trilateral.augmented.modifier.hamza.ein.passive;

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

    private final List<Substitution> substitutions = new ArrayList<>();

    public PastMahmouz() {
        substitutions.add(new InfixSubstitution("ءِ", "ئِ")); // EX: (أُسْئِمَ، لُوئِمَ، انْذُئِجَ، ابتُئِسَ، تُسُوئِلَ، استُرئِفَ، اتُّئِدَ، )
        substitutions.add(new InfixSubstitution("ْءُ", "ْؤُ")); // EX: (اجْؤُلَّ، )
        substitutions.add(new InfixSubstitution("ُءُ","ُؤُ"));// EX: (ارتُؤُوا، )
        substitutions.add(new InfixSubstitution("ُءِّ", "ُئِّ")); // EX: (رُئِّسَ، تُرُئِّفَ، )
        substitutions.add(new InfixSubstitution("ُءُّ", "ُؤُّ")); // EX: (رُؤُّوا، )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
