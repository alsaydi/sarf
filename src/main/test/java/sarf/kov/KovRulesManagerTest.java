package sarf.kov;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class KovRulesManagerTest {

    private static Stream<Arguments> getTrilateralVerbs() {
        return Stream.of(
                Arguments.of("صبر", 1),
                Arguments.of("مدد", 2),
                Arguments.of("ءجج", 3),
                Arguments.of("ءنء", 4),
                Arguments.of("ءكل", 5),
                Arguments.of("سءر", 6),
                Arguments.of("مرء", 7),
                Arguments.of("ودد", 8), // مثال واوي مضعف
                Arguments.of("وءد", 9),
                Arguments.of("وكء", 10),
                Arguments.of("وكر", 11),
                Arguments.of("يسس", 12),
                Arguments.of("يءس", 13),
                Arguments.of("يسر", 14),
                Arguments.of("ءوب", 15),
                Arguments.of("لوء", 16),
                Arguments.of("سود", 17),
                Arguments.of("ءيس", 18),
                Arguments.of("شيء", 19),
                Arguments.of("بيع", 20),
                Arguments.of("ءسو", 21),
                Arguments.of("مءو", 22),
                Arguments.of("غزو", 23),
                Arguments.of("ءبي", 24),
                Arguments.of("رءي", 25),
                Arguments.of("رمي", 26),
                Arguments.of("ءوي", 27),
                Arguments.of("شوي", 28),
                Arguments.of("وءي", 29),
                Arguments.of("وقي", 30)
        );
    }

    private static Stream<Arguments> getQuadrilateralVerbs() {
        return Stream.of(
                Arguments.of("دحرج", 1),
                Arguments.of("زلزل", 2),
                Arguments.of("دءدء", 3),
                Arguments.of("طمءن", 4),
                Arguments.of("غرقء", 4),
                Arguments.of("بءدل", 4),
                Arguments.of("يءيء", 5),
                Arguments.of("وءوء", 5),
                Arguments.of("وسوس", 6),
                Arguments.of("يعيع", 6),
                Arguments.of("يرنء", 7),
                Arguments.of("يرنء", 7),
                Arguments.of("رهيء", 8),
                Arguments.of("تودء", 8),
                Arguments.of("شريف", 9),
                Arguments.of("قلسي", 10),
                Arguments.of("ضوضي", 11),
                Arguments.of("حيحي", 11)
        );
    }

    @Test
    void getInstance() {
        var sut = KovRulesManager.getInstance();
        assertNotNull(sut);
    }

    @ParameterizedTest
    @MethodSource("getTrilateralVerbs")
    void getTrilateralKov(String verb, int kindOfVerb) {
        var sut = KovRulesManager.getInstance();
        var c1 = verb.charAt(0);
        var c2 = verb.charAt(1);
        var c3 = verb.charAt(2);
        var actual = sut.getTrilateralKov(c1, c2, c3).getValue();
        assertEquals(kindOfVerb, actual);
    }

    @ParameterizedTest
    @MethodSource("getTrilateralVerbs")
    void getTrilateralKovRule(String verb, int kindOfVerb) {
        var sut = KovRulesManager.getInstance();
        var actual = sut.getTrilateralKovRule(verb.charAt(0), verb.charAt(1), verb.charAt(2));

        assertNotNull(actual);
        assertEquals(kindOfVerb, actual.getKov().getValue());
    }

    @ParameterizedTest
    @MethodSource("getQuadrilateralVerbs")
    void getQuadrilateralKovRule(String verb, int kindOfVerb) {
        var sut = KovRulesManager.getInstance();
        var actual = sut.getQuadrilateralKovRule(verb.charAt(0), verb.charAt(1), verb.charAt(2), verb.charAt(3));

        assertNotNull(actual);
        assertEquals(kindOfVerb, actual.getKov().getValue());
    }
}
