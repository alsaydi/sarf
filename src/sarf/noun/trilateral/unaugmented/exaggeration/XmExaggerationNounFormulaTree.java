package sarf.noun.trilateral.unaugmented.exaggeration;

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
public class XmExaggerationNounFormulaTree {

    private List formulas = new LinkedList();

    public XmExaggerationNounFormulaTree() {
    }

    public void addFormula(XmExaggerationNounFormula formula) {
        formulas.add(formula);
    }

    public List getFormulaList() {
        return formulas;
    }

}
