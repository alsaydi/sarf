package sarf.verb.quadriliteral.modifier.geminator.passive;

import java.util.*;
import sarf.verb.quadriliteral.substitution.*;
import sarf.verb.quadriliteral.modifier.*;
import sarf.verb.quadriliteral.*;

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
public class Past3Geminator extends SubstitutionsApplier implements IQuadrilateralModifier {

    private List<Substitution> substitutions = new ArrayList<>();

    public Past3Geminator() {
        substitutions.add(new InfixSubstitution("نْنَ", "نَّ")); // EX: (نحن طُمْئِنَّا، هنَّ طُمْئِنَّ)
        substitutions.add(new ExpressionInfixSubstitution("ْC4ِC4َ","ِC4َّ"));// EX: (ازيئن)
        substitutions.add(new ExpressionInfixSubstitution("ْC4ِC4ُ","ِC4ُّ"));// EX: (ازيئنوا)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        if (conjugationResult.getRoot().getC4() != 'ن') {
            return false;
        }
        return true;
    }
}
