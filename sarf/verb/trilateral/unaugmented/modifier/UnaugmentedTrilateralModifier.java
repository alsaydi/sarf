package sarf.verb.trilateral.unaugmented.modifier;

import sarf.verb.trilateral.unaugmented.*;
import java.util.*;
import sarf.verb.trilateral.unaugmented.modifier.geminator.*;
import sarf.*;

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
    private Geminator geminator = new Geminator();
    private Vocalizer vocalizer = new Vocalizer();
    private HamzaModifier hamzaModifier = new HamzaModifier();
    private PostHamzaModifier postHamzaModifier = new PostHamzaModifier();

    private UnaugmentedTrilateralModifier() {
    }

    private static UnaugmentedTrilateralModifier instance = new UnaugmentedTrilateralModifier();

    public static UnaugmentedTrilateralModifier getInstance() {
        return instance;
    }

    /**
     * اخراج قائمة الأفعال بعد التعديلات
     * البدء بالادغام
     * @param root UnaugmentedTrilateralRoot
     * @param kov int
     * @param conjugations List
     * @param tense String (From SystemConstans class the values are stored)  ماضي أو مضارع او أمر
     * @return ConjugationResult
     */
    public ConjugationResult build(UnaugmentedTrilateralRoot root, int kov, List conjugations, String tense, boolean active) {
        return build(root, kov, conjugations, tense, active, true);
    }

    public ConjugationResult build(UnaugmentedTrilateralRoot root, int kov, List conjugations, String tense, boolean active, boolean applyGemination) {
        ConjugationResult conjResult = new ConjugationResult(kov, root, conjugations);
        if (applyGemination)
            geminator.apply(tense, active, conjResult);
        vocalizer.apply(tense, active, conjResult);
        hamzaModifier.apply(tense, active, conjResult);
        //خصيصاُ للفعل أثأ
        postHamzaModifier.apply(tense, active, conjResult);
        VerbLamAlefModifier.getInstance().apply(conjResult);
        return conjResult;
    }

}
