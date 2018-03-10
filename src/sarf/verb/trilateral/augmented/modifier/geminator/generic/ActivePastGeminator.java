package sarf.verb.trilateral.augmented.modifier.geminator.generic;

import sarf.verb.trilateral.Substitution.*;
import java.util.List;
import java.util.*;
import sarf.verb.trilateral.unaugmented.active.*;
import sarf.verb.trilateral.unaugmented.*;

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
public class ActivePastGeminator extends SubstitutionsApplier {

    private List substitutions = new LinkedList();

    public ActivePastGeminator() {
        substitutions.add(new ExpressionInfixSubstitution("ْC3َC3َ","َC3َّ"));// EX: (أَمَدَّ،)
        substitutions.add(new ExpressionInfixSubstitution("ْC3َC3ُ","َC3ُّ"));// EX: (أَمَدُّوا،)
        substitutions.add(new ExpressionInfixSubstitution("اC3َC3َ","اC3َّ"));// EX: (حاجَّ، احمارَّ)
        substitutions.add(new ExpressionInfixSubstitution("اC3َC3ُ","اC3ُّ"));// EX: (حاجُّوا، احمارُّوا)
        substitutions.add(new ExpressionInfixSubstitution("َC3َC3َ","َC3َّ"));// EX: (احمرَّ)
        substitutions.add(new ExpressionInfixSubstitution("َC3َC3ُ","َC3ُّ"));// EX: (احمرُّوا)
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
