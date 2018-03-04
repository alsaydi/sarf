package sarf.noun.trilateral.unaugmented;

import sarf.verb.trilateral.unaugmented.*;
import sarf.util.*;
import sarf.noun.GenericNounSuffixContainer;

public class UnaugmentedTrilateralPassiveParticiple {
    private UnaugmentedTrilateralRoot root;
    private String suffix;

    public UnaugmentedTrilateralPassiveParticiple(UnaugmentedTrilateralRoot root, String suffix) {
        this.root = root;
        this.suffix = suffix;
    }

    /**
     * form
     *
     * @return String
     * @todo Implement this sarf.noun.Trilateral.TrilateralNoun method
     */
    public String form() {
        return GenericNounSuffixContainer.getInstance().getPrefix()+"ã"+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.DAMMA+"æ"+root.getC3()+suffix;
    }

    public String toString() {
        return form();
    }

}
