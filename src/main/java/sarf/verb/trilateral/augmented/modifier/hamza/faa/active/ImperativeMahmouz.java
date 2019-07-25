package sarf.verb.trilateral.augmented.modifier.hamza.faa.active;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.hamza.faa.*;

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
public class ImperativeMahmouz extends AbstractFaaMahmouz {

    private final List<Substitution> substitutions = new ArrayList<>();

    public ImperativeMahmouz() {
        substitutions.add(new InfixSubstitution("أَءْ","آ"));// EX: (آثِرْ،  )
        substitutions.add(new InfixSubstitution("ءَا","آ"));// EX: (آجِرْ، تآكَلْ، )
        substitutions.add(new InfixSubstitution("ْءَ","ْأَ"));// EX: (انْأطِرْ، )
        substitutions.add(new InfixSubstitution("اءْ","ائْ"));// EX: (ائْتَمِرْ، )
        substitutions.add(new InfixSubstitution("َءَ","َأَ"));// EX: (تَأَكَّدْ، )
        substitutions.add(new InfixSubstitution("َءْ","َأْ"));// EX: (اسْتَأْمِرْ، )
        substitutions.add(new InfixSubstitution("َءِ","َئِ"));// EX: (اسْتَئِمَّ، أَئِسْ)
        substitutions.add(new InfixSubstitution("ءَ","أَ"));// EX: (أثِّرْ، )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
