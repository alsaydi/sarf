package sarf.verb.trilateral.augmented.modifier;

import sarf.verb.trilateral.augmented.modifier.geminator.*;
import sarf.verb.trilateral.augmented.ConjugationResult;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: This is the facade for gemination subsystem
 * هو الصف المسؤول عن عملية الادغام بكل حالاتها
 *حيث يتخاطب مع الصفوف الموجودة في حزمة الادغام
 * </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class Geminator {
    //ادغام العام
    private GenericGeminator genericGeminator = new GenericGeminator();
    //ادغام المنتهي بحرف النون
    private NEndedGeminator nEndedGeminator = new NEndedGeminator();
    //ادغام المبتدأ بحرف النون
    private NStartedGeminator nStartedGeminator = new NStartedGeminator();

    //ادغام المنتهي بحرف التاء
    private TEndedGeminator tEndedGeminator = new TEndedGeminator();
    //ادغام المبتدأ بحرف التاء
    private TStartedGeminator tStartedGeminator = new TStartedGeminator();

    public Geminator() {
    }

    /**
     * تطبيق الادغام حسب الصيغة ماضي أو مضارع أو أمر للمعلوم أو لمجهول
     * تجريب الحالات الخاصة قبل الحالة العامة
     * قد لا يطبق أي نوع من الادغام
     * @param tense String
     * @param active boolean
     * @param conjResult ConjugationResult
     */
    public void apply(String tense, boolean active, ConjugationResult conjResult) {
        //althoug it will enter the generic block, it may found some rules in the special ones
        if (genericGeminator.isApplied(conjResult))
            genericGeminator.apply(tense, active, conjResult);

        if (tStartedGeminator.isApplied(conjResult))
            tStartedGeminator.apply(tense, active, conjResult);

        if (tEndedGeminator.isApplied(conjResult))
            tEndedGeminator.apply(tense, active, conjResult);

        if (nStartedGeminator.isApplied(conjResult))
            nStartedGeminator.apply(tense, active, conjResult);

        if (nEndedGeminator.isApplied(conjResult))
            nEndedGeminator.apply(tense, active, conjResult);
    }

}
