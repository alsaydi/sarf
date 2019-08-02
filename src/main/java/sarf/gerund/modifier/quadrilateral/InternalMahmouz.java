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
public class InternalMahmouz extends QuadrilateralNounSubstitutionApplier {
    private final List<InfixSubstitution> substitutions = new ArrayList<>();

    InternalMahmouz() {
        substitutions.add(new InfixSubstitution("َءْ","َأْ"));// EX: (جأجأة، بأدلة،  تجأجُؤ، )
        substitutions.add(new InfixSubstitution("ْءَ","ْأَ"));// EX: (طمأنة، )
        substitutions.add(new InfixSubstitution("ْءُ","ْؤُ"));// EX: (تطمؤن، )
        substitutions.add(new InfixSubstitution("ْءِ","ْئِ"));// EX: (تَمَرْئِيًا)
        substitutions.add(new InfixSubstitution("ِءْ","ِئْ"));// EX: (اطمِئْنان، اكوِئْداد، ازيِئْنان)
    }

    public List<InfixSubstitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        return conjugationResult.getRoot().getC2() == 'ء' || conjugationResult.getRoot().getC3() == 'ء';
    }
}
