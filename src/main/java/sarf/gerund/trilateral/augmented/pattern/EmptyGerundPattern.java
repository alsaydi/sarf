package sarf.gerund.trilateral.augmented.pattern;

import sarf.gerund.trilateral.augmented.TrilateralAugmentedGerund;
import sarf.noun.GenericNounSuffixContainer;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;

public class EmptyGerundPattern extends TrilateralAugmentedGerund {
    public EmptyGerundPattern(AugmentedTrilateralRoot root, String suffixNo, GenericNounSuffixContainer genericNounSuffixContainer) {
        super(root, suffixNo, genericNounSuffixContainer);
    }

    @Override
    public String form() {
        return "";
    }

    @Override
    public String getPattern() {
        return "";
    }

    @Override
    public String toString(){
        return "";
    }
}
