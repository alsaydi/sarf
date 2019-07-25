package sarf.verb.trilateral.augmented;

import java.util.*;
import sarf.*;
import sarf.verb.trilateral.*;

/**
 * <p>
 * Title: Sarf
 * </p>
 * <p>
 * Description: جذر الفعل الثلاثي المزيد
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class AugmentedTrilateralRoot extends TrilateralRoot {

	// قائمة صيغ المزيد الممكنة لهذا الجذر
	private final Map<String, AugmentationFormula> augmentations = new HashMap<>();

	public AugmentedTrilateralRoot(){
		super();
	}

	public AugmentedTrilateralRoot(char c1, char c2, char c3) {
		super(c1, c2, c3);
	}

	public void addAugmentationFormula(AugmentationFormula formula) {
		augmentations.put(formula.getFormulaNo() + "", formula);
	}

	public Collection<AugmentationFormula> getAugmentationList() {
		return augmentations.values();
	}

	public AugmentationFormula getAugmentationFormula(int formulaNo) {
		return augmentations.get(formulaNo + "");
	}

}
