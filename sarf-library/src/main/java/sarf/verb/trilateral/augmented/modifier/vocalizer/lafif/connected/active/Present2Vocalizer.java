package sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.active;

import java.util.*;

import sarf.ConjugationResult;
import sarf.KindOfVerb;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SubstitutionsApplier;
import sarf.substitution.SuffixSubstitution;

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
public class Present2Vocalizer extends SubstitutionsApplier{
    private final List<Substitution> substitutions = new ArrayList<>();

    public Present2Vocalizer() {
        substitutions.add(new SuffixSubstitution("ِيُ","ِي"));// EX: (يُحَيِّي)
        substitutions.add(new SuffixSubstitution("يْ",""));// EX: (لم يُحَيِّ)
        substitutions.add(new InfixSubstitution("ِّيِ","ِّ"));// EX: (أنتِ تُحَيِّينَ)
        substitutions.add(new InfixSubstitution("ِّيُ","ُّ"));// EX: (أنتم تُحَيُّونَ)
        substitutions.add(new InfixSubstitution("ِّيْ","ِّي"));// EX: (أنتن تُحَيِّينَ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();
        var root = triAugmentedConjugationResult.getRoot();
        return root.getC2() == root.getC3() && root.getC3() == 'ي' && kov == KindOfVerb.Lafeef_Maqroon && formulaNo == 2;
    }
}
