package sarf.noun.trilateral.unaugmented.modifier.activeparticiple;

import java.util.List;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;
import sarf.noun.trilateral.unaugmented.modifier.*;
import sarf.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description:  ÿ»Ìﬁ «·„⁄«·Ã… «·Œ«’… ⁄·Ï «”„ «·›«⁄·
 * «» œ«¡ »«·«œ€«„ À„ «·«⁄·«· Ê«ŒÌ—« «·Â„“…
 * </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class ActiveParticipleModifier implements IUnaugmentedTrilateralNounModifier{
    private Geminator geminator = new Geminator();
    private Vocalizer vocalizer = new Vocalizer();
    private Mahmouz mahmouz = new Mahmouz();

    private ActiveParticipleModifier() {
    }

    private static ActiveParticipleModifier instance = new ActiveParticipleModifier();

    public static ActiveParticipleModifier getInstance() {
        return instance;
    }

    public ConjugationResult build(UnaugmentedTrilateralRoot root, int kov, List conjugations, String formula) {
        ConjugationResult conjResult = new ConjugationResult(kov, root, conjugations, formula);
        if (geminator.isApplied(conjResult))
            geminator.apply(conjResult.getFinalResult(), root);
        vocalizer.apply(conjResult);
        mahmouz.apply(conjResult);
        NounLamAlefModifier.getInstance().apply(conjResult);
        NounSunLamModifier.getInstance().apply(conjResult);
        return conjResult;
    }

}
