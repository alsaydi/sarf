package sarf.noun.quadriliteral.unaugmented;

import sarf.verb.quadriliteral.unaugmented.*;
import sarf.util.*;
import sarf.noun.GenericNounSuffixContainer;

public class UnaugmentedQuadriliteralPassiveParticiple {
    private UnaugmentedQuadriliteralRoot root;
    private String suffix;

    public UnaugmentedQuadriliteralPassiveParticiple(UnaugmentedQuadriliteralRoot root, String suffix) {
        this.root = root;
        this.suffix = suffix;
    }

    /**
     * form
     *
     * @return String
     * @todo Implement this sarf.noun.Quadriliteral.QuadriliteralNoun method
     */
    public String form() {
        return GenericNounSuffixContainer.getInstance().getPrefix()+"ã"+ArabCharUtil.DAMMA+root.getC1()+ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.SKOON+root.getC3()+ArabCharUtil.FATHA+root.getC4()+suffix;
    }

    public String toString() {
        return form();
    }

}
