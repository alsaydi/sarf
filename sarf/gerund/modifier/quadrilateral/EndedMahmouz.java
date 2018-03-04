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
public class EndedMahmouz extends QuadrilateralNounSubstitutionApplier implements IQuadrilateralModifier {
    List substitutions = new LinkedList();

    public EndedMahmouz() {


        substitutions.add(new InfixSubstitution("ÇÁğÇ","ÇÁğ"));// EX: (ÌöÆÌÇÁğ¡ ÇÍÈäØÇÁğ)
        substitutions.add(new InfixSubstitution("óÁóÇ","óÂ"));// EX: (ÌÃÌÂÊ¡ ÛÑŞÂÊ¡ íÑäÂÊ)
        substitutions.add(new InfixSubstitution("óÁó","óÃó"));// EX: (ÌÃÌÃÉ¡ ÛÑŞÃÉ¡ íÑäÃÉ)
        substitutions.add(new InfixSubstitution("õÁ","õÄ"));// EX: (ÊÌÃÌõÄ¡ ÊÏÑÈÄ)

    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        return conjugationResult.getRoot().getC4() == 'Á';
    }
}
