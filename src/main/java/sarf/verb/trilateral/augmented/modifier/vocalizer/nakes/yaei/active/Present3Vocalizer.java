package sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.yaei.active;

import java.util.*;

import sarf.KindOfVerb;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SubstitutionsApplier;
import sarf.substitution.SuffixSubstitution;

import sarf.ConjugationResult;
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
public class Present3Vocalizer extends SubstitutionsApplier{
    private final List<Substitution> substitutions = new ArrayList<>();

    public Present3Vocalizer() {
        substitutions.add(new SuffixSubstitution("ِيُ","ِي"));// EX: (يُرَقِّي، يَجْأوِّي)
        substitutions.add(new SuffixSubstitution("يْ", "")); // EX: (لم يُرَقِّ، يَجْأوِّ)
        substitutions.add(new InfixSubstitution("يِن", "ن")); // EX: (أنتِ تُرَقِّنَّ، تَجْأوِّنَّ)
        substitutions.add(new InfixSubstitution("يِي", "ي")); // EX: (أنتِ تُرَقِّينَ، تَجْأوِّينَ)
        substitutions.add(new InfixSubstitution("يْن", "ين")); // EX: (أنتن تُرَقِّينَ، تَجْأوِّينَ)
        substitutions.add(new InfixSubstitution("ِّيُو", "ُّو")); // EX: (أنتم تُرَقُّونَ، تَجْأوُّونَ)
        substitutions.add(new InfixSubstitution("ِّيُن", "ُّن")); // EX: (أنتم تُرَقُّنَّ، تَجْأوُّنَّ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        return (kov == KindOfVerb.Naqis_Yaee || kov == KindOfVerb.Naqis_Yaee_Mahmouz_Faa) && formulaNo == 2 || (kov == KindOfVerb.Naqis_Yaee_Mahmouz_Ain && (formulaNo == 2 || formulaNo == 11));
    }
}
