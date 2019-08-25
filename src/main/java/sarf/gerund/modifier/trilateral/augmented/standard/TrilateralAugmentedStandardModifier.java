package sarf.gerund.modifier.trilateral.augmented.standard;

import com.google.inject.Inject;
import sarf.KindOfVerb;
import sarf.NounLamAlefModifier;
import sarf.NounSunLamModifier;
import sarf.noun.trilateral.augmented.modifier.Substituter;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;
import sarf.verb.trilateral.augmented.TriAugmentedConjugationResult;
import sarf.verb.trilateral.augmented.modifier.AugmentedTrilateralModifierListener;
import sarf.verb.trilateral.augmented.modifier.vocalizer.FormulaApplyingChecker;
import sarf.verb.trilateral.augmented.modifier.vocalizer.IFormulaApplyingChecker;

import java.util.List;

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
public class TrilateralAugmentedStandardModifier {
    private final Geminator geminator;
    private final Vocalizer vocalizer;
    private final Mahmouz mahmouz;
    private final Substituter substituter;
    private final FormulaApplyingChecker formulaApplyingChecker;
    private final NounLamAlefModifier nounLamAlefModifier;
    private final NounSunLamModifier nounSunLamModifier;

    @Inject
    public TrilateralAugmentedStandardModifier(Geminator geminator, Vocalizer vocalizer, Mahmouz mahmouz, Substituter substituter, FormulaApplyingChecker formulaApplyingChecker
            , NounLamAlefModifier nounLamAlefModifier, NounSunLamModifier nounSunLamModifier) {
        this.geminator = geminator;
        this.vocalizer = vocalizer;
        this.mahmouz = mahmouz;
        this.substituter = substituter;
        this.formulaApplyingChecker = formulaApplyingChecker;
        this.nounLamAlefModifier = nounLamAlefModifier;
        this.nounSunLamModifier = nounSunLamModifier;
    }

    public TriAugmentedConjugationResult build(AugmentedTrilateralRoot root, KindOfVerb kov, int formulaNo, List<String> conjugations, AugmentedTrilateralModifierListener listener) {
        TriAugmentedConjugationResult conjResult = new TriAugmentedConjugationResult<>(kov, formulaNo, root, conjugations);
        substituter.apply(conjResult);
        geminator.apply(conjResult);

        boolean applyVocalization = true;
        int result = formulaApplyingChecker.check(root, formulaNo);
        if (result == IFormulaApplyingChecker.NOT_VOCALIZED) {
            applyVocalization = false;
        } else if (result == IFormulaApplyingChecker.TWO_STATE && listener != null) {
            //asking the listener to apply or not the vocalization
            applyVocalization = listener.doSelectVocalization();
        }

        if (applyVocalization) {
            vocalizer.apply(conjResult);
        }

        mahmouz.apply(conjResult);
        nounLamAlefModifier.apply(conjResult);
        nounSunLamModifier.apply(conjResult);
        return conjResult;
    }
}
