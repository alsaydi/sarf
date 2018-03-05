package sarf.noun;

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
public class XmlNounFormulaTree {

    private List formulas = new LinkedList();

    public XmlNounFormulaTree() {
    }

    public void addFormula(XmlNounFormula formula) {
        formulas.add(formula);
    }

    public List getFormulaList() {
        return formulas;
    }

}
