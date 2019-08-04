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
public class PresentVocalizer extends SubstitutionsApplier {

    private final List<Substitution> substitutions = new ArrayList<>();

    public PresentVocalizer() {
        substitutions.add(new SuffixSubstitution("يُ", "ى")); // EX: (يُقَلْسَى، يُتَقَلْسَى، يُسْلَنْقَى)
        substitutions.add(new SuffixSubstitution("يَ", "ى")); // EX: (لن يُقَلْسَى، يُتَقَلْسَى، يُسْلَنْقَى)
        substitutions.add(new SuffixSubstitution("يْ", "")); // EX: (لم يُقَلْسَ، يُتَقَلْسَ، يُسْلَنْقَ)
        substitutions.add(new InfixSubstitution("يِي", "يْ")); // EX: (أنتِ تُقَلْسَيْنَ، تُُتَقَلْسَيْنَ، تُسْلَنْقَيْنَ)
        substitutions.add(new InfixSubstitution("يُو", "وْ")); // EX: (أنتم تُقَلْسَوْنَ، تُُتَقَلْسَوْنَ، تُسْلَنْقَوْنَ)
        substitutions.add(new InfixSubstitution("يُن", "وُن")); // EX: (أنتن تُقَلْسَوُنَّ، تُُتَقَلْسَوُنَّ، تُسْلَنْقَوُنَّ)
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
