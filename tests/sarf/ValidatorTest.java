package sarf;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ValidatorTest {

	@Test
	void checkLength_returnsEx() throws Exception {
		assertTrue(Validator.getInstance().checkLength("بحر"));
		assertTrue(Validator.getInstance().checkLength("بحرت"));
		assertFalse(Validator.getInstance().checkLength("بح"));
		assertFalse(Validator.getInstance().checkLength("بحرتم"));
		assertFalse(Validator.getInstance().checkLength(""));
		assertFalse(Validator.getInstance().checkLength(null));
	}
	
	@Test
	void checkArabicLetters_returnsExpected() throws Exception {
		assertTrue(Validator.getInstance().checkArabicLetters("بحر"));
		assertTrue(Validator.getInstance().checkArabicLetters("بحرت"));
		assertTrue(Validator.getInstance().checkArabicLetters(""));
		assertFalse(Validator.getInstance().checkArabicLetters("no"));
		assertFalse(Validator.getInstance().checkArabicLetters("нет"));
		assertFalse(Validator.getInstance().checkArabicLetters(null));
	}
	
	@Test
	void checkStartedWithAlef_returnsExpected() throws Exception {
		assertTrue(Validator.getInstance().checkStartedWithAlef("انت"));
		assertFalse(Validator.getInstance().checkStartedWithAlef("بت"));
		assertFalse(Validator.getInstance().checkStartedWithAlef(null));
		assertFalse(Validator.getInstance().checkStartedWithAlef(""));
	}
	
	@Test
	void checkAlefMamdoda_returnsExpected() throws Exception {
		assertTrue(Validator.getInstance().checkAlefMamdoda("بآئت"));
		assertFalse(Validator.getInstance().checkAlefMamdoda("بانت"));
		assertFalse(Validator.getInstance().checkAlefMamdoda(null));
		assertFalse(Validator.getInstance().checkAlefMamdoda(""));
	}
	
	@Test
	void checkTaskil_returnsExpected() throws Exception {
		assertTrue(Validator.getInstance().checkTashkil("بّ"));
		assertTrue(Validator.getInstance().checkTashkil("بُ"));
		assertTrue(Validator.getInstance().checkTashkil("بِ"));
		assertTrue(Validator.getInstance().checkTashkil("بَ"));
		assertTrue(Validator.getInstance().checkTashkil("بْ"));
		assertFalse(Validator.getInstance().checkTashkil("نهار"));
		assertFalse(Validator.getInstance().checkTashkil("قضى كل ذي دين فوفى غريمه و عزة منقوص معنى غريمها"));
		assertFalse(Validator.getInstance().checkTashkil(null));
	}
	
	@Test
	void correctHamza_returnsExpected() throws Exception {
		assertEquals("بءر",Validator.getInstance().correctHamza("بئر"));
		assertEquals("سءر",Validator.getInstance().correctHamza("سؤر"));
		assertEquals("تءريخ",Validator.getInstance().correctHamza("تأريخ"));
		assertEquals("ءفك",Validator.getInstance().correctHamza("إفك"));
		assertEquals("ءءءء",Validator.getInstance().correctHamza("إئأؤ"));
		assertEquals("",Validator.getInstance().correctHamza(""));
		assertEquals("نهر",Validator.getInstance().correctHamza("نهر"));
		assertEquals(null,Validator.getInstance().correctHamza(null));
	}

	@Test
	void فعل_صحيح_getTrilateralAlefAlternatives_لا_تغير_شيئاً() throws Exception {
		List<String> expected = new ArrayList<>();
		List<String> actual = Validator.getInstance().getTrilateralAlefAlternatives("سلم");
		
		assertLinesMatch(expected, actual);
	}
	
	@Test
	void ثلاثي_لفيف_مقرون_getTrilateralAlefAlternatives_returnsExpected() throws Exception {
		List<String> expected = new ArrayList<>();
		expected.add("سوو");
		expected.add("سوي");
		expected.add("سيو");
		expected.add("سيي");
		List<String> actual = Validator.getInstance().getTrilateralAlefAlternatives("ساا");
		
		assertLinesMatch(expected, actual);
	}
	
	@Test
	void ثلاثي_أجوف_getTrilateralAlefAlternatives_returnsExpected() throws Exception {
		List<String> expected = new ArrayList<>();
		expected.add("سور");
		expected.add("سير");		
		List<String> actual = Validator.getInstance().getTrilateralAlefAlternatives("سار");
		
		assertLinesMatch(expected, actual);
	}
	
	@Test
	void مقصور_ثلاثي_ناقص_getTrilateralAlefAlternatives_returnsExpected() throws Exception {
		List<String> expected = new ArrayList<>();
		expected.add("رمو");
		expected.add("رمي");		
		List<String> actual = Validator.getInstance().getTrilateralAlefAlternatives("رمى");
		
		assertLinesMatch(expected, actual);
	}
	
	@Test
	void ثلاثي_ناقص_getTrilateralAlefAlternatives_returnsExpected() throws Exception {
		List<String> expected = new ArrayList<>();
		expected.add("ذكو");
		expected.add("ذكي");		
		List<String> actual = Validator.getInstance().getTrilateralAlefAlternatives("ذكا");
		
		assertLinesMatch(expected, actual);
	}
	
	@Test
	void رباعي_عينه_ألف_getQuadrilateralAlefAlternatives_returnsExpected() {
		List<String> expected = new ArrayList<>();
		expected.add("فوعل");
		expected.add("فيعل");		
		List<String> actual = Validator.getInstance().getQuadrilateralAlefAlternatives("فاعل");
		
		assertLinesMatch(expected, actual);
	}
	
	@Test
	void رباعي_لامه_الأولى_ألف_getQuadrilateralAlefAlternatives_returnsExpected() {
		List<String> expected = new ArrayList<>();
		expected.add("فعول");
		expected.add("فعيل");				
		List<String> actual = Validator.getInstance().getQuadrilateralAlefAlternatives("فعال");
		
		assertLinesMatch(expected, actual);
	}
	
	@Test
	void رباعي_لامه_الثانية_ألف_مقصورة_getQuadrilateralAlefAlternatives_returnsExpected() {
		List<String> expected = new ArrayList<>();		
		expected.add("فعلي");				
		List<String> actual = Validator.getInstance().getQuadrilateralAlefAlternatives("فعلى");
		
		assertLinesMatch(expected, actual);
	}
	
	@Test
	void رباعي_لامه_الثانية_ألف_getQuadrilateralAlefAlternatives_returnsExpected() {
		List<String> expected = new ArrayList<>();		
		expected.add("فعلي");				
		List<String> actual = Validator.getInstance().getQuadrilateralAlefAlternatives("فعلا");
		
		assertLinesMatch(expected, actual);
	}
}
