package sarf.verb.trilateral.unaugmented;

import java.util.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: يمثل نتيجة التصريف مع الجذر ونوع الجذر
 * يستعمل في المعالجة بعد التوليد
 * </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class ConjugationResult {
    protected int kov;
    protected UnaugmentedTrilateralRoot root;

    //13 conjugated verbs
    protected List<String> originalResult;
    //القائمة بعد  الادغام والاعلال والهمزة
    protected List<String> finalResult;

    public ConjugationResult(int kov, UnaugmentedTrilateralRoot root, List<String> originalResult) {
        this.kov = kov;
        this.originalResult = originalResult;
        this.root = root;
        this.finalResult = new ArrayList<>(originalResult);
    }

    public List<String> getFinalResult() {
        return finalResult;
    }

    public int getKov() {
        return kov;
    }

    public List<String> getOriginalResult() {
        return originalResult;
    }

    public UnaugmentedTrilateralRoot getRoot() {
        return root;
    }
}
