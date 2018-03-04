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
public class Vocalizer extends QuadrilateralNounSubstitutionApplier implements IQuadrilateralModifier {
    List substitutions = new LinkedList();

    public Vocalizer() {

        substitutions.add(new InfixSubstitution("óíóÉ","óÇÉ"));// EX: (ŞáÓÇÉ¡ ÖæÖÇÉ¡ ÍíÍÇÉ)
        substitutions.add(new InfixSubstitution("óíóÊ","óÇÊ"));// EX: (ŞáÓÇÊÇä¡ ÖæÖÇÊÇä¡ ÍíÍÇÊÇä)
        substitutions.add(new InfixSubstitution("óÇí","óÇÁ"));// EX: (ÇÓáäŞÇÁ)
        substitutions.add(new SuffixSubstitution("õíõ","öí"));// EX: (åĞÇ ÇáÊŞáÓí)
        substitutions.add(new SuffixSubstitution("õíó","öíó"));// EX: (ÑÃíÊõ ÇáÊŞáÓíó)
        substitutions.add(new SuffixSubstitution("õíö","öí"));// EX: (ÈÇáÊŞáÓí)
        substitutions.add(new InfixSubstitution("õíñ","ò"));// EX: (åĞÇ ÊŞáÓò)
        substitutions.add(new InfixSubstitution("õíò","ò"));// EX: (ÈÊŞáÓò)
        substitutions.add(new InfixSubstitution("õíğ","öíğ"));// EX: (ÊŞáÓíğÇ)
        substitutions.add(new InfixSubstitution("õíó","öíó"));// EX: (ÊŞáÓíÇä)

    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        return conjugationResult.getRoot().getC4() == 'í';
    }
}
