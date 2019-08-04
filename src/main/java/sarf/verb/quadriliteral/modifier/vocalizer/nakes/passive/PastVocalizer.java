package sarf.verb.quadriliteral.modifier.vocalizer.nakes.passive;

import java.util.*;
import sarf.verb.quadriliteral.substitution.*;
import sarf.verb.quadriliteral.*;

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
public class PastVocalizer extends SubstitutionsApplier {

    private final List<Substitution> substitutions = new ArrayList<>();

    public PastVocalizer() {
        substitutions.add(new InfixSubstitution("ِيْ","ِي"));// EX: (أنا قُلْسِيتُ، تُقُلْسِيتُ، اسلُنْقِيتُ)
        substitutions.add(new InfixSubstitution("ِيُ", "ُ")); // EX: (هم قُلْسُوا، تُقُلْسُوا، اسْلُنْقُوا)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        if (conjugationResult.getRoot().getC4() != 'ي')
            return false;

        switch (conjugationResult.getFormulaNo()) {
        case 0:
        case 1:
        case 2:
            return true;
        }

        return false;
    }
}
