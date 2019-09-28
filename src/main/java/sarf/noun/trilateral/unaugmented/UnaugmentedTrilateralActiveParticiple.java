package sarf.noun.trilateral.unaugmented;

import sarf.Word;
import sarf.verb.trilateral.unaugmented.*;
import sarf.util.*;
import sarf.noun.*;

public class UnaugmentedTrilateralActiveParticiple extends Word {
    private final UnaugmentedTrilateralRoot root;
    private final String suffix;
    private final GenericNounSuffixContainer genericNounSuffixContainer;

    UnaugmentedTrilateralActiveParticiple(UnaugmentedTrilateralRoot root, String suffix, GenericNounSuffixContainer genericNounSuffixContainer) {
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
        return genericNounSuffixContainer.getPrefix()+root.getC1()+ArabCharUtil.FATHA+"ا"+root.getC2()+ArabCharUtil.KASRA+root.getC3()+suffix;
    }

    public String toString() {
        return form();
    }
}
