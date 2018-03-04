package sarf.verb.quadriliteral.modifier;

import java.util.*;

import sarf.verb.quadriliteral.*;
import sarf.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: ÌﬁÊ„ »›Õ’ Ê«Ã—«¡ «· ⁄œÌ·«  «·„‰«”»… ⁄·Ï «·√›⁄«· «·—»«⁄Ì…
 * »„« ›ÌÂ« «·«⁄·«· Ê«·«œ€«„ Ê«·Â„“…
 * Õ”» «·’Ì€… „«÷Ì √Ê „÷«—⁄ «Ê √„—
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

    private QuadrilateralModifier() {
    }

    private static QuadrilateralModifier instance = new QuadrilateralModifier();

    private Geminator geminator = new Geminator();
    private Vocalizer vocalizer = new Vocalizer();
    private InternalMahmouz internalMahmouz = new InternalMahmouz();
    private EndedMahmouz endedMahmouz = new EndedMahmouz();



    public static QuadrilateralModifier getInstance() {
        return instance;
    }

    /**
     * «Œ—«Ã ﬁ«∆„… «·√›⁄«· »⁄œ «· ⁄œÌ·« 
     * @param root UnaugmentedTrilateralRoot
     * @param conjugations List
     * @param tense String (From SystemConstans class the values are stored)  „«÷Ì √Ê „÷«—⁄ «Ê √„—
     * @return ConjugationResult
     */
    public ConjugationResult build(QuadrilateralRoot root, int formulaNo, int kov, List conjugations, String tense, boolean active, boolean applyGemination) {
        ConjugationResult conjResult = new ConjugationResult(formulaNo, kov, root, conjugations);
        if (applyGemination)
            geminator.apply(tense, active, conjResult);
        vocalizer.apply(tense, active, conjResult);
        internalMahmouz.apply(tense, active, conjResult);
        endedMahmouz.apply(tense, active, conjResult);
        VerbLamAlefModifier.getInstance().apply(conjResult);
        return conjResult;
    }

    public ConjugationResult build(QuadrilateralRoot root, int formulaNo, int kov, List conjugations, String tense, boolean active) {
        return build(root, formulaNo, kov, conjugations, tense, active, true);
    }
}
