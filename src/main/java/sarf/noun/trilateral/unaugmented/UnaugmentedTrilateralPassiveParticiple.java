package sarf.noun.trilateral.unaugmented;

import sarf.verb.trilateral.unaugmented.*;
import sarf.util.*;
import sarf.noun.GenericNounSuffixContainer;

public class UnaugmentedTrilateralPassiveParticiple {
    private final UnaugmentedTrilateralRoot root;
    private final String suffix;
    private final GenericNounSuffixContainer genericNounSuffixContainer;

    public UnaugmentedTrilateralPassiveParticiple(UnaugmentedTrilateralRoot root, String suffix, GenericNounSuffixContainer genericNounSuffixContainer) {
        this.root = root;
        this.suffix = suffix;
        this.genericNounSuffixContainer = genericNounSuffixContainer;
    }

    /**
     * form
     *
     * @return String
     * @todo Implement this sarf.noun.Trilateral.TrilateralNoun method
     */
    public String form() {
        return genericNounSuffixContainer.getPrefix()+"م"+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.DAMMA+"و"+root.getC3()+suffix;
    }

    public String toString() {
        return form();
    }

}
