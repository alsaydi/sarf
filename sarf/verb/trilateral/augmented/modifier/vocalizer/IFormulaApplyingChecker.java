package sarf.verb.trilateral.augmented.modifier.vocalizer;

import java.util.List;
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
public abstract  class IFormulaApplyingChecker {
    public final static int TWO_STATE = 1;
    public final static int NOT_VOCALIZED = 2;
    public final static int NO_THING = 0;

    public IFormulaApplyingChecker() {
    }

    /**
     * ›Õ’ «·Ã–— «–« ﬂ«‰
     * ·« Ì⁄· ›Ì⁄Ìœ NOT_GEMINATED
     * Ì⁄· Ê·« Ì⁄· ›Ì⁄Ìœ  TWO_STATE
     * Ê≈·« Ì⁄Ìœ   NO_THING
     * @param root AugmentedTrilateralRoot
     * @return int
     */
    public int check(AugmentedTrilateralRoot root) {
        String rootString = root.getC1() + "" +root.getC2() +""+ root.getC3();
        if (getNotVocalizedList().contains(rootString))
            return NOT_VOCALIZED;
        if (getTwoStateList().contains(rootString))
            return TWO_STATE;
        return NO_THING;
    }


    public abstract List getNotVocalizedList();
    public abstract List getTwoStateList();

}
