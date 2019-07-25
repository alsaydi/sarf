package sarf.noun.quadriliteral.modifier.passiveparticiple;

import java.util.*;

import sarf.verb.quadriliteral.*;
import sarf.*;

public class PassiveParticipleModifier {

    private PassiveParticipleModifier() {
    }

    private static final PassiveParticipleModifier instance = new PassiveParticipleModifier();

    private final Geminator geminator = new Geminator();
    private final Vocalizer vocalizer = new Vocalizer();
    private final InternalMahmouz internalMahmouz = new InternalMahmouz();
    private final EndedMahmouz endedMahmouz = new EndedMahmouz();



    public static PassiveParticipleModifier getInstance() {
        return instance;
    }

    /**
     * اخراج قائمة الأفعال بعد التعديلات
     * @param root UnaugmentedTrilateralRoot
     * @param conjugations List
     * @param tense String (From SystemConstans class the values are stored)  ماضي أو مضارع او أمر
     * @return ConjugationResult
     */
    public ConjugationResult build(QuadrilateralRoot root, int formulaNo, KindOfVerb kov, List conjugations) {
        ConjugationResult conjResult = new ConjugationResult(formulaNo, kov, root, conjugations);
        if (geminator.isApplied(conjResult))
            geminator.apply(conjResult.getFinalResult(), conjResult.getRoot());
        if (vocalizer.isApplied(conjResult))
            vocalizer.apply(conjResult.getFinalResult(), conjResult.getRoot());
        if (internalMahmouz.isApplied(conjResult))
            internalMahmouz.apply(conjResult.getFinalResult(), conjResult.getRoot());
        if (endedMahmouz.isApplied(conjResult))
            endedMahmouz.apply(conjResult.getFinalResult(), conjResult.getRoot());

        NounLamAlefModifier.getInstance().apply(conjResult);
        NounSunLamModifier.getInstance().apply(conjResult);
        return conjResult;
    }
}
