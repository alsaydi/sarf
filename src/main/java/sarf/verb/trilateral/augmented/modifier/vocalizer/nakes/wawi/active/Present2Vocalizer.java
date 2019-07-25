package sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.wawi.active;

import java.util.*;

import sarf.KindOfVerb;
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
    private List<Substitution> substitutions = new ArrayList<>();

    public Present2Vocalizer() {
        substitutions.add(new SuffixSubstitution("وُ", "ى")); // EX: (هو يَتَسامَى، يَتَزَكَّى)
        substitutions.add(new SuffixSubstitution("وَ", "ى")); // EX: (لن يَتَسامَى، يَتَزَكَّى)
        substitutions.add(new SuffixSubstitution("وْ", "")); // EX: (لم يَتَسامَ، يَتَزَكَّ)
        substitutions.add(new InfixSubstitution("وَ", "يَ")); // EX: (أنتما تتسامَيان، تتزكَّيان)
        substitutions.add(new InfixSubstitution("وِي", "يْ")); // EX: (أنتِ تتسامَيْنَ، تتزَكَّيْنَ)
        substitutions.add(new InfixSubstitution("وِن", "يِن")); // EX: (أنتِ تتسامَيِنَّ، تتزَكَّيِنَّ)
        substitutions.add(new InfixSubstitution("وُو", "وْ")); // EX: (أنتم تتسامَوْنَ، تتزَكَّوْنَ)
        substitutions.add(new InfixSubstitution("وْن","يْن"));// EX: (أنتن تتسامَيْنَ، تتزَكَّيْنَ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        if (kov == 21 || kov == 22 || kov == 23) {
            switch (formulaNo) {
                case 7:
                case 8:
                    return true;
            }
        }
        return false;
    }
}
