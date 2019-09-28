package sarf.verb.trilateral.augmented.modifier;

import sarf.substitution.SubstitutionsApplier;

import java.util.*;

import sarf.ConjugationResult;
import sarf.SystemConstants;

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

        //خمس أنواع  أساسية  للمهموز للمعلوم والمبني لمجهول في الماضي والمضارع والأمر
        modifiersMap.put(SystemConstants.PAST_TENSE + "true", activePastList);
        modifiersMap.put(SystemConstants.PRESENT_TENSE + "true", activePresentList);
        modifiersMap.put(SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE + "true", imperativeList);
        modifiersMap.put(SystemConstants.EMPHASIZED_IMPERATIVE_TENSE + "true", imperativeList);
        modifiersMap.put(SystemConstants.PAST_TENSE + "false", passivePastList);
        modifiersMap.put(SystemConstants.PRESENT_TENSE + "false", passivePresentList);

        //قائمة الماضي المبني لمعلوم
        activePastList.add(new sarf.verb.trilateral.augmented.modifier.hamza.ein.active.RaaPastMahmouz());
        activePastList.add(new sarf.verb.trilateral.augmented.modifier.hamza.ein.active.PastMahmouz());
        activePastList.add(new sarf.verb.trilateral.augmented.modifier.hamza.faa.active.PastMahmouz());
        activePastList.add(new sarf.verb.trilateral.augmented.modifier.hamza.lam.active.PastMahmouz());

        //قائمة الماضي المبني لمجهول
        passivePastList.add(new sarf.verb.trilateral.augmented.modifier.hamza.ein.passive.RaaPastMahmouz());
        passivePastList.add(new sarf.verb.trilateral.augmented.modifier.hamza.ein.passive.PastMahmouz());
        passivePastList.add(new sarf.verb.trilateral.augmented.modifier.hamza.faa.passive.PastMahmouz());
        passivePastList.add(new sarf.verb.trilateral.augmented.modifier.hamza.lam.passive.PastMahmouz());


        //قائمة المضارع المبني لمعلوم
        activePresentList.add(new sarf.verb.trilateral.augmented.modifier.hamza.ein.active.RaaPresentMahmouz());
        activePresentList.add(new sarf.verb.trilateral.augmented.modifier.hamza.ein.active.PresentMahmouz());
        activePresentList.add(new sarf.verb.trilateral.augmented.modifier.hamza.faa.active.PresentMahmouz());
        activePresentList.add(new sarf.verb.trilateral.augmented.modifier.hamza.lam.active.PresentMahmouz());


        //قائمة المضارع المبني لمجهول
        passivePresentList.add(new sarf.verb.trilateral.augmented.modifier.hamza.ein.passive.RaaPresentMahmouz());
        passivePresentList.add(new sarf.verb.trilateral.augmented.modifier.hamza.ein.passive.PresentMahmouz());
        passivePresentList.add(new sarf.verb.trilateral.augmented.modifier.hamza.faa.passive.PresentMahmouz());
        passivePresentList.add(new sarf.verb.trilateral.augmented.modifier.hamza.lam.passive.PresentMahmouz());

        //قائمة الأمر
        imperativeList.add(new sarf.verb.trilateral.augmented.modifier.hamza.ein.active.RaaImperativeMahmouz());
        imperativeList.add(new sarf.verb.trilateral.augmented.modifier.hamza.ein.active.ImperativeMahmouz());
        imperativeList.add(new sarf.verb.trilateral.augmented.modifier.hamza.faa.active.ImperativeMahmouz());
        imperativeList.add(new sarf.verb.trilateral.augmented.modifier.hamza.lam.active.ImperativeMahmouz());
    }

    /**
     * تطبيق تغيير  الهمزة حسب الصيغة ماضي أو مضارع أو أمر للمعلوم أو لمجهول
     * قد لا يطبق أي نوع
     * @param tense String
     * @param active boolean
     * @param conjResult ConjugationResult
     */
    public void apply(String tense, boolean active, ConjugationResult conjResult) {
        List<SubstitutionsApplier> modifiers = modifiersMap.get(tense+active);
        for (SubstitutionsApplier o : modifiers) {
            IAugmentedTrilateralModifier modifier = (IAugmentedTrilateralModifier) o;
            if (modifier.isApplied(conjResult)) {
                o.apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
    }

}
