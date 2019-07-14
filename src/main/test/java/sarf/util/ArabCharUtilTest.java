package sarf.util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ArabCharUtilTest {

	@Test
	void ArabCharUtilContainsCorrectConstants() throws Exception {
		assertEquals("َ", ArabCharUtil.FATHA);
		assertEquals("ِ", ArabCharUtil.KASRA);
		assertEquals("ُ", ArabCharUtil.DAMMA);
		assertEquals("ّ", ArabCharUtil.SHADDA);
		assertEquals("ْ", ArabCharUtil.SKOON);
	}
}
