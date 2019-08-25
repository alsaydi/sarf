package sarf.verb.trilateral.augmented;

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
public class TriAugmentedConjugationResult<T> {
    private final KindOfVerb kov;
    private final int formulaNo;
    private final AugmentedTrilateralRoot root;

    //13 conjugated verbs
    private final List<T> originalResult;
    //القائمة بعد  الادغام والاعلال والهمزة
    private final List<T> finalResult;

    //TODO: I believe originalResult is of List<String> type.
    
    public TriAugmentedConjugationResult(KindOfVerb kov, int formulaNo, AugmentedTrilateralRoot root, List<T> originalResult) {
        this.kov = kov;
        this.formulaNo = formulaNo;
        this.originalResult = originalResult;
        this.root = root;
        this.finalResult = new ArrayList<>(originalResult);
    }

    public List<T> getFinalResult() {
        return finalResult;
    }

    public KindOfVerb getKov() {
        return kov;
    }

    public List<T> getOriginalResult() {
        return originalResult;
    }

    public AugmentedTrilateralRoot getRoot() {
        return root;
    }

    public int getFormulaNo() {
        return formulaNo;
    }
}
