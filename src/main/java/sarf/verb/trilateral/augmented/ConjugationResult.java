package sarf.verb.trilateral.augmented;

import sarf.KindOfVerb;
import sarf.verb.Root;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;

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
public class ConjugationResult<T> {
    private final int formulaNo;
    private final Root root;
    private final KindOfVerb kov;
    private final String nounFormula;

    //13 conjugated verbs
    private final List<T> originalResult;
    //القائمة بعد  الادغام والاعلال والهمزة
    private final List<T> finalResult;

    //TODO: I believe originalResult is of List<String> type.
    
    public ConjugationResult(KindOfVerb kov, int formulaNo, Root root, List<T> originalResult) {
        this(kov, formulaNo, root, originalResult, "");
    }

    public ConjugationResult(KindOfVerb kov, Root root, List<T> originalResult, String nounFormula) {
        this(kov, 0, root, originalResult, nounFormula);
    }

    private ConjugationResult(KindOfVerb kov, int formulaNo, Root root, List<T> originalResult, String nounFormula){
        this.kov = kov;
        this.formulaNo = formulaNo;
        this.originalResult = originalResult;
        this.root = root;
        this.finalResult = new ArrayList<>(originalResult);
        this.nounFormula = nounFormula;
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

    public Root getRoot() {
        return root;
    }

    public int getFormulaNo() {
        return formulaNo;
    }

    public String getNounFormula() {
        return nounFormula;
    }
}
