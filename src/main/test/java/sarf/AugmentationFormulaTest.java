package sarf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AugmentationFormulaTest {

	@Test
	public void ForumualNo_GetFomulaNo_ReturnsExpected() {
		AugmentationFormula sut = new AugmentationFormula();
		sut.setFormulaNo(1);
		assertEquals(1, sut.getFormulaNo());
	}
	
	@Test
	public void SetTransitive_GetTransitive_ReturnsExpected() {
		AugmentationFormula sut = new AugmentationFormula();
		sut.setTransitive('ب');
		assertEquals('ب', sut.getTransitive());
	}
	
	
}
