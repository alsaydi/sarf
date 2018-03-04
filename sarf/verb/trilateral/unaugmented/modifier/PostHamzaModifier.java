package sarf.verb.trilateral.unaugmented.modifier;

import sarf.verb.trilateral.Substitution.SubstitutionsApplier;
import java.util.Map;
import java.util.HashMap;
import sarf.verb.trilateral.unaugmented.ConjugationResult;
import sarf.SystemConstants;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: يطبق خصيصاً لفعل أثأ لمعالجة حالة مهموز الفاء واللام         </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class PostHamzaModifier {
    private Map modifiersMap = new HashMap();

    public PostHamzaModifier() {
        //خمس أنواع  أساسية  للمهموز للمعلوم والمبني لمجهول في الماضي والمضارع والأمر
        modifiersMap.put(SystemConstants.PAST_TENSE + "true", new sarf.verb.trilateral.unaugmented.modifier.hamza.lam.ActivePastMahmouz());
        modifiersMap.put(SystemConstants.PRESENT_TENSE + "true", new sarf.verb.trilateral.unaugmented.modifier.hamza.lam.ActivePresentMahmouz());
        modifiersMap.put(SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE + "true", new sarf.verb.trilateral.unaugmented.modifier.hamza.lam.ImperativeMahmouz());
        modifiersMap.put(SystemConstants.EMPHASIZED_IMPERATIVE_TENSE + "true", new sarf.verb.trilateral.unaugmented.modifier.hamza.lam.ImperativeMahmouz());
        modifiersMap.put(SystemConstants.PAST_TENSE + "false", new sarf.verb.trilateral.unaugmented.modifier.hamza.lam.PassivePastMahmouz());
        modifiersMap.put(SystemConstants.PRESENT_TENSE + "false", new sarf.verb.trilateral.unaugmented.modifier.hamza.lam.PassivePresentMahmouz());
     }

    /**
     * تطبيق تغيير  الهمزة حسب الصيغة ماضي أو مضارع أو أمر للمعلوم أو لمجهول
     * قد لا يطبق أي نوع
     * @param tense String
     * @param active boolean
     * @param conjResult ConjugationResult
     */
    public void apply(String tense, boolean active, ConjugationResult conjResult) {
        if (conjResult.getKov() != 4)
            return;

        IUnaugmentedTrilateralModifier modifier = (IUnaugmentedTrilateralModifier) modifiersMap.get(tense+active);
        if (modifier.isApplied(conjResult)) {
            ((SubstitutionsApplier)modifier).apply(conjResult.getFinalResult(), conjResult.getRoot());
        }
    }

}
