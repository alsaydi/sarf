package sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.wawi.active;

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
        substitutions.add(new SuffixSubstitution("وُ", "ي")); // EX: (هو يُسَمِّي)
        substitutions.add(new SuffixSubstitution("وْ", "")); // EX: (لم يُسَمِّ)
        substitutions.add(new InfixSubstitution("ِّوُ", "ُّ")); // EX: (أنتم تُسَمُّونَ)
        substitutions.add(new InfixSubstitution("وْن", "ين")); // EX: (أنتن تُسَمِّينَ)
        substitutions.add(new InfixSubstitution("وَ", "يَ")); // EX: (لن يُسَمِّيَ)
        substitutions.add(new InfixSubstitution("وِ", "")); // EX: (أنتِ تُسَمِّينَ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        return (kov == KindOfVerb.Naqis_Wawi_Mahmouz_Faa || kov == KindOfVerb.Naqis_Wawi) && formulaNo == 2;
    }
}
