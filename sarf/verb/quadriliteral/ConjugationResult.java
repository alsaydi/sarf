package sarf.verb.quadriliteral;

import java.util.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: Ì„À· ‰ ÌÃ… «· ’—Ì› „⁄ «·Ã–— Ê‰Ê⁄ «·Ã–—      </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class ConjugationResult {
    private int formulaNo;
    private QuadrilateralRoot root;
    private int kov;

    private List originalResult;
    //«·ﬁ«∆„… »⁄œ  «·«œ€«„ Ê«·«⁄·«· Ê«·Â„“…
    private List finalResult;

    public ConjugationResult(int formulaNo, int kov, QuadrilateralRoot root, List originalResult) {
        this.formulaNo = formulaNo;
        this.kov = kov;
        this.originalResult = originalResult;
        this.root = root;
        this.finalResult = new ArrayList(originalResult);
    }

    public List getFinalResult() {
        return finalResult;
    }

    public List getOriginalResult() {
        return originalResult;
    }

    public QuadrilateralRoot getRoot() {
        return root;
    }

    public int getFormulaNo() {
        return formulaNo;
    }

    public int getKov() {
        return kov;
    }
}
