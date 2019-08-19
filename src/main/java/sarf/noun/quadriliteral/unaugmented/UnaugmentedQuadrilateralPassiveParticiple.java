package sarf.noun.quadriliteral.unaugmented;

import sarf.noun.GenericNounSuffixContainer;
import sarf.util.ArabCharUtil;
import sarf.verb.quadriliteral.unaugmented.UnaugmentedQuadrilateralRoot;

public class UnaugmentedQuadrilateralPassiveParticiple {
    private final UnaugmentedQuadrilateralRoot root;
    private final String suffix;
    private final GenericNounSuffixContainer genericNounSuffixContainer;

    UnaugmentedQuadrilateralPassiveParticiple() {
        root = new UnaugmentedQuadrilateralRoot();
        suffix = "";
        genericNounSuffixContainer = null;
    }

    UnaugmentedQuadrilateralPassiveParticiple(UnaugmentedQuadrilateralRoot root, String suffix, GenericNounSuffixContainer genericNounSuffixContainer) {
        this.root = root;
        this.suffix = suffix;
        this.genericNounSuffixContainer = genericNounSuffixContainer;
    }

    /**
     * form
     *
     * @return String
     * @todo Implement this sarf.noun.Quadrilateral.QuadrilateralNoun method
     */
    public String form() {
        if (genericNounSuffixContainer == null || suffix == null || suffix.equals(""))
            return "";

        return genericNounSuffixContainer.getPrefix() + "م" + ArabCharUtil.DAMMA + root.getC1() + ArabCharUtil.FATHA + root.getC2() + ArabCharUtil.SKOON + root.getC3() + ArabCharUtil.FATHA + root.getC4() + suffix;
    }

    public String toString() {
        return form();
    }
}
