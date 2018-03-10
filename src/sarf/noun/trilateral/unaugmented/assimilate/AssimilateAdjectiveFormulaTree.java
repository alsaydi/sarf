package sarf.noun.trilateral.unaugmented.assimilate;

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
public class AssimilateAdjectiveFormulaTree {

    private List formulas = new LinkedList();

    public AssimilateAdjectiveFormulaTree() {
    }

    public void addFormula(AssimilateAdjectiveFormula formula) {
        formulas.add(formula);
    }

    public List getFormulaList() {
        return formulas;
    }

}
