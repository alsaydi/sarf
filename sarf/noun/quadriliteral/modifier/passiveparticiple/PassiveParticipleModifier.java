package sarf.noun.quadriliteral.modifier.passiveparticiple;

import java.util.*;

import sarf.verb.quadriliteral.*;
import sarf.*;

public class PassiveParticipleModifier {

    private PassiveParticipleModifier() {
    }

    private static PassiveParticipleModifier instance = new PassiveParticipleModifier();

    private Geminator geminator = new Geminator();
    private Vocalizer vocalizer = new Vocalizer();
    private InternalMahmouz internalMahmouz = new InternalMahmouz();
    private EndedMahmouz endedMahmouz = new EndedMahmouz();



    public static PassiveParticipleModifier getInstance() {
        return instance;
    }

    /**
     * «Œ—«Ã ﬁ«∆„… «·√›⁄«· »⁄œ «· ⁄œÌ·« 
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
