package sarf.verb.quadriliteral.augmented;

import org.junit.jupiter.api.Test;
import sarf.AugmentationFormula;
import sarf.verb.RootLetter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AugmentedQuadrilateralRootTest {

    @Test
    void getCharacters() {
        var sut = new AugmentedQuadrilateralRoot();
        sut.setC1('f');
        sut.setC2('d');
        sut.setC3('c');
        sut.setC4('r');

        assertThat(sut.getCharacters().stream().map(RootLetter::getValue)).containsExactly('f','d','c', 'r');
    }

    @Test
    void addAugmentationFormula() {
        var sut = new AugmentedQuadrilateralRoot();
        assertThat(sut.getAugmentationList()).isEmpty();

        sut.addAugmentationFormula(new AugmentationFormula());

        assertThat(sut.getAugmentationList().size()).isEqualTo(1);
    }

    @Test
    void getAugmentationFormula() {
        var sut = new AugmentedQuadrilateralRoot();
        assertThat(sut.getAugmentationList()).isEmpty();
        var formula = new AugmentationFormula();
        formula.setFormulaNo(1);
        sut.addAugmentationFormula(formula);

        assertThat(sut.getAugmentationFormula(1)).isSameAs(formula);
    }
}