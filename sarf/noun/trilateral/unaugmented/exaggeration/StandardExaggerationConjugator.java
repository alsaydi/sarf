package sarf.noun.trilateral.unaugmented.exaggeration;

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
public class StandardExaggerationConjugator implements IUnaugmentedTrilateralNounConjugator{
    private StandardExaggerationConjugator() {
    }

    private static StandardExaggerationConjugator instance = new StandardExaggerationConjugator();

    public static StandardExaggerationConjugator getInstance() {
        return instance;
    }

    public List createNounList(UnaugmentedTrilateralRoot root, String formulaName) {
        List result = new LinkedList();
        for (int i = 0; i < 18; i++) {
            NounFormula noun = new NounFormula1(root, i+"");
            result.add(noun);
        }

        return result;
    }

    static List formulas = new ArrayList(1);
    static {
        formulas.add("ÝóÚøóÇá");
    }

    public List getAppliedFormulaList(UnaugmentedTrilateralRoot root) {
        return formulas;
    }


}
