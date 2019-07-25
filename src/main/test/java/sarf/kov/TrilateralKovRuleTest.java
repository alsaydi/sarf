package sarf.kov;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import sarf.KindOfVerb;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TrilateralKovRuleTest {

    @Test
    void getDesc() {
        var sut = new TrilateralKovRule();
        assertNull(sut.getDesc());
    }

    @Test
    void getExample() {
        var sut = new TrilateralKovRule();
        assertNull(sut.getExample());
    }

    @Test
    void getKov() {
        var sut = new TrilateralKovRule();
        assertNull(sut.getKov());
    }

    @Test
    void setKov() {
        var sut = new TrilateralKovRule();

        sut.setKov(KindOfVerb.Salim);

        assertEquals(KindOfVerb.Salim, sut.getKov());
    }

    @Test
    void setExample() {
        var sut = new TrilateralKovRule();

        sut.setExample("مثال");

        assertEquals("مثال", sut.getExample());
    }

    @Test
    void setDesc() {
        var sut = new TrilateralKovRule();

        sut.setExample("وصف");

        assertEquals("وصف", sut.getExample());
    }

    static Stream<Arguments> getTrilateralRules(){
        return Stream.of(
                Arguments.of("?", "?", "?", "سلم", true),
                Arguments.of("null", "null", "null", "سلم", true),
                Arguments.of("?","c3", "c2", "سلم", false),
                Arguments.of("و", "?", "?", "وعد", true),
                Arguments.of("و", "?", "?", "سعد", false),

                Arguments.of("?", "c3", "c2", "فرر", true),
                Arguments.of("?", "c3", "c2", "فرق", false),
                Arguments.of("null", "c3", "c2", "فرر", true),
                Arguments.of("null", "c3", "c2", "فرق", false),

                Arguments.of("?", "و", "ي", "دوي", true)

        );
    }

    @ParameterizedTest()
    @MethodSource("getTrilateralRules")
    void checkTests(String ruleC1, String ruleC2, String ruleC3, String verb, boolean expected) {
        var sut = new TrilateralKovRule();

        sut.setC1(ruleC1);
        sut.setC2(ruleC2);
        sut.setC3(ruleC3);

        var actual = sut.check(verb.charAt(0), verb.charAt(1), verb.charAt(2));
        assertEquals(expected, actual);
    }
}