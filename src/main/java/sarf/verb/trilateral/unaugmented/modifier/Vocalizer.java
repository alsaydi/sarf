
package sarf.verb.trilateral.unaugmented.modifier;

import sarf.ConjugationResult;
import sarf.SystemConstants;
import sarf.substitution.SubstitutionsApplier;
import sarf.verb.trilateral.unaugmented.modifier.vocalizer.mithal.ActivePresentVocalizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class Vocalizer {
    //المعلوم  و  المجهول تحتوي قائمة بالأنواع الخمسة لاعلال لماضي والمضارع والأمر حسب
    private final Map<String, List<SubstitutionsApplier>> vocalizerMap = new HashMap<>();

    public Vocalizer() {
        List<SubstitutionsApplier> activePastList = new ArrayList<>();
        List<SubstitutionsApplier> passivePastList = new ArrayList<>();
        List<SubstitutionsApplier> activePresentList = new ArrayList<>();
        List<SubstitutionsApplier> passivePresentList = new ArrayList<>();
        List<SubstitutionsApplier> imperativeList = new ArrayList<>();

        //خمس أنواع  أساسية  للاعلال للمعلوم والمبني لمجهول في الماضي والمضارع والأمر
        vocalizerMap.put(SystemConstants.PAST_TENSE + "true", activePastList);
        vocalizerMap.put(SystemConstants.PRESENT_TENSE + "true", activePresentList);
        vocalizerMap.put(SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE + "true", imperativeList);
        vocalizerMap.put(SystemConstants.EMPHASIZED_IMPERATIVE_TENSE + "true", imperativeList);
        vocalizerMap.put(SystemConstants.PAST_TENSE + "false", passivePastList);
        vocalizerMap.put(SystemConstants.PRESENT_TENSE + "false", passivePresentList);

        //قائمة الماضي المبني لمعلوم
        activePastList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.wawi.ActivePastAjwafWawiListedVocalizer());
        activePastList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.wawi.ActivePastAjwafWawiVocalizer());
        activePastList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.yaei.ActivePastAjwafYaeiListedVocalizer());
        activePastList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.yaei.ActivePastAjwafYaeiVocalizer());
        activePastList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.nakes.wawi.active.Past1Vocalizer());
        activePastList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.nakes.wawi.active.Past2Vocalizer());
        activePastList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.nakes.wawi.active.Past3Vocalizer());
        activePastList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.nakes.wawi.active.Past4Vocalizer());
        activePastList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.nakes.yaei.active.Past1Vocalizer());
        activePastList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.nakes.yaei.active.Past2Vocalizer());
        activePastList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.lafif.connected.ActivePast1Vocalizer());
        activePastList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.lafif.connected.ActivePast2Vocalizer());
        activePastList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.lafif.separeted.ActivePast1Vocalizer());
        activePastList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.lafif.separeted.ActivePast2Vocalizer());

        //قائمة الماضي المبني لمجهول
        passivePastList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.wawi.PassivePastAjwafWawiListedVocalizer());
        passivePastList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.wawi.PassivePastAjwafWawiVocalizer());
        passivePastList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.yaei.PassivePastAjwafYaeiListedVocalizer());
        passivePastList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.yaei.PassivePastAjwafYaeiVocalizer());
        passivePastList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.nakes.wawi.passive.PastVocalizer());
        passivePastList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.nakes.yaei.passive.PastVocalizer());
        passivePastList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.lafif.connected.PassivePastVocalizer());
        passivePastList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.lafif.separeted.PassivePastVocalizer());

        //قائمة المضارع المبني لمعلوم
        activePresentList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.wawi.ActivePresentAjwafWawiListedVocalizer());
        activePresentList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.wawi.ActivePresentAjwafWawiVocalizer());
        activePresentList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.yaei.ActivePresentAjwafYaeiListedVocalizer());
        activePresentList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.yaei.ActivePresentAjwafYaeiVocalizer());
        activePresentList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.nakes.wawi.active.PresentVocalizer());
        activePresentList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.nakes.yaei.active.PresentVocalizer());
        activePresentList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.lafif.connected.ActivePresentVocalizer());
        activePresentList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.lafif.separeted.ActivePresent1Vocalizer());
        activePresentList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.lafif.separeted.ActivePresent2Vocalizer());
        activePresentList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.lafif.separeted.ActivePresent3Vocalizer());
        activePresentList.add(new ActivePresentVocalizer());

        //قائمة المضارع المبني لمجهول
        passivePresentList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.wawi.PassivePresentAjwafWawiListedVocalizer());
        passivePresentList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.wawi.PassivePresentAjwafWawiVocalizer());
        passivePresentList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.yaei.PassivePresentAjwafYaeiListedVocalizer());
        passivePresentList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.yaei.PassivePresentAjwafYaeiVocalizer());
        passivePresentList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.nakes.wawi.passive.PresentVocalizer());
        passivePresentList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.nakes.yaei.passive.PresentVocalizer());
        passivePresentList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.lafif.connected.PassivePresentVocalizer());
        passivePresentList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.lafif.separeted.WawiPassivePresentVocalizer());
        passivePresentList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.lafif.separeted.YaeiPassivePresentVocalizer());
        passivePresentList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.mithal.WawiPassivePresentVocalizer());
        passivePresentList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.mithal.YaeiPassivePresentVocalizer());

        //قائمة الأمر
        imperativeList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.wawi.ImperativeAjwafWawiListedVocalizer());
        imperativeList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.wawi.ImperativeAjwafWawiVocalizer());
        imperativeList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.yaei.ImperativeAjwafYaeiListedVocalizer());
        imperativeList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.yaei.ImperativeAjwafYaeiVocalizer());
        imperativeList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.nakes.wawi.active.ImperativeVocalizer());
        imperativeList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.nakes.yaei.active.ImperativeVocalizer());
        imperativeList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.lafif.connected.ImperativeVocalizer());
        imperativeList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.lafif.separeted.Imperative1Vocalizer());
        imperativeList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.lafif.separeted.Imperative2Vocalizer());
        imperativeList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.lafif.separeted.Imperative3Vocalizer());
        imperativeList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.mithal.Imperative1Vocalizer());
        imperativeList.add(new sarf.verb.trilateral.unaugmented.modifier.vocalizer.mithal.Imperative2Vocalizer());
    }

    /**
     * تطبيق الاعلال حسب الصيغة ماضي أو مضارع أو أمر للمعلوم أو لمجهول
     * قد لا يطبق أي نوع من الاعلال
     *
     * @param tense      String
     * @param active     boolean
     * @param conjResult NounConjugationResult
     */
    public void apply(String tense, boolean active, ConjugationResult conjResult) {
        var vocalizers = vocalizerMap.get(tense + active);
        for (var vocalizer : vocalizers) {
            if (vocalizer.isApplied(conjResult)) {
                vocalizer.apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
    }
}
