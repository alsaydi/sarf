package sarf.kov;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class QuadrilateralKovRuleTest {

    @ParameterizedTest()
    @MethodSource("getQuadrilateralRules")
    void checkTests(String ruleC1, String ruleC2, String ruleC3, String ruleC4, String verb, boolean expected) {
        var sut = new QuadrilateralKovRule();

        sut.setC1(ruleC1);
        sut.setC2(ruleC2);
        sut.setC3(ruleC3);
        sut.setC4(ruleC4);

        var actual = sut.check(verb.charAt(0), verb.charAt(1), verb.charAt(2), verb.charAt(3));
        assertEquals(expected, actual);
    }

    static Stream<Arguments> getQuadrilateralRules(){
        return Stream.of(
                Arguments.of("?", "?", "?", "?", "جمهر", true),
                Arguments.of("null", "null", "null", "null", "بسمل", true)
//                Arguments.of("?","c3", "c2", "سلم", false),
//                Arguments.of("و", "?", "?", "وعد", true),
//                Arguments.of("و", "?", "?", "سعد", false),
//
//                Arguments.of("?", "c3", "c2", "فرر", true),
//                Arguments.of("?", "c3", "c2", "فرق", false),
//                Arguments.of("null", "c3", "c2", "فرر", true),
//                Arguments.of("null", "c3", "c2", "فرق", false),
//
//                Arguments.of("?", "و", "ي", "دوي", true)

        );
    }
}