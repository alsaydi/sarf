package sarf.verb.trilateral.augmented.modifier.substituter.active;

import java.util.*;

import sarf.KindOfVerb;
import sarf.verb.trilateral.Substitution.*;
import sarf.ConjugationResult;
import sarf.verb.trilateral.augmented.modifier.IAugmentedTrilateralModifier;

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
public class SpecialSubstituter2 extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public SpecialSubstituter2() {
        substitutions.add(new InfixSubstitution("يْتَ","تَّ"));// EX: (اتَّسَرَ، يَتَّسِرُ، اتَّسِرْ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();
        return triAugmentedConjugationResult.getRoot().getC1() == 'ي' && formulaNo == 5 && (kov == KindOfVerb.Mithal_Yaee_Mahmouz_Ain || kov == KindOfVerb.Mithal_Yaee);
    }
}
