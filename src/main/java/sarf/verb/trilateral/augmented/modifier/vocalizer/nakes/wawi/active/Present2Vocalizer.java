package sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.wawi.active;

import java.util.*;

import sarf.KindOfVerb;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.ConjugationResult;
import sarf.verb.trilateral.augmented.modifier.*;

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
    private final List<Substitution> substitutions = new ArrayList<>();

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

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        if (kov == KindOfVerb.Naqis_Wawi_Mahmouz_Faa || kov == KindOfVerb.Naqis_Wawi_Mahmouz_Ain || kov == KindOfVerb.Naqis_Wawi) {
            switch (formulaNo) {
                case 7:
                case 8:
                    return true;
            }
        }
        return false;
    }
}
