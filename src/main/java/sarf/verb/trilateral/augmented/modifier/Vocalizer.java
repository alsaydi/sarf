package sarf.verb.trilateral.augmented.modifier;

import sarf.verb.trilateral.augmented.ConjugationResult;
import java.util.*;
import sarf.*;
import sarf.verb.trilateral.Substitution.SubstitutionsApplier;

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
    private Map vocalizerMap = new HashMap();

    public Vocalizer() {
        List activePastList = new LinkedList();
        List passivePastList = new LinkedList();
        List activePresentList = new LinkedList();
        List passivePresentList = new LinkedList();
        List imperativeList = new LinkedList();

        //خمس أنواع  أساسية  للاعلال للمعلوم والمبني لمجهول في الماضي والمضارع والأمر
        vocalizerMap.put(SystemConstants.PAST_TENSE + "true", activePastList);
        vocalizerMap.put(SystemConstants.PRESENT_TENSE + "true", activePresentList);
        vocalizerMap.put(SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE + "true", imperativeList);
        vocalizerMap.put(SystemConstants.EMPHASIZED_IMPERATIVE_TENSE + "true", imperativeList);
        vocalizerMap.put(SystemConstants.PAST_TENSE + "false", passivePastList);
        vocalizerMap.put(SystemConstants.PRESENT_TENSE + "false", passivePresentList);

        //قائمة الماضي المبني لمعلوم
        activePastList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.ajwaf.wawi.active.Past1Vocalizer());
        activePastList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.ajwaf.wawi.active.Past2Vocalizer());
        activePastList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.ajwaf.yaei.active.Past1Vocalizer());
        activePastList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.ajwaf.yaei.active.Past2Vocalizer());
        activePastList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.wawi.active.PastVocalizer());
        activePastList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.yaei.active.PastVocalizer());
        activePastList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.active.Past1Vocalizer());
        activePastList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.active.Past2Vocalizer());
        activePastList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.active.Past3Vocalizer());
        activePastList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.separated.active.PastVocalizer());

        //قائمة الماضي المبني لمجهول
        passivePastList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.ajwaf.wawi.passive.PastVocalizer());
        passivePastList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.ajwaf.yaei.passive.PastVocalizer());
        passivePastList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.wawi.passive.Past1Vocalizer());
        passivePastList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.wawi.passive.Past2Vocalizer());
        passivePastList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.wawi.passive.Past3Vocalizer());
        passivePastList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.yaei.passive.PastVocalizer());
        passivePastList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.passive.Past1Vocalizer());
        passivePastList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.passive.Past2Vocalizer());
        passivePastList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.separated.passive.WawiPastVocalizer());
        passivePastList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.separated.passive.YaeiPastVocalizer());
        passivePastList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.mithal.YaeiVocalizer());
        passivePastList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.mithal.WawiVocalizer());

        //قائمة المضارع المبني لمعلوم
        activePresentList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.ajwaf.wawi.active.Present1Vocalizer());
        activePresentList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.ajwaf.wawi.active.Present2Vocalizer());
        activePresentList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.ajwaf.yaei.active.Present1Vocalizer());
        activePresentList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.ajwaf.yaei.active.Present2Vocalizer());
        activePresentList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.wawi.active.Present1Vocalizer());
        activePresentList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.wawi.active.Present2Vocalizer());
        activePresentList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.wawi.active.Present3Vocalizer());
        activePresentList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.yaei.active.Present1Vocalizer());
        activePresentList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.yaei.active.Present2Vocalizer());
        activePresentList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.yaei.active.Present3Vocalizer());
        activePresentList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.active.Present1Vocalizer());
        activePresentList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.active.Present2Vocalizer());
        activePresentList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.active.Present3Vocalizer());
        activePresentList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.active.Present4Vocalizer());
        activePresentList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.active.Present5Vocalizer());
        activePresentList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.active.Present6Vocalizer());
        activePresentList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.active.Present7Vocalizer());
        activePresentList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.active.Present8Vocalizer());
        activePresentList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.active.Present9Vocalizer());
        activePresentList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.separated.active.Present1Vocalizer());
        activePresentList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.separated.active.Present2Vocalizer());
        activePresentList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.separated.active.Present3Vocalizer());
        activePresentList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.mithal.YaeiVocalizer());
        activePresentList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.mithal.WawiVocalizer());

        //قائمة المضارع المبني لمجهول
        passivePresentList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.ajwaf.wawi.passive.Present1Vocalizer());
        passivePresentList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.ajwaf.wawi.passive.Present2Vocalizer());
        passivePresentList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.ajwaf.yaei.passive.Present1Vocalizer());
        passivePresentList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.ajwaf.yaei.passive.Present2Vocalizer());
        passivePresentList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.wawi.passive.PresentVocalizer());
        passivePresentList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.yaei.passive.PresentVocalizer());
        passivePresentList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.passive.Present1Vocalizer());
        passivePresentList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.passive.Present2Vocalizer());
        passivePresentList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.passive.Present3Vocalizer());
        passivePresentList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.separated.passive.PresentVocalizer());
        passivePresentList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.mithal.YaeiVocalizer());
        passivePresentList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.mithal.WawiVocalizer());

        //قائمة الأمر
        imperativeList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.ajwaf.wawi.active.Imperative1Vocalizer());
        imperativeList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.ajwaf.wawi.active.Imperative2Vocalizer());
        imperativeList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.ajwaf.yaei.active.Imperative1Vocalizer());
        imperativeList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.ajwaf.yaei.active.Imperative2Vocalizer());
        imperativeList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.wawi.active.Imperative1Vocalizer());
        imperativeList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.wawi.active.Imperative2Vocalizer());
        imperativeList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.wawi.active.Imperative3Vocalizer());
        imperativeList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.yaei.active.Imperative1Vocalizer());
        imperativeList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.yaei.active.Imperative2Vocalizer());
        imperativeList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.yaei.active.Imperative3Vocalizer());
        imperativeList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.active.Imperative1Vocalizer());
        imperativeList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.active.Imperative2Vocalizer());
        imperativeList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.active.Imperative3Vocalizer());
        imperativeList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.active.Imperative4Vocalizer());
        imperativeList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.active.Imperative5Vocalizer());
        imperativeList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.active.Imperative6Vocalizer());
        imperativeList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.separated.active.Imperative1Vocalizer());
        imperativeList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.separated.active.Imperative2Vocalizer());
        imperativeList.add(new sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.separated.active.Imperative3Vocalizer());
    }

    /**
     * تطبيق الاعلال حسب الصيغة ماضي أو مضارع أو أمر للمعلوم أو لمجهول
     * قد لا يطبق أي نوع من الاعلال
     * @param tense String
     * @param active boolean
     * @param conjResult ConjugationResult
     */
    public void apply(String tense, boolean active, ConjugationResult conjResult) {
        List vocalizers = (List) vocalizerMap.get(tense+active);
        for (Object o : vocalizers) {
            IAugmentedTrilateralModifier vocalizer = (IAugmentedTrilateralModifier) o;
            if (vocalizer.isApplied(conjResult)) {
                ((SubstitutionsApplier) vocalizer).apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
    }

}
