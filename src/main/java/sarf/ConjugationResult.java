package sarf;

import sarf.KindOfVerb;
import sarf.verb.Root;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;

import java.util.*;
import java.util.stream.Collectors;

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
    private final int formulaNo;
    private final Root root;
    private final KindOfVerb kov;
    private final String nounFormula;

    //13 conjugated verbs
    private final List<? extends Word> originalResult;
    //القائمة بعد  الادغام والاعلال والهمزة
    private final List<WordPresenter> finalResult;

    //TODO: I believe originalResult is of List<String> type.
    
    public ConjugationResult(KindOfVerb kov, int formulaNo, Root root, List<? extends Word> originalResult) {
        this(kov, formulaNo, root, originalResult, "");
    }

    public ConjugationResult(KindOfVerb kov, Root root, List<? extends Word> originalResult, String nounFormula) {
        this(kov, 0, root, originalResult, nounFormula);
    }

    private ConjugationResult(KindOfVerb kov, int formulaNo, Root root, List<? extends Word> originalResult, String nounFormula){
        this.kov = kov;
        this.formulaNo = formulaNo;
        this.originalResult = originalResult;
        this.root = root;
        this.finalResult = originalResult.stream()
                .map(w -> w == null ? WordPresenter.Empty : w.producePresenter())
                .collect(Collectors.toList());
        this.nounFormula = nounFormula;
    }

    public void replace(int index, WordPresenter wordPresenter){
        this.finalResult.set(index, wordPresenter);
    }

    public List<WordPresenter> getFinalResult() {
        return finalResult;
    }

    public KindOfVerb getKov() {
        return kov;
    }

    public List<? extends Word> getOriginalResult() {
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
