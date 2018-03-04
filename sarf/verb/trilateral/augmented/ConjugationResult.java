package sarf.verb.trilateral.augmented;

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
    private int kov;
    private int formulaNo;
    private AugmentedTrilateralRoot root;

    //13 conjugated verbs
    private List originalResult;
    //«·ﬁ«∆„… »⁄œ  «·«œ€«„ Ê«·«⁄·«· Ê«·Â„“…
    private List finalResult;

    public ConjugationResult(int kov, int formulaNo, AugmentedTrilateralRoot root, List originalResult) {
        this.kov = kov;
        this.formulaNo = formulaNo;
        this.originalResult = originalResult;
        this.root = root;
        this.finalResult = new ArrayList(originalResult);
    }

    public List getFinalResult() {
        return finalResult;
    }

    public int getKov() {
        return kov;
    }

    public List getOriginalResult() {
        return originalResult;
    }

    public AugmentedTrilateralRoot getRoot() {
        return root;
    }

    public int getFormulaNo() {
        return formulaNo;
    }
}
