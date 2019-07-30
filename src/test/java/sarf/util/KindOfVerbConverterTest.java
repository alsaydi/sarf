package sarf.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import sarf.KindOfVerb;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static sarf.KindOfVerb.Salim;

class KindOfVerbConverterTest {

    private static Stream<Arguments> getKindOfVerbOrdinalValues() {
        return Stream.of(
                Arguments.of("1", KindOfVerb.Salim),
                Arguments.of("2", KindOfVerb.Mudaaf),
                Arguments.of("3", KindOfVerb.Mahmouz_Faa_Mudaaf),
                Arguments.of("4", KindOfVerb.Mahmouz_Faa_Mahmouz_Laam),
                Arguments.of("5", KindOfVerb.Mahmouz_Faa),
                Arguments.of("6", KindOfVerb.Mahmouz_Ain),
                Arguments.of("7", KindOfVerb.Mahmouz_Laam),
                Arguments.of("8", KindOfVerb.Mithal_Wawi_Mudaaf),
                Arguments.of("9", KindOfVerb.Mithal_Wawi_Mahmouz_Ain),
                Arguments.of("10", KindOfVerb.Mithal_Wawi_Mahmouz_Laam),
                Arguments.of("11", KindOfVerb.Mithal_Wawi),
                Arguments.of("12", KindOfVerb.Mithal_Yaee_Mudaaf),
                Arguments.of("13", KindOfVerb.Mithal_Yaee_Mahmouz_Ain),
                Arguments.of("14", KindOfVerb.Mithal_Yaee),
                Arguments.of("15", KindOfVerb.Ajwaf_Wawi_Mahmouz_Faa),
                Arguments.of("16", KindOfVerb.Ajwaf_Wawi_Mahmouz_Laam),
                Arguments.of("17", KindOfVerb.Ajwaf_Wawi),
                Arguments.of("18", KindOfVerb.Ajwaf_Yaee_Mahmouz_Faa),
                Arguments.of("19", KindOfVerb.Ajwaf_Yaee_Mahmouz_Laam),
                Arguments.of("20", KindOfVerb.Ajwaf_Yaee),
                Arguments.of("21", KindOfVerb.Naqis_Wawi_Mahmouz_Faa),
                Arguments.of("22", KindOfVerb.Naqis_Wawi_Mahmouz_Ain),
                Arguments.of("23", KindOfVerb.Naqis_Wawi),
                Arguments.of("24", KindOfVerb.Naqis_Yaee_Mahmouz_Faa),
                Arguments.of("25", KindOfVerb.Naqis_Yaee_Mahmouz_Ain),
                Arguments.of("26", KindOfVerb.Naqis_Yaee),
                Arguments.of("27", KindOfVerb.Lafeef_Maqroon_Mahmouz_Faa),
                Arguments.of("28", KindOfVerb.Lafeef_Maqroon),
                Arguments.of("29", KindOfVerb.Lafeef_Mafrooq_Mahmouz_Ain),
                Arguments.of("30", KindOfVerb.Lafeef_Mafrooq)
        );
    }

    @ParameterizedTest
    @MethodSource("getKindOfVerbOrdinalValues")
    void convert(String value, KindOfVerb expected) {
        var sut = new KindOfVerbConverter();

        var actual = sut.convert(KindOfVerb.class, value);

        assertTrue(actual instanceof KindOfVerb);
        assertEquals(expected, actual);
        assertEquals(((KindOfVerb) actual).getValue(), expected.getValue());
    }
}