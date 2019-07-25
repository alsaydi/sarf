package sarf.verb.quadriliteral.modifier.geminator.active;

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
public class Past2Geminator extends SubstitutionsApplier implements IQuadrilateralModifier {

    private List<Substitution> substitutions = new ArrayList<>();

    public Past2Geminator() {
        substitutions.add(new InfixSubstitution("تْتُ", "تُّ")); // EX: (أنا كَبْرَتُّ)
        substitutions.add(new InfixSubstitution("تْتَ", "تَّ")); // EX: (أنتَ كَبْرَتَّ)
        substitutions.add(new InfixSubstitution("تْتِ", "تِّ")); // EX: (أنتِ كَبْرَتِّ)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        if (conjugationResult.getRoot().getC4() != 'ت')
            return false;
        return true;
    }
}
