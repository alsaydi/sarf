package sarf.noun.trilateral.augmented.modifier.activeparticiple.geminator;

import sarf.KindOfVerb;
import sarf.noun.TrilateralNounSubstitutionApplier;
import sarf.verb.trilateral.Substitution.ExpressionInfixSubstitution;
import sarf.verb.trilateral.Substitution.Substitution;
import sarf.verb.trilateral.augmented.TriAugmentedConjugationResult;
import sarf.verb.trilateral.augmented.modifier.IAugmentedTrilateralModifier;

import java.util.ArrayList;
import java.util.List;

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
public class Geminator1 extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Geminator1() {
        substitutions.add(new ExpressionInfixSubstitution("ْC3ِC3", "ِC3ّ")); // EX: (مُحِبٌّ، مُسْتَحِبٌّ)
        substitutions.add(new ExpressionInfixSubstitution("C3ِC3", "C3ّ")); // EX: (مُحاجٌّ، مُنْقَضٌّ، مُشْتَدٌّ، مُتَصامٌّ)
    }

    public boolean isApplied(TriAugmentedConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        if (kov == KindOfVerb.Salim || kov == KindOfVerb.Ajwaf_Wawi || kov == KindOfVerb.Ajwaf_Yaee) {
            return formulaNo == 6 || formulaNo == 12;
        } else if (kov == KindOfVerb.Mahmouz_Ain) {
            return formulaNo == 6;
        } else if (kov == KindOfVerb.Mithal_Wawi) {
            return formulaNo == 12;
        } else if (kov == KindOfVerb.Mudaaf) {
            switch (formulaNo) {
                case 1:
                case 3:
                case 4:
                case 5:
                case 7:
                case 9:
                    return true;
            }
            return false;
        } else if (kov == KindOfVerb.Mahmouz_Faa_Mudaaf) {
            switch (formulaNo) {
                case 3:
                case 5:
                case 7:
                case 9:
                    return true;
            }
            return false;
        } else if (kov == KindOfVerb.Mithal_Wawi_Mudaaf) {
            return formulaNo == 3 || formulaNo == 7;
        }
        return false;
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
