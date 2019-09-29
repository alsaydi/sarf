package sarf.gerund.modifier.trilateral.unaugmented.quality;

import com.google.inject.Inject;
import sarf.*;
import sarf.noun.trilateral.unaugmented.modifier.IUnaugmentedTrilateralNounModifier;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;

import java.util.List;

/**
 * <p>Title: Sarf Program</p>
 *
 * </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class TrilateralUnaugmentedQualityModifier implements IUnaugmentedTrilateralNounModifier {
    private final Geminator geminator = new Geminator();
    private final AjwafVocalizer ajwafVocalizer = new AjwafVocalizer();
    private final Mahmouz mahmouz = new Mahmouz();
    private final NounLamAlefModifier nounLamAlefModifier;
    private final NounSunLamModifier nounSunLamModifier;

    @Inject
    public TrilateralUnaugmentedQualityModifier(NounLamAlefModifier nounLamAlefModifier, NounSunLamModifier nounSunLamModifier) {
        this.nounLamAlefModifier = nounLamAlefModifier;
        this.nounSunLamModifier = nounSunLamModifier;
    }

    public ConjugationResult build(UnaugmentedTrilateralRoot root, KindOfVerb kov, List<? extends Word> conjugations, String formula) {
        var conjResult = new ConjugationResult(kov, root, conjugations, formula);
        geminator.apply(conjResult);
        if (ajwafVocalizer.isApplied(conjResult))
            ajwafVocalizer.apply(conjResult.getFinalResult(), root);
        mahmouz.apply(conjResult);
        nounLamAlefModifier.apply(conjResult);
        nounSunLamModifier.apply(conjResult);
        return conjResult;
    }
}
