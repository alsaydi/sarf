package sarf.verb.trilateral.unaugmented;

import java.util.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: íãËá äÊíÌÉ ÇáÊÕÑíİ ãÚ ÇáÌĞÑ æäæÚ ÇáÌĞÑ
 * íÓÊÚãá İí ÇáãÚÇáÌÉ ÈÚÏ ÇáÊæáíÏ
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
    protected List originalResult;
    //ÇáŞÇÆãÉ ÈÚÏ  ÇáÇÏÛÇã æÇáÇÚáÇá æÇáåãÒÉ
    protected List finalResult;

    public ConjugationResult(int kov, UnaugmentedTrilateralRoot root, List originalResult) {
        this.kov = kov;
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

    public UnaugmentedTrilateralRoot getRoot() {
        return root;
    }
}
