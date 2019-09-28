package sarf.verb.trilateral.augmented.modifier.geminator;

import sarf.substitution.Substitution;
import sarf.verb.trilateral.augmented.modifier.IAugmentedTrilateralModifier;
import sarf.*;
import java.util.*;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.SubstitutionsApplier;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: الذي ينتهي بالتاء  </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class TStartedGeminator extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public TStartedGeminator() {
        substitutions.add(new InfixSubstitution("تْت","تّ"));// EX: (اتَّبَعَ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }


    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();
        return triAugmentedConjugationResult.getRoot().getC1() == 'ت' && (kov == KindOfVerb.Salim || kov == KindOfVerb.Mahmouz_Ain) && (formulaNo == 5);
    }

    public void apply(String tense, boolean active, ConjugationResult conjResult) {
        apply(conjResult.getFinalResult(), conjResult.getRoot());
    }
}
