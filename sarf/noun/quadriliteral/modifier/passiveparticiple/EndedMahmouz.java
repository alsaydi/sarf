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
public class EndedMahmouz extends QuadrilateralNounSubstitutionApplier implements IQuadrilateralModifier {
    List substitutions = new LinkedList();

    public EndedMahmouz() {

        substitutions.add(new InfixSubstitution("óÁñ","óÃñ"));// EX: (ãõÛóÑúŞóÃñ)
        substitutions.add(new InfixSubstitution("óÁğÇ","óÃğ"));// EX: (ãõÛóÑúŞóÃğ)
        substitutions.add(new InfixSubstitution("óÁò","óÃò"));// EX: (ãõÛóÑúŞóÃò)
        substitutions.add(new InfixSubstitution("óÁóÇ","óÂ"));// EX: (ãõÛóÑŞÂä)
        substitutions.add(new SuffixSubstitution("óÁó","óÃó"));// EX: (ÇáãõÛóÑŞóÃó)
        substitutions.add(new SuffixSubstitution("óÁõ","óÃõ"));// EX: (ÇáãõÛóÑŞóÃõ)
        substitutions.add(new SuffixSubstitution("óÁö","óÃö"));// EX: (ÇáãõÛóÑŞóÃö)
        substitutions.add(new InfixSubstitution("óÁó","óÃó"));// EX: (ãõÛóÑúŞóÃÉ)
        substitutions.add(new InfixSubstitution("Áõ","Äõ"));// EX: (ãõÛóÑúŞóÄõæäó)
        substitutions.add(new InfixSubstitution("Áö","Æö"));// EX: (ãõÛóÑúŞóÆöíäó)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        return conjugationResult.getRoot().getC4() == 'Á';
    }
}
