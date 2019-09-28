package sarf.verb.trilateral.unaugmented.modifier;

import sarf.verb.trilateral.augmented.ConjugationResult;
import sarf.verb.trilateral.unaugmented.modifier.geminator.*;

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
    private final GenericGeminator genericGeminator = new GenericGeminator();
    //ادغام المنتهي بحرف النون
    private final NGeminator nGeminator = new NGeminator();
    //ادغام المنتهي بحرف التاء
    private final TGeminator tGeminator = new TGeminator();

    public Geminator() {
    }

    /**
     * تطبيق الادغام حسب الصيغة ماضي أو مضارع أو أمر للمعلوم أو لمجهول
     * قد لا يطبق أي نوع من الادغام
     * @param tense String
     * @param active boolean
     * @param conjResult NounConjugationResult
     */
    public void apply(String tense, boolean active, ConjugationResult conjResult) {
        if (genericGeminator.isApplied(conjResult))
            genericGeminator.apply(tense, active, conjResult);
        //else
        if (tGeminator.isApplied(conjResult))
            tGeminator.apply(tense, active, conjResult);
        //else
        if (nGeminator.isApplied(conjResult))
            nGeminator.apply(tense, active, conjResult);
    }
}
