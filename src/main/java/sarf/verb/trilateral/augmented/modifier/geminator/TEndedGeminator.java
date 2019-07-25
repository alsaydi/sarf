package sarf.verb.trilateral.augmented.modifier.geminator;

import sarf.verb.trilateral.Substitution.Substitution;
import sarf.verb.trilateral.augmented.*;
import sarf.verb.trilateral.augmented.modifier.IAugmentedTrilateralModifier;
import sarf.*;
import java.util.*;
import sarf.verb.trilateral.Substitution.InfixSubstitution;
import sarf.verb.trilateral.Substitution.SubstitutionsApplier;

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
public class TEndedGeminator extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private final List<Substitution> substitutions = new ArrayList<>();

    public TEndedGeminator() {
        substitutions.add(new InfixSubstitution("تْت", "تّ")); // EX: (أنا سَكَّتُّ ، أنتَ سَكَّتَّ ، أنتِ سَكَّتِّ )    }
    }

    public List getSubstitutions() {
        return substitutions;
    }


    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();
        if (conjugationResult.getRoot().getC3() != 'ت') return false;

        switch (formulaNo) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                if (kov == KindOfVerb.Salim || kov == KindOfVerb.Mudaaf || kov == KindOfVerb.Mahmouz_Faa_Mudaaf || kov == KindOfVerb.Mahmouz_Faa || kov == KindOfVerb.Mahmouz_Ain || kov == KindOfVerb.Mithal_Wawi || kov == KindOfVerb.Ajwaf_Wawi || kov == KindOfVerb.Ajwaf_Yaee) {
                    return true;
                }
        }
        return false;
    }

    public void apply(String tense, boolean active, ConjugationResult conjResult) {
        if (!tense.equals(SystemConstants.PAST_TENSE)) {
            return;
        }
        apply(conjResult.getFinalResult(), conjResult.getRoot());
    }
}
