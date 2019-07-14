package sarf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class GerundTest {

	@Test
	public void setSymbol_getSymbol_returnsExpected() {
		Gerund sut = new Gerund();
		sut.setSymbol("test");
		assertEquals("test", sut.getSymbol());
	}
	
	@Test
	public void setValue_getValue_returnsExpected() {
		Gerund sut = new Gerund();
		sut.setValue("value");
		assertEquals("value", sut.getValue());
	}
}
