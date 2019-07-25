package sarf.verb.trilateral.augmented.modifier;

import sarf.verb.trilateral.Substitution.SubstitutionsApplier;
import java.util.Map;
import java.util.HashMap;
import sarf.verb.trilateral.augmented.ConjugationResult;
import sarf.SystemConstants;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

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
    private final Map modifiersMap = new HashMap();

    public HamzaModifier() {
        List activePastList = new LinkedList();
        List passivePastList = new LinkedList();
        List activePresentList = new LinkedList();
        List passivePresentList = new LinkedList();
        List imperativeList = new LinkedList();

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
        List modifiers = (List) modifiersMap.get(tense+active);
        Iterator iter = modifiers.iterator();
        while (iter.hasNext()) {
            IAugmentedTrilateralModifier modifier = (IAugmentedTrilateralModifier) iter.next();
            if (modifier.isApplied(conjResult)) {
                ((SubstitutionsApplier)modifier).apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
    }

}
