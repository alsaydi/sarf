package sarf.noun.quadriliteral.modifier.activeparticiple;

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
        substitutions.add(new SuffixSubstitution("öíõ","öí"));// EX: (åĞÇ ÇáãŞáÓöí¡ )
        substitutions.add(new SuffixSubstitution("öíó","öíó"));// EX: (ÑÃíÊõ ÇáãŞáÓöíó ¡ )
        substitutions.add(new SuffixSubstitution("öíö","öí"));// EX: (ãÑÑÊõ Úáì ÇáãŞáÓöí ¡ )
        substitutions.add(new InfixSubstitution("öíñ","ò"));// EX: (åĞÇ ãŞáÓò)
        substitutions.add(new InfixSubstitution("öíò","ò"));// EX: (ãÑÑÊõ Úáì ãŞáÓò)
        substitutions.add(new InfixSubstitution("öíõ","õ"));// EX: (ãŞáÓõæäó ¡ )
        substitutions.add(new InfixSubstitution("öíö","ö"));// EX: (ãŞáÓöíäó ¡ )
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        return conjugationResult.getRoot().getC4() == 'í';
    }
}
