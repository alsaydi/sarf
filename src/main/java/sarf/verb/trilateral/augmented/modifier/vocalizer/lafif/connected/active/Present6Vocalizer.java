package sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.active;

import java.util.*;

import sarf.KindOfVerb;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.*;
import sarf.verb.trilateral.augmented.*;

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
public class Present6Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Present6Vocalizer() {
        substitutions.add(new SuffixSubstitution("يُ", "ى")); // EX: (يَتَداوَى، يتقوَّى)
        substitutions.add(new SuffixSubstitution("يَ", "ى")); // EX: (لن يَتَداوَى، لن يتقوَّى)
        substitutions.add(new SuffixSubstitution("يْ", "")); // EX: (لم يَتَدَاوَ، لم يتقوَّ)
        substitutions.add(new InfixSubstitution("يِي", "يْ")); // EX: (أنتِ تتداوَيْنَ، تتقوَّيْنَ)
        substitutions.add(new InfixSubstitution("يُو", "وْ")); // EX: (أنتم تتداوَوْنَ، تتقوَّوْنَ)
        substitutions.add(new InfixSubstitution("يُن", "وُن")); // EX: (أنتم تَتَداوَوُنَّ، تتقوَّوُنَّ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(TriAugmentedConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();
        AugmentedTrilateralRoot root = triAugmentedConjugationResult.getRoot();
        return root.getC2() == 'و' && root.getC3() == 'ي' && (kov == KindOfVerb.Lafeef_Maqroon_Mahmouz_Faa || kov == KindOfVerb.Lafeef_Maqroon) && (formulaNo == 7 || formulaNo == 8);
    }
}
