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
public class ConjugationResult {
    private final KindOfVerb kov;
    private final int formulaNo;
    private final AugmentedTrilateralRoot root;

    //13 conjugated verbs
    private final List<String> originalResult;
    //القائمة بعد  الادغام والاعلال والهمزة
    private final List<String> finalResult;

    //TODO: I believe originalResult is of List<String> type.
    
    public ConjugationResult(KindOfVerb kov, int formulaNo, AugmentedTrilateralRoot root, List<String> originalResult) {
        this.kov = kov;
        this.formulaNo = formulaNo;
        this.originalResult = originalResult;
        this.root = root;
        this.finalResult = new ArrayList<>(originalResult);
    }

    public List<String> getFinalResult() {
        return finalResult;
    }

    public KindOfVerb getKov() {
        return kov;
    }

    public List<String> getOriginalResult() {
        return originalResult;
    }

    public AugmentedTrilateralRoot getRoot() {
        return root;
    }

    public int getFormulaNo() {
        return formulaNo;
    }
}
