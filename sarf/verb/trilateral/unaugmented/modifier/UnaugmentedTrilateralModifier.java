package sarf.verb.trilateral.unaugmented.modifier;

import sarf.verb.trilateral.unaugmented.*;
import java.util.*;
import sarf.verb.trilateral.unaugmented.modifier.geminator.*;
import sarf.*;

/**
 * <p>Title: Sarf Program</p>
 *«·„⁄«·Ã…
 * <p>Description: ÌﬁÊ„ »›Õ’ Ê«Ã—«¡ «· ⁄œÌ·«  «·„‰«”»… ⁄·Ï «·√›⁄«· «·À·«ÀÌ… «·„Ã—œ…
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
     * «Œ—«Ã ﬁ«∆„… «·√›⁄«· »⁄œ «· ⁄œÌ·« 
     * «·»œ¡ »«·«œ€«„
     * @param root UnaugmentedTrilateralRoot
     * @param kov int
     * @param conjugations List
     * @param tense String (From SystemConstans class the values are stored)  „«÷Ì √Ê „÷«—⁄ «Ê √„—
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
        //Œ’Ì’«ı ··›⁄· √À√
        postHamzaModifier.apply(tense, active, conjResult);
        VerbLamAlefModifier.getInstance().apply(conjResult);
        return conjResult;
    }

}
