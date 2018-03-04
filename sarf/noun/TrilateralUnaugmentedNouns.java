package sarf.noun;

import java.util.*;

import sarf.verb.trilateral.unaugmented.*;

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
public class TrilateralUnaugmentedNouns {

   //„»«·€… √”„«¡ «·›«⁄·
    private List standardExaggerations;
    private List nonStandardExaggerations;
    //√”„«¡ «·“„«‰ Ê«·„ﬂ«‰
    private List timeAndPlaces;

    //√”„«¡ «·¬·…
    private List standardInstrumentals;
    private List nonStandardInstrumentals;

    //√”„«¡ «· ›÷Ì·
    private List elatives;
    //«·’›«  «·„‘»Â…
    private List assimilates;

    private UnaugmentedTrilateralRoot root;

    public TrilateralUnaugmentedNouns(UnaugmentedTrilateralRoot root) {
        standardExaggerations = sarf.noun.trilateral.unaugmented.exaggeration.StandardExaggerationConjugator.getInstance().getAppliedFormulaList(root);
        nonStandardExaggerations = sarf.noun.trilateral.unaugmented.exaggeration.NonStandardExaggerationConjugator.getInstance().getAppliedFormulaList(root);

        timeAndPlaces = sarf.noun.trilateral.unaugmented.timeandplace.TimeAndPlaceConjugator.getInstance().getAppliedFormulaList(root);

        standardInstrumentals = sarf.noun.trilateral.unaugmented.instrumental.StandardInstrumentalConjugator.getInstance().getAppliedFormulaList(root);
        nonStandardInstrumentals = sarf.noun.trilateral.unaugmented.instrumental.NonStandardInstrumentalConjugator.getInstance().getAppliedFormulaList(root);

        elatives = sarf.noun.trilateral.unaugmented.elative.ElativeNounConjugator.getInstance().getAppliedFormulaList(root);
        assimilates = sarf.noun.trilateral.unaugmented.assimilate.AssimilateAdjectiveConjugator.getInstance().getAppliedFormulaList(root);
    }

    public List getAssimilates() {
        return assimilates;
    }

    public List getElatives() {
        return elatives;
    }

    public List getNonStandardExaggerations() {
        return nonStandardExaggerations;
    }

    public List getNonStandardInstrumentals() {
        return nonStandardInstrumentals;
    }

    public UnaugmentedTrilateralRoot getRoot() {
        return root;
    }

    public List getStandardExaggerations() {
        return standardExaggerations;
    }

    public List getStandardInstrumentals() {
        return standardInstrumentals;
    }

    public List getTimeAndPlaces() {
        return timeAndPlaces;
    }
}

