package sarf.gerund.modifier.quadrilateral;

import java.util.*;

import sarf.noun.*;
import sarf.verb.quadriliteral.*;
import sarf.verb.quadriliteral.modifier.*;
import sarf.verb.quadriliteral.substitution.*;

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
public class InternalMahmouz extends QuadrilateralNounSubstitutionApplier implements IQuadrilateralModifier {
    List substitutions = new LinkedList();

    public InternalMahmouz() {
        substitutions.add(new InfixSubstitution("óÁú","óÃú"));// EX: (ÌÃÌÃÉ¡ ÈÃÏáÉ¡  ÊÌÃÌõÄ¡ )
        substitutions.add(new InfixSubstitution("úÁó","úÃó"));// EX: (ØãÃäÉ¡ )
        substitutions.add(new InfixSubstitution("úÁõ","úÄõ"));// EX: (ÊØãÄä¡ )
        substitutions.add(new InfixSubstitution("úÁö","úÆö"));// EX: (ÊóãóÑúÆöíğÇ)
        substitutions.add(new InfixSubstitution("öÁú","öÆú"));// EX: (ÇØãöÆúäÇä¡ ÇßæöÆúÏÇÏ¡ ÇÒíöÆúäÇä)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        return conjugationResult.getRoot().getC2() == 'Á' || conjugationResult.getRoot().getC3() == 'Á';
    }
}
