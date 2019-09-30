package sarf.noun.trilateral.unaugmented.exaggeration;

import com.google.inject.Inject;
import sarf.SystemConstants;
import sarf.noun.*;
import sarf.verb.trilateral.unaugmented.*;
import java.util.*;
import sarf.noun.trilateral.unaugmented.exaggeration.standard.*;

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
public class StandardExaggerationConjugator implements IUnaugmentedTrilateralNounConjugator {
    private static final List<String> formulas = new ArrayList<>(1);

    static {
        formulas.add("فَعَّال");
    }

    private final GenericNounSuffixContainer genericNounSuffixContainer;

    @Inject
    public StandardExaggerationConjugator(GenericNounSuffixContainer genericNounSuffixContainer) {
        this.genericNounSuffixContainer = genericNounSuffixContainer;
    }

    public List<NounFormula> createNounList(UnaugmentedTrilateralRoot root, String formulaName) {
        List<NounFormula> result = new ArrayList<>();
        for (int i = 0; i < SystemConstants.NOUN_POSSIBLE_STATES; i++) {
            NounFormula noun = new NounFormula1(root, i + "", genericNounSuffixContainer);
            result.add(noun);
        }
        return result;
    }

    public List<String> getAppliedFormulaList(UnaugmentedTrilateralRoot root) {
        return formulas;
    }
}
