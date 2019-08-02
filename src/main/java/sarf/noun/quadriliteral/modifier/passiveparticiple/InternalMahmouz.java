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
public class InternalMahmouz extends QuadrilateralNounSubstitutionApplier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public InternalMahmouz() {


        substitutions.add(new InfixSubstitution("ْءَا","ْآ"));// EX: (متمرآة)
        substitutions.add(new InfixSubstitution("ْءً","ْأً"));// EX: (متمرأًى)
        substitutions.add(new InfixSubstitution("َءْ", "َأْ")); // EX: (مُبَأْدَلٌ، مُتَثَأْلَلٌ،)
        substitutions.add(new InfixSubstitution("ْءَ", "ْأَ")); // EX: (مُطَمْأَنٌ، مُتَطَمْأَنٌ، مُطْمَئِنٌّ)
        substitutions.add(new InfixSubstitution("َءَ", "َأَ")); // EX: (مُطْمَأَنٌّ)

    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        return conjugationResult.getRoot().getC2() == 'ء' || conjugationResult.getRoot().getC3() == 'ء';
    }
}
