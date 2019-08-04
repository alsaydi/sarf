package sarf.gerund.trilateral.augmented.nomen.pattern;

import sarf.gerund.trilateral.augmented.nomen.TrilateralAugmentedNomenGerund;
import sarf.noun.GenericNounSuffixContainer;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;

public class GerundPatternEmpty extends TrilateralAugmentedNomenGerund {
	public GerundPatternEmpty(AugmentedTrilateralRoot root, String suffixNo, GenericNounSuffixContainer genericNounSuffixContainer) {
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
