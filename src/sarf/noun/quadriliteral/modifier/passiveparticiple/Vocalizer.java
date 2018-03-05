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
        substitutions.add(new InfixSubstitution("َيَة","َاة"));// EX: (مُقَلْسَاةٌ،)
        substitutions.add(new InfixSubstitution("َيَت","َات"));// EX: (مُقَلْسَاتان، مُقَلْسَاتَيْنِ)
        substitutions.add(new InfixSubstitution("َيُو","َوْ"));// EX: (مُقَلْسَوْنَ)
        substitutions.add(new InfixSubstitution("َيِي","َيْ"));// EX: (مُقَلْسَيْنَ)
        substitutions.add(new SuffixSubstitution("َيُ","َى"));// EX: (هذا المُقَلسَى،)
        substitutions.add(new SuffixSubstitution("َيَ","َى"));// EX: (رأيتُ المُقَلسَى ،  )
        substitutions.add(new SuffixSubstitution("َيِ","َى"));// EX: (مررتُ على المُقَلسَى ، )
        substitutions.add(new InfixSubstitution("َيٌ","ًى"));// EX: (هذا مُقَلْسًى)
        substitutions.add(new InfixSubstitution("َيًا","ًى"));// EX: (رأيتُ مُقَلْسًى)
        substitutions.add(new InfixSubstitution("َيٍ","ًى"));// EX: (مررتُ على مُقَلْسًى)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        return conjugationResult.getRoot().getC4() == 'ي';
    }
}
