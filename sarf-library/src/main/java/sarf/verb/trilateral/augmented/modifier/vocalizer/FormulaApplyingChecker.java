package sarf.verb.trilateral.augmented.modifier.vocalizer;

import com.google.inject.Singleton;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */

@Singleton
public class FormulaApplyingChecker {
    private final Formula1ApplyingChecker formula1ApplyingChecker = new Formula1ApplyingChecker();
    private final Formula5ApplyingChecker formula5ApplyingChecker = new Formula5ApplyingChecker();
    private final Formula9ApplyingChecker formula9ApplyingChecker = new Formula9ApplyingChecker();

    public FormulaApplyingChecker() {
    }

    public int check(AugmentedTrilateralRoot root, int formulaNo) {
        switch (formulaNo) {
        case 1:
            return formula1ApplyingChecker.check(root);
        case 5:
            return formula5ApplyingChecker.check(root);
        case 9:
            return formula9ApplyingChecker.check(root);
        }
        return IFormulaApplyingChecker.NONE;
    }
}
