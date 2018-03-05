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

        substitutions.add(new InfixSubstitution("َءٌ","َأٌ"));// EX: (مُغَرْقَأٌ)
        substitutions.add(new InfixSubstitution("َءًا","َأً"));// EX: (مُغَرْقَأً)
        substitutions.add(new InfixSubstitution("َءٍ","َأٍ"));// EX: (مُغَرْقَأٍ)
        substitutions.add(new InfixSubstitution("َءَا","َآ"));// EX: (مُغَرقآن)
        substitutions.add(new SuffixSubstitution("َءَ","َأَ"));// EX: (المُغَرقَأَ)
        substitutions.add(new SuffixSubstitution("َءُ","َأُ"));// EX: (المُغَرقَأُ)
        substitutions.add(new SuffixSubstitution("َءِ","َأِ"));// EX: (المُغَرقَأِ)
        substitutions.add(new InfixSubstitution("َءَ","َأَ"));// EX: (مُغَرْقَأة)
        substitutions.add(new InfixSubstitution("ءُ","ؤُ"));// EX: (مُغَرْقَؤُونَ)
        substitutions.add(new InfixSubstitution("ءِ","ئِ"));// EX: (مُغَرْقَئِينَ)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        return conjugationResult.getRoot().getC4() == 'ء';
    }
}
