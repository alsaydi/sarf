package sarf.verb.trilateral.unaugmented.modifier;

import java.util.List;

import sarf.KindOfVerb;
import sarf.VerbLamAlefModifier;
import sarf.verb.trilateral.augmented.ConjugationResult;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;

/**
 * <p>Title: Sarf Program</p>
 *المعالجة
 * <p>Description: يقوم بفحص واجراء التعديلات المناسبة على الأفعال الثلاثية المجردة
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
public class UnaugmentedTrilateralModifier {
    private final Geminator geminator = new Geminator();
    private final Vocalizer vocalizer = new Vocalizer();
    private final HamzaModifier hamzaModifier = new HamzaModifier();
    private final PostHamzaModifier postHamzaModifier = new PostHamzaModifier();
    private final VerbLamAlefModifier verbLamAlefModifier = new VerbLamAlefModifier();
    public UnaugmentedTrilateralModifier() {
    }

    /**
     * اخراج قائمة الأفعال بعد التعديلات
     * البدء بالادغام
     * @param root UnaugmentedTrilateralRoot
     * @param kov int
     * @param conjugations List
     * @param tense String (From SystemConstants class the values are stored)  ماضي أو مضارع او أمر
     * @return NounConjugationResult
     */
    public<T> ConjugationResult build(UnaugmentedTrilateralRoot root, KindOfVerb kov, List<T> conjugations, String tense, boolean active) {
        return build(root, kov, conjugations, tense, active, true);
    }

    public<T> ConjugationResult build(UnaugmentedTrilateralRoot root, KindOfVerb kov, List<T> conjugations, String tense, boolean active, boolean applyGemination) {
        ConjugationResult<T> conjResult = new ConjugationResult(kov, 0, root, conjugations);
        if (applyGemination)
            geminator.apply(tense, active, conjResult);
        vocalizer.apply(tense, active, conjResult);
        hamzaModifier.apply(tense, active, conjResult);
        //خصيصاُ للفعل أثأ
        postHamzaModifier.apply(tense, active, conjResult);
        verbLamAlefModifier.apply(conjResult);
        return conjResult;
    }
}
