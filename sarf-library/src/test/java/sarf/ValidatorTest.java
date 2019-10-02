package sarf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidatorTest {
	Validator sut;

	@BeforeEach
	void setup(){
		sut = new Validator();
	}
	@Test
	void checkLength_returnsEx() throws Exception {
		assertTrue(sut.checkLength("بحر"));
		assertTrue(sut.checkLength("بحرت"));
		assertFalse(sut.checkLength("بح"));
		assertFalse(sut.checkLength("بحرتم"));
		assertFalse(sut.checkLength(""));
		assertFalse(sut.checkLength(null));
	}
	
	@Test
	void checkArabicLetters_returnsExpected() throws Exception {
		assertTrue(sut.checkArabicLetters("بحر"));
		assertTrue(sut.checkArabicLetters("بحرت"));
		assertTrue(sut.checkArabicLetters(""));
		assertFalse(sut.checkArabicLetters("no"));
		assertFalse(sut.checkArabicLetters("нет"));
		assertFalse(sut.checkArabicLetters(null));
	}
	
	@Test
	void checkStartedWithAlef_returnsExpected() throws Exception {
		assertTrue(sut.checkStartedWithAlef("انت"));
		assertFalse(sut.checkStartedWithAlef("بت"));
		assertFalse(sut.checkStartedWithAlef(null));
		assertFalse(sut.checkStartedWithAlef(""));
	}
	
	@Test
	void checkAlefMamdoda_returnsExpected() throws Exception {
		assertTrue(sut.checkAlefMamdoda("بآئت"));
		assertFalse(sut.checkAlefMamdoda("بانت"));
		assertFalse(sut.checkAlefMamdoda(null));
		assertFalse(sut.checkAlefMamdoda(""));
	}
	
	@Test
	void checkTaskil_returnsExpected() throws Exception {
		assertTrue(sut.checkTashkil("بّ"));
		assertTrue(sut.checkTashkil("بُ"));
		assertTrue(sut.checkTashkil("بِ"));
		assertTrue(sut.checkTashkil("بَ"));
		assertTrue(sut.checkTashkil("بْ"));
		assertFalse(sut.checkTashkil("نهار"));
		assertFalse(sut.checkTashkil("قضى كل ذي دين فوفى غريمه و عزة منقوص معنى غريمها"));
		assertFalse(sut.checkTashkil(null));
	}
	
	@Test
	void correctHamza_returnsExpected() throws Exception {
		assertEquals("بءر",sut.correctHamza("بئر"));
		assertEquals("سءر",sut.correctHamza("سؤر"));
		assertEquals("تءريخ",sut.correctHamza("تأريخ"));
		assertEquals("ءفك",sut.correctHamza("إفك"));
		assertEquals("ءءءء",sut.correctHamza("إئأؤ"));
		assertEquals("",sut.correctHamza(""));
		assertEquals("نهر",sut.correctHamza("نهر"));
		assertEquals(null,sut.correctHamza(null));
	}

	@Test
	void فعل_صحيح_getTrilateralAlefAlternatives_لا_تغير_شيئاً() throws Exception {
		List<String> expected = new ArrayList<>();
		List<String> actual = sut.getTrilateralAlefAlternatives("سلم");
		
		assertLinesMatch(expected, actual);
	}
	
	@Test
	void ثلاثي_لفيف_مقرون_getTrilateralAlefAlternatives_returnsExpected() throws Exception {
		List<String> expected = new ArrayList<>();
		expected.add("سوو");
		expected.add("سوي");
		expected.add("سيو");
		expected.add("سيي");
		List<String> actual = sut.getTrilateralAlefAlternatives("ساا");
		
		assertLinesMatch(expected, actual);
	}
	
	@Test
	void ثلاثي_أجوف_getTrilateralAlefAlternatives_returnsExpected() throws Exception {
		List<String> expected = new ArrayList<>();
		expected.add("سور");
		expected.add("سير");		
		List<String> actual = sut.getTrilateralAlefAlternatives("سار");
		
		assertLinesMatch(expected, actual);
	}
	
	@Test
	void مقصور_ثلاثي_ناقص_getTrilateralAlefAlternatives_returnsExpected() throws Exception {
		List<String> expected = new ArrayList<>();
		expected.add("رمو");
		expected.add("رمي");		
		List<String> actual = sut.getTrilateralAlefAlternatives("رمى");
		
		assertLinesMatch(expected, actual);
	}
	
	@Test
	void ثلاثي_ناقص_getTrilateralAlefAlternatives_returnsExpected() throws Exception {
		List<String> expected = new ArrayList<>();
		expected.add("ذكو");
		expected.add("ذكي");		
		List<String> actual = sut.getTrilateralAlefAlternatives("ذكا");
		
		assertLinesMatch(expected, actual);
	}
	
	@Test
	void رباعي_عينه_ألف_getQuadrilateralAlefAlternatives_returnsExpected() {
		List<String> expected = new ArrayList<>();
		expected.add("فوعل");
		expected.add("فيعل");		
		List<String> actual = sut.getQuadrilateralAlefAlternatives("فاعل");
		
		assertLinesMatch(expected, actual);
	}
	
	@Test
	void رباعي_لامه_الأولى_ألف_getQuadrilateralAlefAlternatives_returnsExpected() {
		List<String> expected = new ArrayList<>();
		expected.add("فعول");
		expected.add("فعيل");				
		List<String> actual = sut.getQuadrilateralAlefAlternatives("فعال");
		
		assertLinesMatch(expected, actual);
	}
	
	@Test
	void رباعي_لامه_الثانية_ألف_مقصورة_getQuadrilateralAlefAlternatives_returnsExpected() {
		List<String> expected = new ArrayList<>();		
		expected.add("فعلي");				
		List<String> actual = sut.getQuadrilateralAlefAlternatives("فعلى");
		
		assertLinesMatch(expected, actual);
	}
	
	@Test
	void رباعي_لامه_الثانية_ألف_getQuadrilateralAlefAlternatives_returnsExpected() {
		List<String> expected = new ArrayList<>();		
		expected.add("فعلي");				
		List<String> actual = sut.getQuadrilateralAlefAlternatives("فعلا");
		
		assertLinesMatch(expected, actual);
	}
}
