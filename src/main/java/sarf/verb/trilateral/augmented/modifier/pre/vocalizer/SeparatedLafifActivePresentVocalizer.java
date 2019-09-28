package sarf.verb.trilateral.augmented.modifier.pre.vocalizer;

import java.util.*;

import sarf.KindOfVerb;
import sarf.verb.trilateral.Substitution.*;
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
public class SeparatedLafifActivePresentVocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public SeparatedLafifActivePresentVocalizer() {
        substitutions.add(new InfixSubstitution("ُوْ", "ُو")); // EX: (يُوصِي)
        substitutions.add(new InfixSubstitution("ُيْ", "ُو")); // EX: (يُودِي)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        return kov == KindOfVerb.Lafeef_Mafrooq  && formulaNo == 1;
    }
}
