package sarf.verb.quadriliteral;

import sarf.KindOfVerb;

import java.util.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: يمثل نتيجة التصريف مع الجذر ونوع الجذر      </p>
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
    private KindOfVerb kov;

    private List<String> originalResult;
    //القائمة بعد  الادغام والاعلال والهمزة
    private List<String> finalResult;

    public ConjugationResult(int formulaNo, KindOfVerb kov, QuadrilateralRoot root, List<String> originalResult) {
        this.formulaNo = formulaNo;
        this.kov = kov;
        this.originalResult = originalResult;
        this.root = root;
        this.finalResult = new ArrayList<>(originalResult);
    }

    public List<String> getFinalResult() {
        return finalResult;
    }

    public List<String> getOriginalResult() {
        return originalResult;
    }

    public QuadrilateralRoot getRoot() {
        return root;
    }

    public int getFormulaNo() {
        return formulaNo;
    }

    public KindOfVerb getKov() {
        return kov;
    }
}
