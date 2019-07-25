package sarf.noun.trilateral.unaugmented.modifier.assimilate;

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
public class Geminator extends AbstractGeminator {
    final List<Substitution> substitutions = new ArrayList<>();

    public Geminator() {
        substitutions.add(new ExpressionInfixSubstitution("ْC3َC3","َC3ّ"));// EX: (أصَمّ)
        substitutions.add(new ExpressionInfixSubstitution("َC3ْC3","َC3ّ"));// EX: (صَمَّاء، رَيَّان، رَثٌّ)
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
