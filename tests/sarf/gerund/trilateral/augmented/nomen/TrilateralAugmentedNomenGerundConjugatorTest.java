package sarf.gerund.trilateral.augmented.nomen;

import sarf.AugmentationFormula;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;

class TrilateralAugmentedNomenGerundConjugatorTest {
	
	@Test
	void NewTrilateralAugmentedNomenGerundConjugator() {
		var sut = TrilateralAugmentedNomenGerundConjugator.getInstance();
		assertNotNull(sut);
	}
	
	@Test
	void root_createGerundList_returnsList() {
		var instance = TrilateralAugmentedNomenGerundConjugator.getInstance();
		var augFormula = new AugmentationFormula();
		augFormula.setFormulaNo(1);
		var verb = "برد".toCharArray();
		var root = new AugmentedTrilateralRoot(verb[0],verb[1],verb[2], augFormula);
		
		var list = instance.createGerundList(root, augFormula.getFormulaNo());
		
		assertNotNull(list);
		assertEquals(18, list.size());
		
	}
}
