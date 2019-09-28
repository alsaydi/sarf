package sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.active;

import java.util.*;

import sarf.ConjugationResult;
import sarf.KindOfVerb;
import sarf.verb.trilateral.Substitution.*;
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
public class Present5Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Present5Vocalizer() {
        substitutions.add(new SuffixSubstitution("ِيُ","ِي"));// EX: (يُقَوِّي)
        substitutions.add(new SuffixSubstitution("يْ", "")); // EX: (لم يُقَوِّ)
        substitutions.add(new InfixSubstitution("ِّيِ", "ِّ")); // EX: (أنتِ تقوِّينَ)
        substitutions.add(new InfixSubstitution("ِّيُ", "ُّ")); // EX: (أنتم تُقَوُّونَ)
        substitutions.add(new InfixSubstitution("ِّيْ", "ِّي")); // EX: (أنتن تُقَوِّينَ)
    }


    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();
        var root = triAugmentedConjugationResult.getRoot();
        return root.getC2() == 'و' && root.getC3() == 'ي' && (kov == KindOfVerb.Lafeef_Maqroon || kov == KindOfVerb.Lafeef_Maqroon_Mahmouz_Faa) && formulaNo == 2;
    }
}
