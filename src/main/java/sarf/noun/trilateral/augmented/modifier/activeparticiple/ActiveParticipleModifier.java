package sarf.noun.trilateral.augmented.modifier.activeparticiple;

import java.util.List;

import com.google.inject.Inject;
import sarf.KindOfVerb;
import sarf.verb.trilateral.augmented.*;
import sarf.noun.trilateral.augmented.modifier.*;
import sarf.NounLamAlefModifier;
import sarf.NounSunLamModifier;
import sarf.verb.trilateral.augmented.modifier.vocalizer.IFormulaApplyingChecker;
import sarf.verb.trilateral.augmented.modifier.vocalizer.FormulaApplyingChecker;
import sarf.verb.trilateral.augmented.modifier.AugmentedTrilateralModifierListener;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: تطبيق المعالجة الخاصة على اسم الفاعل
 * ابتداء بالادغام ثم الاعلال واخيرا الهمزة
 * </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class ActiveParticipleModifier {
    private final Substituter substituter = new Substituter();
    private final Geminator geminator = new Geminator();
    private final Vocalizer vocalizer = new Vocalizer();
    private final Mahmouz mahmouz = new Mahmouz();
    private final FormulaApplyingChecker formulaApplyingChecker;

    @Inject
    public ActiveParticipleModifier(FormulaApplyingChecker formulaApplyingChecker) {
        this.formulaApplyingChecker = formulaApplyingChecker;
    }

    public ConjugationResult build(AugmentedTrilateralRoot root, KindOfVerb kov, int formulaNo, List conjugations, AugmentedTrilateralModifierListener listener) {
        ConjugationResult conjResult = new ConjugationResult(kov, formulaNo, root, conjugations);
        substituter.apply(conjResult);
        geminator.apply(conjResult);

        boolean applyVocalization = true;
        int result = formulaApplyingChecker.check(root, formulaNo);
        if (result == IFormulaApplyingChecker.NOT_VOCALIZED) {
            applyVocalization = false;
        } else if (result == IFormulaApplyingChecker.TWO_STATE) {
            if (listener == null)
                applyVocalization = true;
            else
                //asking the listener to apply or not the vocaliztion
                applyVocalization = listener.doSelectVocalization();
        }

        if (applyVocalization) {
            vocalizer.apply(conjResult);
        }


        mahmouz.apply(conjResult);
        NounLamAlefModifier.getInstance().apply(conjResult);
        NounSunLamModifier.getInstance().apply(conjResult);
        return conjResult;
    }
}

