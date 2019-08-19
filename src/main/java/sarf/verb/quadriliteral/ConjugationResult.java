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
public final class ConjugationResult<T> {
    private final int formulaNo;
    private final QuadrilateralRoot root;
    private final KindOfVerb kov;

    private final List<T> originalResult;
    //القائمة بعد  الادغام والاعلال والهمزة
    private final List<T> finalResult;

    public ConjugationResult(int formulaNo, KindOfVerb kov, QuadrilateralRoot root, List<T> originalResult) {
        this.formulaNo = formulaNo;
        this.kov = kov;
        this.originalResult = originalResult;
        this.root = root;
        this.finalResult = new ArrayList<>(originalResult);
    }

    public List<T> getFinalResult() {
        return finalResult;
    }

    public List<T> getOriginalResult() {
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
