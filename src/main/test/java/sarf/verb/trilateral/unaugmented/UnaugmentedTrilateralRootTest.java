package sarf.verb.trilateral.unaugmented;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import sarf.Gerund;

public class UnaugmentedTrilateralRootTest {

	@Test
	public void gerund_addGerund_gerundAdded() {
		UnaugmentedTrilateralRoot sut = new UnaugmentedTrilateralRoot();
		Gerund gerund = new Gerund();
		gerund.setSymbol("ض");
		sut.addGerund(gerund);
		
		assertEquals(1, sut.getGerundsSymbols().size());
		assertEquals("ض", sut.getGerundsSymbols().toArray()[0]);
	}
	
	@Test
	void symbol_getGerund_returnsCorresponding() throws Exception {
		UnaugmentedTrilateralRoot sut = new UnaugmentedTrilateralRoot();
		Gerund gerund = new Gerund();
		gerund.setSymbol("ض");
		sut.addGerund(gerund);
		
		assertSame(gerund, sut.getGerund("ض"));
	}
	
	@Test
	void manyGerundsAdded_getGerundsSymbols_allSymbolsAdded() throws Exception {
		UnaugmentedTrilateralRoot sut = new UnaugmentedTrilateralRoot();
		Gerund g1 = new Gerund();
		Gerund g2 = new Gerund();
		Gerund g3 = new Gerund();
		g1.setSymbol("ص");		
		g2.setSymbol("ض");		
		g3.setSymbol("ط");
		sut.addGerund(g1);
		sut.addGerund(g2);
		sut.addGerund(g3);
		
		assertEquals(3, sut.getGerundsSymbols().size());
		assertEquals("ص", sut.getGerundsSymbols().toArray()[0]);
		assertEquals("ض", sut.getGerundsSymbols().toArray()[1]);
		assertEquals("ط", sut.getGerundsSymbols().toArray()[2]);
	}
	
	@Test
	void sameRoots_equals_rerunsTrue() throws Exception {
		UnaugmentedTrilateralRoot sut = new UnaugmentedTrilateralRoot();
		sut.setC1('ق');
		sut.setC2('f');
		sut.setC3('r');
		
		UnaugmentedTrilateralRoot اخر = new UnaugmentedTrilateralRoot();
		اخر.setC1('ق');
		اخر.setC2('f');
		اخر.setC3('r');

		assertEquals(sut, اخر);
	}
	
	@Test
	void differentRoots_equals_returnsFalse() throws Exception {
		UnaugmentedTrilateralRoot sut = new UnaugmentedTrilateralRoot();
		sut.setC1('ق');
		sut.setC2('f');
		sut.setC3('r');
		
		UnaugmentedTrilateralRoot اخر = new UnaugmentedTrilateralRoot();
		اخر.setC1('ق');
		اخر.setC2('f');
		اخر.setC3('ع');

		assertNotEquals(sut, اخر);
	}
	
	@Test
	void greaterThan6Conjugation_setConjugation_throws() throws Exception {
		UnaugmentedTrilateralRoot sut = new UnaugmentedTrilateralRoot();
		assertThrows(IllegalArgumentException.class, () -> sut.setConjugation("7"));
	}
	
	@Test
	void lessThan6Conjugation_setConjugation_throws() throws Exception {
		UnaugmentedTrilateralRoot sut = new UnaugmentedTrilateralRoot();
		assertThrows(IllegalArgumentException.class, () -> sut.setConjugation("0"));
	}
}
