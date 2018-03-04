package sarf.gerund.modifier.trilateral.unaugmented.meem.hamza;

import java.util.*;

import sarf.noun.trilateral.unaugmented.modifier.*;
import sarf.verb.trilateral.Substitution.*;

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
public class FaaMahmouz extends AbstractFaaMahmouz {
    List substitutions = new LinkedList();

    public FaaMahmouz() {
        substitutions.add(new InfixSubstitution("َءَا","َآ"));// EX: (مَآب،  )
        substitutions.add(new InfixSubstitution("َءَ","َأَ"));// EX: (مَأَبّ )
        substitutions.add(new InfixSubstitution("َءْ","َأْ"));// EX: (مَأْكَل، مَأْوَى )
        substitutions.add(new InfixSubstitution("ءِ","ئِ"));// EX: (مَئِين، )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
