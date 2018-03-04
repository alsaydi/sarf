package sarf.verb.trilateral.unaugmented.modifier;

import sarf.verb.trilateral.unaugmented.modifier.geminator.*;
import sarf.verb.trilateral.unaugmented.ConjugationResult;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: This is the facade for gemination subsystem
 * åæ ÇáÕİ ÇáãÓÄæá Úä ÚãáíÉ ÇáÇÏÛÇã Èßá ÍÇáÇÊåÇ
 *ÍíË íÊÎÇØÈ ãÚ ÇáÕİæİ ÇáãæÌæÏÉ İí ÍÒãÉ ÇáÇÏÛÇã
 * </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class Geminator {
    //ÇÏÛÇã ÇáÚÇã
    private GenericGeminator genericGeminator = new GenericGeminator();
    //ÇÏÛÇã ÇáãäÊåí ÈÍÑİ Çáäæä
    private NGeminator nGeminator = new NGeminator();
    //ÇÏÛÇã ÇáãäÊåí ÈÍÑİ ÇáÊÇÁ
    private TGeminator tGeminator = new TGeminator();

    public Geminator() {
    }

    /**
     * ÊØÈíŞ ÇáÇÏÛÇã ÍÓÈ ÇáÕíÛÉ ãÇÖí Ãæ ãÖÇÑÚ Ãæ ÃãÑ ááãÚáæã Ãæ áãÌåæá
     * ŞÏ áÇ íØÈŞ Ãí äæÚ ãä ÇáÇÏÛÇã
     * @param tense String
     * @param active boolean
     * @param conjResult ConjugationResult
     */
    public void apply(String tense, boolean active, ConjugationResult conjResult) {
        if (genericGeminator.isApplied(conjResult))
            genericGeminator.apply(tense, active, conjResult);
        //else
        if (tGeminator.isApplied(conjResult))
            tGeminator.apply(tense, active, conjResult);
        //else
        if (nGeminator.isApplied(conjResult))
            nGeminator.apply(tense, active, conjResult);
    }

}
