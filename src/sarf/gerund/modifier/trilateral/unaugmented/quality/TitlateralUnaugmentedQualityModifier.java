package sarf.gerund.modifier.trilateral.unaugmented.quality;

import java.util.List;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;
import sarf.noun.trilateral.unaugmented.modifier.*;
import sarf.*;

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
public class TitlateralUnaugmentedQualityModifier implements IUnaugmentedTrilateralNounModifier{
    private Geminator geminator = new Geminator();
    private AjwafVocalizer ajwafVocalizer = new AjwafVocalizer();
    private Mahmouz mahmouz = new Mahmouz();

    private TitlateralUnaugmentedQualityModifier() {
    }

    private static TitlateralUnaugmentedQualityModifier instance = new TitlateralUnaugmentedQualityModifier();

    public static TitlateralUnaugmentedQualityModifier getInstance() {
        return instance;
    }

    public ConjugationResult build(UnaugmentedTrilateralRoot root, int kov, List conjugations, String formula) {
        ConjugationResult conjResult = new ConjugationResult(kov, root, conjugations, formula);
        geminator.apply(conjResult);
        if (ajwafVocalizer.isApplied(conjResult))
            ajwafVocalizer.apply(conjResult.getFinalResult(), root);
        mahmouz.apply(conjResult);
        NounLamAlefModifier.getInstance().apply(conjResult);
        NounSunLamModifier.getInstance().apply(conjResult);
        return conjResult;
    }

}
