package sarf.verb.trilateral.augmented.modifier.geminator;

import sarf.substitution.SubstitutionsApplier;
import sarf.verb.trilateral.augmented.modifier.IAugmentedTrilateralModifier;
import sarf.*;
import java.util.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.geminator.generic.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: الحالة العامة للادغام  </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class GenericGeminator implements IAugmentedTrilateralModifier {
    private final Map<String, SubstitutionsApplier> geminators = new HashMap<>();

    public GenericGeminator() {
        //خمس أنواع للادغام للمعلوم والمبني لمجهول في الماضي والمضارع والأمر
        geminators.put(SystemConstants.PAST_TENSE + "true", new ActivePastGeminator());
        geminators.put(SystemConstants.PRESENT_TENSE + "true", new ActivePresentGeminator());
        ImperativeGeminator imperativeGeminator = new ImperativeGeminator();
        geminators.put(SystemConstants.EMPHASIZED_IMPERATIVE_TENSE + "true", imperativeGeminator);
        geminators.put(SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE + "true", imperativeGeminator);
        geminators.put(SystemConstants.PAST_TENSE + "false", new PassivePastGeminator());
        geminators.put(SystemConstants.PRESENT_TENSE + "false", new PassivePresentGeminator());
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        switch (formulaNo) {
            case 6:
                return kov == KindOfVerb.Salim || kov == KindOfVerb.Mahmouz_Ain || kov == KindOfVerb.Ajwaf_Wawi || kov == KindOfVerb.Ajwaf_Yaee;

            case 12:
                return kov == KindOfVerb.Salim || kov == KindOfVerb.Mithal_Wawi || kov == KindOfVerb.Ajwaf_Wawi || kov == KindOfVerb.Ajwaf_Yaee;
            case 1:
            case 4:
                return kov == KindOfVerb.Mudaaf;

            case 3:
            case 7:
                return kov == KindOfVerb.Mudaaf || kov == KindOfVerb.Mahmouz_Faa_Mudaaf || kov == KindOfVerb.Mithal_Wawi_Mudaaf;
            case 5:
            case 9:
                return kov == KindOfVerb.Mudaaf || kov == KindOfVerb.Mahmouz_Faa_Mudaaf;
        }
        return false;
    }

    public void apply(String tense, boolean active, ConjugationResult conjResult) {
        SubstitutionsApplier geminator = geminators.get(tense + active);
        geminator.apply(conjResult.getFinalResult(), conjResult.getRoot());
    }
}
