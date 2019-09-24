package sarf.verb.quadriliteral.modifier;

import java.util.*;

import sarf.verb.quadriliteral.*;
import sarf.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: يقوم بفحص واجراء التعديلات المناسبة على الأفعال الرباعية
 * بما فيها الاعلال والادغام والهمزة
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
public class QuadrilateralModifier {

    public QuadrilateralModifier() {
    }

    private final Geminator geminator = new Geminator();
    private final Vocalizer vocalizer = new Vocalizer();
    private final InternalMahmouz internalMahmouz = new InternalMahmouz();
    private final EndedMahmouz endedMahmouz = new EndedMahmouz();
    private final VerbLamAlefModifier verbLamAlefModifier = new VerbLamAlefModifier();

    /**
     * اخراج قائمة الأفعال بعد التعديلات
     * @param root UnaugmentedTrilateralRoot
     * @param conjugations List
     * @param tense String (From SystemConstants class the values are stored)  ماضي أو مضارع او أمر
     * @return QuadriConjugationResult
     */
    public QuadriConjugationResult build(QuadrilateralRoot root, int formulaNo, KindOfVerb kov, List conjugations, String tense, boolean active, boolean applyGemination) {
        QuadriConjugationResult conjResult = new QuadriConjugationResult(formulaNo, kov, root, conjugations);
        if (applyGemination)
            geminator.apply(tense, active, conjResult);
        vocalizer.apply(tense, active, conjResult);
        internalMahmouz.apply(tense, active, conjResult);
        endedMahmouz.apply(tense, active, conjResult);
        verbLamAlefModifier.apply(conjResult);
        return conjResult;
    }

    public QuadriConjugationResult build(QuadrilateralRoot root, int formulaNo, KindOfVerb kov, List conjugations, String tense, boolean active) {
        return build(root, formulaNo, kov, conjugations, tense, active, true);
    }
}
