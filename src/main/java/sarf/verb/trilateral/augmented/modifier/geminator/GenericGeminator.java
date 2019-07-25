package sarf.verb.trilateral.augmented.modifier.geminator;

import sarf.verb.trilateral.augmented.ConjugationResult;
import sarf.verb.trilateral.augmented.*;
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
    private Map<String, SubstitutionsApplier> geminators = new HashMap<>();

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

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        switch (formulaNo) {
            case 6:
                return kov == 1 || kov == 6 || kov == KindOfVerb.Ajwaf_Wawi || kov == KindOfVerb.Ajwaf_Yaee;

            case 12:
                return kov == 1 || kov == KindOfVerb.Mithal_Wawi || kov == KindOfVerb.Ajwaf_Wawi || kov == KindOfVerb.Ajwaf_Yaee;
            case 1:
            case 4:
                return kov == 2;

            case 3:
            case 7:
                return kov == 2 || kov == 3 || kov == 8;
            case 5:
            case 9:
                return kov == 2 || kov == 3;
        }
        return false;
    }

    public void apply(String tense, boolean active, ConjugationResult conjResult) {
        SubstitutionsApplier geminator = geminators.get(tense + active);
        geminator.apply(conjResult.getFinalResult(), conjResult.getRoot());
    }
}
