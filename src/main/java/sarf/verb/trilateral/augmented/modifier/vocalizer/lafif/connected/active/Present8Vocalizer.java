package sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.active;

import java.util.*;

import sarf.ConjugationResult;
import sarf.KindOfVerb;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SubstitutionsApplier;
import sarf.substitution.SuffixSubstitution;

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
public class Present8Vocalizer extends SubstitutionsApplier{
    private final List<Substitution> substitutions = new ArrayList<>();

    public Present8Vocalizer() {
        substitutions.add(new SuffixSubstitution("وُ", "ي")); // EX: (يُسَوِّي، يَحْوَوِّي)
        substitutions.add(new SuffixSubstitution("وْ", "")); // EX: (لم يُسَوِّ، لم يَحْوَوِّ)
        substitutions.add(new InfixSubstitution("وِّوِ", "وِّ")); // EX: (أنتِ تُسَوِّينَ، تَحْوَوِّينَ)
        substitutions.add(new InfixSubstitution("ِّوَ", "ِّيَ")); // EX: (أنتما تُسَوِّيانِ، تَحْوَوِّيانِ، لن يُسَوِّيَ، لن يَحْوَوِّيَ)
        substitutions.add(new InfixSubstitution("ِّوُ", "ُّ")); // EX: (أنتم تُسَوُّونَ، تَحْوَوُّونَ)
        substitutions.add(new InfixSubstitution("ِّوْ", "ِّي")); // EX: (أنتن تُسَوِّينَ، تَحْوَوِّينَ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();
        var root = triAugmentedConjugationResult.getRoot();
        return root.getC2() == root.getC3() && root.getC3() == 'و' &&  kov == KindOfVerb.Lafeef_Maqroon && (formulaNo == 2 || formulaNo == 11);
    }
}
