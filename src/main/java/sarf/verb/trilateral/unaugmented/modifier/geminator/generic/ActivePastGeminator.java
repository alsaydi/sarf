package sarf.verb.trilateral.unaugmented.modifier.geminator.generic;

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
public class ActivePastGeminator extends SubstitutionsApplier{

    private List<Substitution> substitutions = new ArrayList<>();

    public ActivePastGeminator() {
        substitutions.add(new ExpressionInfixSubstitution("C2َC3َ","C3َّ"));
        substitutions.add(new ExpressionInfixSubstitution("C2َC3ُ","C3ُّ"));
        substitutions.add(new ExpressionInfixSubstitution("C2ِC3َ","C3َّ"));
        substitutions.add(new ExpressionInfixSubstitution("C2ِC3ُ","C3ُّ"));
        substitutions.add(new ExpressionInfixSubstitution("C2ُC3َ","C3َّ"));
        substitutions.add(new ExpressionInfixSubstitution("C2ُC3ُ","C3ُّ"));

    }

    public List getSubstitutions() {
        return substitutions;
    }
}
