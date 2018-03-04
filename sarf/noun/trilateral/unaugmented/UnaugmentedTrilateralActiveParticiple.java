package sarf.noun.trilateral.unaugmented;

import sarf.verb.trilateral.unaugmented.*;
import sarf.util.*;
import sarf.noun.trilateral.*;
import sarf.noun.*;

public class UnaugmentedTrilateralActiveParticiple  {
    private UnaugmentedTrilateralRoot root;
    private String suffix;

    public UnaugmentedTrilateralActiveParticiple(UnaugmentedTrilateralRoot root, String suffix) {
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
        return GenericNounSuffixContainer.getInstance().getPrefix()+root.getC1()+ArabCharUtil.FATHA+"Ç"+root.getC2()+ArabCharUtil.KASRA+root.getC3()+suffix;
    }

    public String toString() {
        return form();
    }
}
