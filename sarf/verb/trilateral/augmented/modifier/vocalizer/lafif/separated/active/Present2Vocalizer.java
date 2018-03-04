package sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.separated.active;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.*;
import sarf.verb.trilateral.augmented.ConjugationResult;

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
public class Present2Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Present2Vocalizer() {
        substitutions.add(new SuffixSubstitution("يُ", "ى")); // EX: (يَتَوارَى، يَتَوَلَّى)
        substitutions.add(new SuffixSubstitution("َيَ","َى"));// EX: (لن يَتَوارَى، يَتَوَلَّى)
        substitutions.add(new SuffixSubstitution("يْ", "")); // EX: (لم يَتَوارَ، يَتَوَلَّ)
        substitutions.add(new InfixSubstitution("يِي", "يْ")); // EX: (أنتِ تَتَوارَيْنَ، تَتَوَلَّيْنَ)
        substitutions.add(new InfixSubstitution("يُو", "وْ")); // EX: (أنتم تَتَوارَوْنَ، تَتَوَلَّوْنَ)
        substitutions.add(new InfixSubstitution("يُن", "وُن")); // EX: (أنتم تَتَوارَوُنَّ، تَتَوَلَّوُنَّ)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        return (kov == 29 && formulaNo == 7) || (kov == 30 && (formulaNo == 7 || formulaNo == 8));
    }
}
