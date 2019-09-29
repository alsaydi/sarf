package sarf.noun.trilateral.unaugmented;

import sarf.Word;
import sarf.verb.trilateral.unaugmented.*;
import sarf.util.*;
import sarf.noun.GenericNounSuffixContainer;

public class UnaugmentedTrilateralPassiveParticiple extends Word {
    private final UnaugmentedTrilateralRoot root;
    private final String suffix;
    private final GenericNounSuffixContainer genericNounSuffixContainer;

    UnaugmentedTrilateralPassiveParticiple(UnaugmentedTrilateralRoot root, String suffix, GenericNounSuffixContainer genericNounSuffixContainer) {
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
    private String form() {
        return genericNounSuffixContainer.getPrefix()+"م"+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.DAMMA+"و"+root.getC3()+suffix;
    }

    @Override
    public String toString() {
        return form();
    }

}
