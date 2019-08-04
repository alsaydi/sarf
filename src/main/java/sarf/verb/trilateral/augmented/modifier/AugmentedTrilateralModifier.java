package sarf.verb.trilateral.augmented.modifier;

import java.util.*;

import com.google.inject.Inject;
import sarf.*;
import sarf.verb.trilateral.augmented.*;
import sarf.verb.trilateral.augmented.modifier.vocalizer.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: يقوم بفحص واجراء التعديلات المناسبة على الأفعال الثلاثية المزيدة
 * بما فيها الاعلال والابدال والهمزة
 * حسب الصيغة ماضي أو مضارع او أمر
 * </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class AugmentedTrilateralModifier {
    private final FormulaApplyingChecker formulaApplyingChecker;

    @Inject
    public AugmentedTrilateralModifier(FormulaApplyingChecker formulaApplyingChecker) {
        this.formulaApplyingChecker = formulaApplyingChecker;
    }
    //الابدال
    private final Substituter substituter = new Substituter();
    private final Geminator geminator = new Geminator();
    private final Vocalizer vocalizer = new Vocalizer();
    private final PreVocalizer preVocalizer = new PreVocalizer();
    private final HamzaModifier hamzaModifier = new HamzaModifier();

    /**
     * اخراج قائمة الأفعال بعد التعديلات
     * البدء بالابدال
     * @param root UnaugmentedTrilateralRoot
     * @param kov int
     * @param conjugations List
     * @param tense String (From SystemConstans class the values are stored)  ماضي أو مضارع او أمر
     * @return ConjugationResult
     */
    public ConjugationResult build(AugmentedTrilateralRoot root, KindOfVerb kov, int formulaNo, List conjugations, String tense, boolean active, boolean applyGemination, AugmentedTrilateralModifierListener listener) {
        ConjugationResult conjResult = new ConjugationResult(kov, formulaNo, root, conjugations);
        substituter.apply(tense, active, conjResult);
        if (applyGemination) {
            geminator.apply(tense, active, conjResult);
        }

        boolean applyVocalization = true;
        int result = formulaApplyingChecker.check(root, formulaNo);
        if (result == IFormulaApplyingChecker.NOT_VOCALIZED) {
            applyVocalization = false;
        }
        else if (result == IFormulaApplyingChecker.TWO_STATE) {
            if (listener == null)
                applyVocalization = true;
            else
                //asking the listener to apply or not the vocaliztion
                applyVocalization = listener.doSelectVocalization();
        }

        if (applyVocalization) {
            preVocalizer.apply(tense, active, conjResult);
            vocalizer.apply(tense, active, conjResult);
        }

        hamzaModifier.apply(tense, active, conjResult);
        VerbLamAlefModifier.getInstance().apply(conjResult);
        return conjResult;
    }

    public ConjugationResult build(AugmentedTrilateralRoot root, KindOfVerb kov, int formulaNo, List conjugations, String tense, boolean active, AugmentedTrilateralModifierListener listener) {
        return build(root, kov, formulaNo, conjugations, tense, active, true, listener);
    }

}
