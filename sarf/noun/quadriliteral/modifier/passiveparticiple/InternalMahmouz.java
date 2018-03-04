package sarf.noun.quadriliteral.modifier.passiveparticiple;

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


        substitutions.add(new InfixSubstitution("úÁóÇ","úÂ"));// EX: (ãÊãÑÂÉ)
        substitutions.add(new InfixSubstitution("úÁğ","úÃğ"));// EX: (ãÊãÑÃğì)
        substitutions.add(new InfixSubstitution("óÁú", "óÃú")); // EX: (ãõÈóÃúÏóáñ¡ ãõÊóËóÃúáóáñ¡)
        substitutions.add(new InfixSubstitution("úÁó", "úÃó")); // EX: (ãõØóãúÃóäñ¡ ãõÊóØóãúÃóäñ¡ ãõØúãóÆöäøñ)
        substitutions.add(new InfixSubstitution("óÁó", "óÃó")); // EX: (ãõØúãóÃóäøñ)

    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        return conjugationResult.getRoot().getC2() == 'Á' || conjugationResult.getRoot().getC3() == 'Á';
    }
}
