package sarf.gerund.modifier.quadrilateral;

import java.util.*;

import sarf.verb.quadriliteral.*;
import sarf.*;

public class QuadrilateralStandardModifier {

    private QuadrilateralStandardModifier() {
    }

    private static QuadrilateralStandardModifier instance = new QuadrilateralStandardModifier();

    private Vocalizer vocalizer = new Vocalizer();
    private InternalMahmouz internalMahmouz = new InternalMahmouz();
    private EndedMahmouz endedMahmouz = new EndedMahmouz();



    public static QuadrilateralStandardModifier getInstance() {
        return instance;
    }

    public ConjugationResult build(QuadrilateralRoot root, int formulaNo, int kov, List conjugations) {
        ConjugationResult conjResult = new ConjugationResult(formulaNo, kov, root, conjugations);
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
