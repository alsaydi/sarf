package sarf.gerund.modifier.trilateral.unaugmented.meem;

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
    List<Substitution> substitutions = new ArrayList<>();

    public Geminator() {
        substitutions.add(new ExpressionInfixSubstitution("ْC3َC3", "َC3ّ")); // EX: (مَرَدّ، )
        substitutions.add(new ExpressionInfixSubstitution("ْC3ِC3", "َC3ّ")); // EX: (مَوَدّ، )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
