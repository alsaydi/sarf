package sarf.gerund.trilateral.unaugmented.meem;

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
public class XmlMeemGerundNounFormulaTree {

    private List formulas = new LinkedList();

    public XmlMeemGerundNounFormulaTree() {
    }

    public void addFormula(XmlMeemGerundNounFormula formula) {
        formulas.add(formula);
    }

    public List getFormulaList() {
        return formulas;
    }

}
