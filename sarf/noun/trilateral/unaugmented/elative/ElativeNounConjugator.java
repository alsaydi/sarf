package sarf.noun.trilateral.unaugmented.elative;

import sarf.noun.*;
import sarf.verb.trilateral.unaugmented.*;
import java.util.*;
import sarf.*;
import sarf.noun.trilateral.unaugmented.elative.nonstandard.*;

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
public class ElativeNounConjugator implements IUnaugmentedTrilateralNounConjugator{

    private static ElativeNounConjugator instance = new ElativeNounConjugator();

    public static ElativeNounConjugator getInstance() {
        return instance;
    }

    private ElativeNounConjugator() {
    }

    public List createNounList(UnaugmentedTrilateralRoot root, String formulaName) {
        List result = new LinkedList();
        for (int i = 0; i < 18; i++) {
            NounFormula noun = new GenericElativeNounFormula(root, i+"");
            result.add(noun);
        }
        return result;

    }

    static List formulas = new ArrayList(1);
    static {
        formulas.add("ÃóÝúÚóá");
    }
    public List getAppliedFormulaList(UnaugmentedTrilateralRoot root) {
        ElativeNounFormulaTree formulaTree =  DatabaseManager.getInstance().getElativeNounFormulaTree(root.getC1());
        if (formulaTree == null)
            return null;


        Iterator iter = formulaTree.getFormulaList().iterator();
        while (iter.hasNext()) {
            ElativeNounFormula formula = (ElativeNounFormula) iter.next();
            if (formula.getC2() == root.getC2() && formula.getC3() == root.getC3()) {
                return formulas;
            }
        }

        return new LinkedList();
    }
}
