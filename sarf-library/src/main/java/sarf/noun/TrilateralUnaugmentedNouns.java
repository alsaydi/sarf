package sarf.noun;

import java.util.*;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.jetbrains.annotations.NotNull;
import sarf.noun.trilateral.unaugmented.assimilate.AssimilateAdjectiveConjugator;
import sarf.noun.trilateral.unaugmented.elative.ElativeNounConjugator;
import sarf.noun.trilateral.unaugmented.exaggeration.NonStandardExaggerationConjugator;
import sarf.noun.trilateral.unaugmented.exaggeration.StandardExaggerationConjugator;
import sarf.noun.trilateral.unaugmented.instrumental.NonStandardInstrumentalConjugator;
import sarf.noun.trilateral.unaugmented.instrumental.StandardInstrumentalConjugator;
import sarf.noun.trilateral.unaugmented.timeandplace.TimeAndPlaceConjugator;
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

@Singleton
public class TrilateralUnaugmentedNouns {
    private final NonStandardExaggerationConjugator nonStandardExaggerationConjugator;
    private final NonStandardInstrumentalConjugator nonStandardInstrumentalConjugator;
    private final ElativeNounConjugator elativeNounConjugator;
    private final AssimilateAdjectiveConjugator assimilateAdjectiveConjugator;
    private final TimeAndPlaceConjugator timeAndPlaceConjugator;
    private final StandardInstrumentalConjugator standardInstrumentalConjugator;
    private final StandardExaggerationConjugator standardExaggerationConjugator;

    @Inject
    public TrilateralUnaugmentedNouns(StandardExaggerationConjugator standardExaggerationConjugator
            , NonStandardExaggerationConjugator nonStandardExaggerationConjugator
            , TimeAndPlaceConjugator timeAndPlaceConjugator
            , StandardInstrumentalConjugator standardInstrumentalConjugator
            , NonStandardInstrumentalConjugator nonStandardInstrumentalConjugator
            , ElativeNounConjugator elativeNounConjugator
            , AssimilateAdjectiveConjugator assimilateAdjectiveConjugator) {
        this.nonStandardExaggerationConjugator = nonStandardExaggerationConjugator;
        this.nonStandardInstrumentalConjugator = nonStandardInstrumentalConjugator;
        this.elativeNounConjugator = elativeNounConjugator;
        this.assimilateAdjectiveConjugator = assimilateAdjectiveConjugator;
        this.timeAndPlaceConjugator = timeAndPlaceConjugator;
        this.standardInstrumentalConjugator = standardInstrumentalConjugator;
        this.standardExaggerationConjugator = standardExaggerationConjugator;
    }

    @NotNull
    public List<String> getAssimilates(UnaugmentedTrilateralRoot root) {
        return assimilateAdjectiveConjugator.getAppliedFormulaList(root);
    }

    public List<String> getElatives(UnaugmentedTrilateralRoot root) {
        return elativeNounConjugator.getAppliedFormulaList(root);
    }

    public List<String> getNonStandardExaggerations(UnaugmentedTrilateralRoot root) {
        return nonStandardExaggerationConjugator.getAppliedFormulaList(root);
    }

    public List<String> getNonStandardInstrumentals(UnaugmentedTrilateralRoot root) {
        return nonStandardInstrumentalConjugator.getAppliedFormulaList(root);
    }

    public List<String> getStandardExaggerations(UnaugmentedTrilateralRoot root) {
        return standardExaggerationConjugator.getAppliedFormulaList(root);
    }

    public List<String> getStandardInstrumentals(UnaugmentedTrilateralRoot root) {
        return standardInstrumentalConjugator.getAppliedFormulaList(root);
    }

    public List<String> getTimeAndPlaces(UnaugmentedTrilateralRoot root) {
        return timeAndPlaceConjugator.getAppliedFormulaList(root);
    }
}