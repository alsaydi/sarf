package sarf.verb.trilateral.unaugmented.modifier;

import sarf.verb.trilateral.Substitution.SubstitutionsApplier;
import java.util.*;
import sarf.SystemConstants;
import sarf.verb.trilateral.augmented.ConjugationResult;

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
public class HamzaModifier {
    private final Map<String, List<SubstitutionsApplier>> modifiersMap = new HashMap<>();

    HamzaModifier() {
        List<SubstitutionsApplier> activePastList = new ArrayList<>();
        List<SubstitutionsApplier> passivePastList = new ArrayList<>();
        List<SubstitutionsApplier> activePresentList = new ArrayList<>();
        List<SubstitutionsApplier> passivePresentList = new ArrayList<>();
        List<SubstitutionsApplier> imperativeList = new ArrayList<>();
        List<SubstitutionsApplier> emphasizedImperativeList = new ArrayList<>();

        //خمس أنواع  أساسية  للمهموز للمعلوم والمبني لمجهول في الماضي والمضارع والأمر
        modifiersMap.put(SystemConstants.PAST_TENSE + "true", activePastList);
        modifiersMap.put(SystemConstants.PRESENT_TENSE + "true", activePresentList);
        modifiersMap.put(SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE + "true", imperativeList);
        modifiersMap.put(SystemConstants.EMPHASIZED_IMPERATIVE_TENSE + "true", emphasizedImperativeList);
        modifiersMap.put(SystemConstants.PAST_TENSE + "false", passivePastList);
        modifiersMap.put(SystemConstants.PRESENT_TENSE + "false", passivePresentList);

        //قائمة الماضي المبني لمعلوم
        activePastList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.ein.ActivePastMahmouz());
        activePastList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.faa.ActivePastMahmouz());
        activePastList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.lam.ActivePastMahmouz());

        //قائمة الماضي المبني لمجهول
        passivePastList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.ein.PassivePastMahmouz());
        passivePastList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.faa.PassivePastMahmouz());
        passivePastList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.lam.PassivePastMahmouz());


        //قائمة المضارع المبني لمعلوم
        activePresentList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.ein.RaaPresentMahmouz());
        activePresentList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.ein.ActivePresentMahmouz());
        activePresentList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.faa.ActivePresentMahmouz());
        activePresentList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.lam.ActivePresentMahmouz());

        //قائمة المضارع المبني لمجهول
        passivePresentList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.ein.RaaPresentMahmouz());
        passivePresentList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.ein.PassivePresentMahmouz());
        passivePresentList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.faa.PassivePresentMahmouz());
        passivePresentList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.lam.PassivePresentMahmouz());

        //قائمة الأمر
        //وضع الحالات الخاصة أولاً
        imperativeList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.ein.RaaImperativeMahmouz());
        imperativeList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.faa.SpecialImperativeMahmouz1());
        imperativeList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.faa.SpecialImperativeMahmouz2());
        imperativeList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.ein.SpecialImperativeMahmouz());
        imperativeList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.ein.ImperativeMahmouz());
        imperativeList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.faa.ImperativeMahmouz());
        imperativeList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.lam.ImperativeMahmouz());

        //قائمة الأمر المؤكد
        emphasizedImperativeList.add(imperativeList.get(0));
        emphasizedImperativeList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.faa.SpecialEmphsizedImperativeMahmouz1());
        emphasizedImperativeList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.faa.SpecialEmphsizedImperativeMahmouz2());
        emphasizedImperativeList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.ein.SpecialEmphsizedImperativeMahmouz());
        emphasizedImperativeList.add(imperativeList.get(4));
        emphasizedImperativeList.add(imperativeList.get(5));
        emphasizedImperativeList.add(imperativeList.get(6));
    }

    /**
     * تطبيق تغيير  الهمزة حسب الصيغة ماضي أو مضارع أو أمر للمعلوم أو لمجهول
     * قد لا يطبق أي نوع
     * @param tense String
     * @param active boolean
     * @param conjResult NounConjugationResult
     */
    public void apply(String tense, boolean active, ConjugationResult conjResult) {
        var modifiers = modifiersMap.get(tense+active);
        for (SubstitutionsApplier o : modifiers) {
            IUnaugmentedTrilateralModifier modifier = (IUnaugmentedTrilateralModifier) o;
            if (modifier.isApplied(conjResult)) {
                o.apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
    }

}
