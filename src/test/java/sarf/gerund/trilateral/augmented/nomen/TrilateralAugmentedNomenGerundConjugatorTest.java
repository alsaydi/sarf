package sarf.gerund.trilateral.augmented.nomen;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sarf.AugmentationFormula;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import sarf.noun.GenericNounSuffixContainer;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;

class TrilateralAugmentedNomenGerundConjugatorTest {

	@Mock
	private GenericNounSuffixContainer genericNounSuffixContainer;

	@InjectMocks
	private TrilateralAugmentedNomenGerundConjugator sut;

	@BeforeEach
	void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void root_createGerundList_returnsList() {
		var augFormula = new AugmentationFormula();
		augFormula.setFormulaNo(1);
		var verb = "برد".toCharArray();
		var root = new AugmentedTrilateralRoot(verb[0],verb[1],verb[2]);
		
		var list = sut.createGerundList(root, augFormula.getFormulaNo());
		
		assertNotNull(list);
		assertEquals(18, list.size());
	}
}
