package sarf.noun.quadriliteral.unaugmented;

import sarf.Word;
import sarf.verb.quadriliteral.unaugmented.*;
import sarf.util.*;
import sarf.noun.GenericNounSuffixContainer;

public class UnaugmentedQuadrilateralActiveParticiple extends Word {
    private final UnaugmentedQuadrilateralRoot root;
    private final String suffix;
    private final GenericNounSuffixContainer genericNounSuffixContainer;

    UnaugmentedQuadrilateralActiveParticiple(UnaugmentedQuadrilateralRoot root, String suffix, GenericNounSuffixContainer genericNounSuffixContainer) {
        this.root = root;
        this.suffix = suffix;
        this.genericNounSuffixContainer = genericNounSuffixContainer;
    }

    /**
     * form
     *
     * @return String
     * @todo Implement this sarf.noun.Quadriliteral.QuadriliteralNoun method
     */
    private String form() {
        return genericNounSuffixContainer.getPrefix()+"م"+ArabCharUtil.DAMMA+root.getC1()+ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.SKOON+root.getC3()+ArabCharUtil.KASRA+root.getC4()+suffix;
    }

    @Override
    public String toString() {
        return form();
    }
}
