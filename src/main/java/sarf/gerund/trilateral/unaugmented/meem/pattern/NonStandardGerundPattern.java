package sarf.gerund.trilateral.unaugmented.meem.pattern;

import sarf.KindOfVerb;
import sarf.gerund.trilateral.unaugmented.meem.MeemGerund;
import sarf.noun.GenericNounSuffixContainer;
import sarf.noun.trilateral.unaugmented.instrumental.NonStandardInstrumentalConjugator;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class NonStandardGerundPattern extends MeemGerund {
    private final String gerundText;

    public NonStandardGerundPattern(String gerundText){
        this.gerundText = gerundText;
    }

    public String form() {
        return gerundText;
    }

    @Override
    public String getPattern() {
        return "";
    }

    @Override
    public String toString(){
        return gerundText;
    }
}
