package sarf.verb.trilateral.augmented.imperative;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import sarf.SystemConstants;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;
import sarf.verb.trilateral.augmented.imperative.formula.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

class AugmentedImperativeConjugatorTest {

    private static Stream<Arguments> getCreateVerbListArguments() {
        var notEmphasizedConjugator = new AugmentedImperativeConjugatorFactory().getNotEmphasizedConjugator();
        var emphasizedConjugator = new AugmentedImperativeConjugatorFactory().getEmphasizedConjugator();
        return Stream.of(
                Arguments.of(notEmphasizedConjugator, 1, AugmentedImperativeVerb1.class),
                Arguments.of(notEmphasizedConjugator, 2, AugmentedImperativeVerb2.class),
                Arguments.of(notEmphasizedConjugator, 3, AugmentedImperativeVerb3.class),
                Arguments.of(notEmphasizedConjugator, 4, AugmentedImperativeVerb4.class),
                Arguments.of(notEmphasizedConjugator, 5, AugmentedImperativeVerb5.class),
                Arguments.of(notEmphasizedConjugator, 6, AugmentedImperativeVerb6.class),
                Arguments.of(notEmphasizedConjugator, 7, AugmentedImperativeVerb7.class),
                Arguments.of(notEmphasizedConjugator, 8, AugmentedImperativeVerb8.class),
                Arguments.of(notEmphasizedConjugator, 9, AugmentedImperativeVerb9.class),
                Arguments.of(notEmphasizedConjugator, 10, AugmentedImperativeVerb10.class),
                Arguments.of(notEmphasizedConjugator, 11, AugmentedImperativeVerb11.class),
                Arguments.of(notEmphasizedConjugator, 12, AugmentedImperativeVerb12.class),

                Arguments.of(emphasizedConjugator, 1, AugmentedImperativeVerb1.class),
                Arguments.of(emphasizedConjugator, 2, AugmentedImperativeVerb2.class),
                Arguments.of(emphasizedConjugator, 3, AugmentedImperativeVerb3.class),
                Arguments.of(emphasizedConjugator, 4, AugmentedImperativeVerb4.class),
                Arguments.of(emphasizedConjugator, 5, AugmentedImperativeVerb5.class),
                Arguments.of(emphasizedConjugator, 6, AugmentedImperativeVerb6.class),
                Arguments.of(emphasizedConjugator, 7, AugmentedImperativeVerb7.class),
                Arguments.of(emphasizedConjugator, 8, AugmentedImperativeVerb8.class),
                Arguments.of(emphasizedConjugator, 9, AugmentedImperativeVerb9.class),
                Arguments.of(emphasizedConjugator, 10, AugmentedImperativeVerb10.class),
                Arguments.of(emphasizedConjugator, 11, AugmentedImperativeVerb11.class),
                Arguments.of(emphasizedConjugator, 12, AugmentedImperativeVerb12.class)
        );
    }

    @ParameterizedTest(name = "Create verb list {index} {2}")
    @MethodSource("getCreateVerbListArguments")
    void createVerbList(AugmentedImperativeConjugator sut, int formulaNo, Class expected) {
        var verbList = sut.createVerbList(new AugmentedTrilateralRoot(), formulaNo);
        assertThat(SystemConstants.PRONOUN_RANGE_END).isEqualTo(13);
        assertThat(verbList.size()).isEqualTo(SystemConstants.PRONOUN_RANGE_END);
        for (var v : verbList.stream().limit(2).collect(Collectors.toList())) {
            assertThat(v).isNull();
        }

        for(var v: verbList.stream().skip(2).limit(5).collect(Collectors.toList())){
            assertThat(v).isInstanceOf(expected);
        }

        for(var v: verbList.stream().skip(7).collect(Collectors.toList())){
            assertThat(v).isNull();
        }
    }
}