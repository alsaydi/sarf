package sarf.verb.quadriliteral.augmented;

import java.util.*;

import sarf.*;
import sarf.verb.quadriliteral.*;

/**
 * <p>Title: Sarf</p>
 *
 * <p>Description: الجذر الرباعي المزيد
 * متضمنا الأحرف الأربعة                </p>
 *

 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public final class AugmentedQuadrilateralRoot extends QuadrilateralRoot{

    //قائمة صيغ المزيد الممكنة لهذا الجذر
    private final Map<String, AugmentationFormula> augmentations = new HashMap<>();

    public AugmentedQuadrilateralRoot() {
    }

    public void addAugmentationFormula(AugmentationFormula formula) {
        augmentations.put(formula.getFormulaNo()+"",formula);
    }

    public Collection getAugmentationList() {
        return augmentations.values();
    }

    public AugmentationFormula getAugmentationFormula(int formulaNo) {
        return augmentations.get(formulaNo+"");
    }
}
