package sarf.verb.quadriliteral.modifier.vocalizer.nakes.active;

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
        substitutions.add(new SuffixSubstitution("يَ","ى"));// EX: (هو قَلْسَى، تَقَلْسَى، اسلنقَى)
        substitutions.add(new InfixSubstitution("يُو", "وْ")); // EX: (هم قَلْسَوْا، تَقَلْسَوْا، اسْلَنْقَوْا)
        substitutions.add(new InfixSubstitution("يَت", "ت")); // EX: (هي قَلْسَتْ، تَقَلْسَتْ، اسْلَنْقَتْ)
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
