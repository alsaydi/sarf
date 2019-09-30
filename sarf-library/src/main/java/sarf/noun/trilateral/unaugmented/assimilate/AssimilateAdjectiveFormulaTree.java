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

    private final List<AssimilateAdjectiveFormula> formulas = new ArrayList<>();

    public AssimilateAdjectiveFormulaTree() {
    }

    public void addFormula(AssimilateAdjectiveFormula formula) {
        formulas.add(formula);
    }

    public List<AssimilateAdjectiveFormula> getFormulaList() {
        return formulas;
    }
}
