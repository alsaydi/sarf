package sarf.verb.quadriliteral.modifier.vocalizer.nakes.active;

import java.util.*;
import sarf.verb.quadriliteral.substitution.*;
import sarf.verb.quadriliteral.modifier.*;
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
public class Present2Vocalizer extends SubstitutionsApplier implements IQuadrilateralModifier {

    private List substitutions = new LinkedList();

    public Present2Vocalizer() {
        substitutions.add(new SuffixSubstitution("يُ", "ى")); // EX: (يَتَقَلْسَى)
        substitutions.add(new SuffixSubstitution("يَ", "ى")); // EX: (لن يَتَقَلْسَى)
        substitutions.add(new SuffixSubstitution("يْ", "")); // EX: (لم يَتَقَلْسَ)
        substitutions.add(new InfixSubstitution("يِي", "يْ")); // EX: (أنتِ تَتَقَلْسَيْنَ)
        substitutions.add(new InfixSubstitution("يُو", "وْ")); // EX: (أنتم تَتَقَلْسَوْنَ)
        substitutions.add(new InfixSubstitution("يُن", "وُن")); // EX: (أنتم تَتَقَلْسَوُنَّ)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        if (conjugationResult.getRoot().getC4() == 'ي' && conjugationResult.getFormulaNo() == 1) {
            return true;
        }
        return false;
    }
}
