package sarf;

/**
 * <p>Title: Sarf</p>
 *
 * <p>Description: ?????? ???????</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class AugmentationFormula {
    private int formulaNo;
    private char transitive;

    public AugmentationFormula() {
    }

    public char getTransitive() {
        return transitive;
    }

    public int getFormulaNo() {
        return formulaNo;
    }

    public void setFormulaNo(int formulaNo) {
        this.formulaNo = formulaNo;
    }

    public void setTransitive(char transitive) {
        this.transitive = transitive;
    }
}
