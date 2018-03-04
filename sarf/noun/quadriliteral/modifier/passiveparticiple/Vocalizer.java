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
public class Vocalizer extends QuadrilateralNounSubstitutionApplier implements IQuadrilateralModifier {
    List substitutions = new LinkedList();

    public Vocalizer() {
        substitutions.add(new InfixSubstitution("óíóÉ","óÇÉ"));// EX: (ãõŞóáúÓóÇÉñ¡)
        substitutions.add(new InfixSubstitution("óíóÊ","óÇÊ"));// EX: (ãõŞóáúÓóÇÊÇä¡ ãõŞóáúÓóÇÊóíúäö)
        substitutions.add(new InfixSubstitution("óíõæ","óæú"));// EX: (ãõŞóáúÓóæúäó)
        substitutions.add(new InfixSubstitution("óíöí","óíú"));// EX: (ãõŞóáúÓóíúäó)
        substitutions.add(new SuffixSubstitution("óíõ","óì"));// EX: (åĞÇ ÇáãõŞóáÓóì¡)
        substitutions.add(new SuffixSubstitution("óíó","óì"));// EX: (ÑÃíÊõ ÇáãõŞóáÓóì ¡  )
        substitutions.add(new SuffixSubstitution("óíö","óì"));// EX: (ãÑÑÊõ Úáì ÇáãõŞóáÓóì ¡ )
        substitutions.add(new InfixSubstitution("óíñ","ğì"));// EX: (åĞÇ ãõŞóáúÓğì)
        substitutions.add(new InfixSubstitution("óíğÇ","ğì"));// EX: (ÑÃíÊõ ãõŞóáúÓğì)
        substitutions.add(new InfixSubstitution("óíò","ğì"));// EX: (ãÑÑÊõ Úáì ãõŞóáúÓğì)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        return conjugationResult.getRoot().getC4() == 'í';
    }
}
