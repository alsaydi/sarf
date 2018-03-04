package sarf.noun.quadriliteral.modifier.activeparticiple;

import java.util.*;

import sarf.verb.quadriliteral.*;
import sarf.*;

public class ActiveParticipleModifier {

    private ActiveParticipleModifier() {
    }

    private static ActiveParticipleModifier instance = new ActiveParticipleModifier();

    private Geminator geminator = new Geminator();
    private Vocalizer vocalizer = new Vocalizer();
    private InternalMahmouz internalMahmouz = new InternalMahmouz();
    private EndedMahmouz endedMahmouz = new EndedMahmouz();



    public static ActiveParticipleModifier getInstance() {
        return instance;
    }

    /**
     * @param root UnaugmentedTrilateralRoot
     * @param conjugations List
     * @param tense String (From SystemConstans class the values are stored)  „«÷Ì √Ê „÷«—⁄ «Ê √„—
     * @return ConjugationResult
     */
    public ConjugationResult build(QuadrilateralRoot root, int formulaNo, int kov, List conjugations) {
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
