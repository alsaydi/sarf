package sarf.verb.quadriliteral.modifier;

import java.util.*;
import sarf.*;
import sarf.substitution.SubstitutionsApplier;

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
public class Geminator {
    //المعلوم  و  المجهول تحتوي قائمة بالأنواع الخمسة لادغام لماضي والمضارع والأمر حسب
    private final Map<String, List<SubstitutionsApplier>> modifiersMap = new HashMap<>();

    public Geminator() {
        List<SubstitutionsApplier> activePastList = new ArrayList<>();
        List<SubstitutionsApplier> passivePastList = new ArrayList<>();
        List<SubstitutionsApplier> activePresentList = new ArrayList<>();
        List<SubstitutionsApplier> passivePresentList = new ArrayList<>();
        List<SubstitutionsApplier> imperativeList = new ArrayList<>();

        //خمس أنواع  أساسية  للادغام للمعلوم والمبني لمجهول في الماضي والمضارع والأمر
        modifiersMap.put(SystemConstants.PAST_TENSE + "true", activePastList);
        modifiersMap.put(SystemConstants.PRESENT_TENSE + "true", activePresentList);
        modifiersMap.put(SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE + "true", imperativeList);
        modifiersMap.put(SystemConstants.EMPHASIZED_IMPERATIVE_TENSE + "true", imperativeList);
        modifiersMap.put(SystemConstants.PAST_TENSE + "false", passivePastList);
        modifiersMap.put(SystemConstants.PRESENT_TENSE + "false", passivePresentList);

        //قائمة الماضي المبني لمعلوم
        activePastList.add(new sarf.verb.quadriliteral.modifier.geminator.active.Past2Geminator());
        activePastList.add(new sarf.verb.quadriliteral.modifier.geminator.active.Past3Geminator());
        activePastList.add(new sarf.verb.quadriliteral.modifier.geminator.active.Past1Geminator());

        //قائمة الماضي المبني لمجهول
        passivePastList.add(new sarf.verb.quadriliteral.modifier.geminator.passive.Past2Geminator());
        passivePastList.add(new sarf.verb.quadriliteral.modifier.geminator.passive.Past3Geminator());
        passivePastList.add(new sarf.verb.quadriliteral.modifier.geminator.passive.Past1Geminator());

        //قائمة المضارع المبني لمعلوم
        activePresentList.add(new sarf.verb.quadriliteral.modifier.geminator.active.Present2Geminator());
        activePresentList.add(new sarf.verb.quadriliteral.modifier.geminator.active.Present1Geminator());

        //قائمة المضارع المبني لمجهول
        passivePresentList.add(new sarf.verb.quadriliteral.modifier.geminator.passive.Present2Geminator());
        passivePresentList.add(new sarf.verb.quadriliteral.modifier.geminator.passive.Present1Geminator());

        //قائمة الأمر
        imperativeList.add(new sarf.verb.quadriliteral.modifier.geminator.active.Imperative2Geminator());
        imperativeList.add(new sarf.verb.quadriliteral.modifier.geminator.active.Imperative1Geminator());
    }

    /**
     * تطبيق الادغام حسب الصيغة ماضي أو مضارع أو أمر للمعلوم أو لمجهول
     * قد لا يطبق أي نوع من الاعلال
     * @param tense String
     * @param active boolean
     * @param conjResult ConjugationResult
     */
    public void apply(String tense, boolean active, ConjugationResult conjResult) {
        var modifiers = modifiersMap.get(tense+active);
        for (SubstitutionsApplier substitutionsApplier : modifiers) {
            if (substitutionsApplier.isApplied(conjResult)) {
                substitutionsApplier.apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
    }
}
