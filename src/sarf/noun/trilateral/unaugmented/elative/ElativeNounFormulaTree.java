package sarf.noun.trilateral.unaugmented.elative;

import java.util.*;

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
public class ElativeNounFormulaTree {

    private List formulas = new LinkedList();

    public ElativeNounFormulaTree() {
    }

    public void addFormula(ElativeNounFormula formula) {
        formulas.add(formula);
    }

    public List getFormulaList() {
        return formulas;
    }

}
