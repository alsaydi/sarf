package sarf.gerund.modifier.trilateral.augmented.standard;

import java.util.List;
import sarf.*;
import sarf.noun.trilateral.augmented.modifier.Substituter;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;
import sarf.verb.trilateral.augmented.*;
import sarf.verb.trilateral.augmented.modifier.vocalizer.IFormulaApplyingChecker;
import sarf.verb.trilateral.augmented.modifier.vocalizer.FormulaApplyingChecker;
import sarf.verb.trilateral.augmented.modifier.AugmentedTrilateralModifierListener;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description:  ÿ»Ìﬁ «·„⁄«·Ã… «·Œ«’… ⁄·Ï «”„ «·›«⁄·
 * «» œ«¡ »«·«œ€«„ À„ «·«⁄·«· Ê«ŒÌ—« «·Â„“…
 * </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class TitlateralAugmentedStandardModifier {
    private Geminator geminator = new Geminator();
    private Vocalizer vocalizer = new Vocalizer();
    private Mahmouz mahmouz = new Mahmouz();
    private Substituter substituter = new Substituter();

    private TitlateralAugmentedStandardModifier() {
    }

    private static TitlateralAugmentedStandardModifier instance = new TitlateralAugmentedStandardModifier();

    public static TitlateralAugmentedStandardModifier getInstance() {
        return instance;
    }

    public ConjugationResult build(AugmentedTrilateralRoot root, int kov, int formulaNo, List conjugations, AugmentedTrilateralModifierListener listener) {
        ConjugationResult conjResult = new ConjugationResult(kov, formulaNo, root, conjugations);
        substituter.apply(conjResult);
        geminator.apply(conjResult);

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
            vocalizer.apply(conjResult);
        }

        mahmouz.apply(conjResult);
        NounLamAlefModifier.getInstance().apply(conjResult);
        NounSunLamModifier.getInstance().apply(conjResult);
        return conjResult;
    }

}
