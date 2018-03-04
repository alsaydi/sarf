package sarf.verb.trilateral.augmented.modifier;

import java.util.*;

import javax.swing.*;

import sarf.*;
import sarf.verb.trilateral.augmented.*;
import sarf.verb.trilateral.augmented.modifier.vocalizer.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: ÌﬁÊ„ »›Õ’ Ê«Ã—«¡ «· ⁄œÌ·«  «·„‰«”»… ⁄·Ï «·√›⁄«· «·À·«ÀÌ… «·„“Ìœ…
 * »„« ›ÌÂ« «·«⁄·«· Ê«·«»œ«· Ê«·Â„“…
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
public class AugmentedTrilateralModifier {

    private AugmentedTrilateralModifier() {
    }

    private static AugmentedTrilateralModifier instance = new AugmentedTrilateralModifier();
    //«·«»œ«·
    private Substituter substituter = new Substituter();
    private Geminator geminator = new Geminator();
    private Vocalizer vocalizer = new Vocalizer();
    private PreVocalizer preVocalizer = new PreVocalizer();
    private HamzaModifier hamzaModifier = new HamzaModifier();

    public static AugmentedTrilateralModifier getInstance() {
        return instance;
    }

    /**
     * «Œ—«Ã ﬁ«∆„… «·√›⁄«· »⁄œ «· ⁄œÌ·« 
     * «·»œ¡ »«·«»œ«·
     * @param root UnaugmentedTrilateralRoot
     * @param kov int
     * @param conjugations List
     * @param tense String (From SystemConstans class the values are stored)  „«÷Ì √Ê „÷«—⁄ «Ê √„—
     * @return ConjugationResult
     */
    public ConjugationResult build(AugmentedTrilateralRoot root, int kov, int formulaNo, List conjugations, String tense, boolean active, boolean applyGemination, AugmentedTrilateralModifierListener listener) {
        ConjugationResult conjResult = new ConjugationResult(kov, formulaNo, root, conjugations);
        substituter.apply(tense, active, conjResult);
        if (applyGemination) {
            geminator.apply(tense, active, conjResult);
        }

        boolean applyVocalization = true;
        int result = FormulaApplyingChecker.getInstance().check(root, formulaNo);
        if (result == IFormulaApplyingChecker.NOT_VOCALIZED) {
            applyVocalization = false;
        }
        else if (result == IFormulaApplyingChecker.TWO_STATE) {
            if (listener == null)
                applyVocalization = true;
            else
                //asking the listener to apply or not the vocaliztion
                applyVocalization = listener.doSelectVocalization();
        }

        if (applyVocalization) {
            preVocalizer.apply(tense, active, conjResult);
            vocalizer.apply(tense, active, conjResult);
        }

        hamzaModifier.apply(tense, active, conjResult);
        VerbLamAlefModifier.getInstance().apply(conjResult);
        return conjResult;
    }

    public ConjugationResult build(AugmentedTrilateralRoot root, int kov, int formulaNo, List conjugations, String tense, boolean active, AugmentedTrilateralModifierListener listener) {
        return build(root, kov, formulaNo, conjugations, tense, active, true, listener);
    }

}
