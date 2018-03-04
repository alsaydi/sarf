package sarf.verb.trilateral.augmented.modifier;

import sarf.verb.trilateral.augmented.modifier.geminator.*;
import sarf.verb.trilateral.augmented.ConjugationResult;

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
    private NEndedGeminator nEndedGeminator = new NEndedGeminator();
    //ÇÏÛÇã ÇáãÈÊÏÃ ÈÍÑİ Çáäæä
    private NStartedGeminator nStartedGeminator = new NStartedGeminator();

    //ÇÏÛÇã ÇáãäÊåí ÈÍÑİ ÇáÊÇÁ
    private TEndedGeminator tEndedGeminator = new TEndedGeminator();
    //ÇÏÛÇã ÇáãÈÊÏÃ ÈÍÑİ ÇáÊÇÁ
    private TStartedGeminator tStartedGeminator = new TStartedGeminator();

    public Geminator() {
    }

    /**
     * ÊØÈíŞ ÇáÇÏÛÇã ÍÓÈ ÇáÕíÛÉ ãÇÖí Ãæ ãÖÇÑÚ Ãæ ÃãÑ ááãÚáæã Ãæ áãÌåæá
     * ÊÌÑíÈ ÇáÍÇáÇÊ ÇáÎÇÕÉ ŞÈá ÇáÍÇáÉ ÇáÚÇãÉ
     * ŞÏ áÇ íØÈŞ Ãí äæÚ ãä ÇáÇÏÛÇã
     * @param tense String
     * @param active boolean
     * @param conjResult ConjugationResult
     */
    public void apply(String tense, boolean active, ConjugationResult conjResult) {
        //althoug it will enter the generic block, it may found some rules in the special ones
        if (genericGeminator.isApplied(conjResult))
            genericGeminator.apply(tense, active, conjResult);

        if (tStartedGeminator.isApplied(conjResult))
            tStartedGeminator.apply(tense, active, conjResult);

        if (tEndedGeminator.isApplied(conjResult))
            tEndedGeminator.apply(tense, active, conjResult);

        if (nStartedGeminator.isApplied(conjResult))
            nStartedGeminator.apply(tense, active, conjResult);

        if (nEndedGeminator.isApplied(conjResult))
            nEndedGeminator.apply(tense, active, conjResult);
    }

}
