package sarf.noun.trilateral.unaugmented.modifier.exaggeration;

import java.util.List;
import sarf.NounLamAlefModifier;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;
import sarf.noun.trilateral.unaugmented.modifier.*;
import sarf.NounSunLamModifier;

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
public class ExaggerationModifier implements IUnaugmentedTrilateralNounModifier{
    private Vocalizer vocalizer = new Vocalizer();
    private Mahmouz mahmouz = new Mahmouz();

    private ExaggerationModifier() {
    }

    private static ExaggerationModifier instance = new ExaggerationModifier();

    public static ExaggerationModifier getInstance() {
        return instance;
    }

    public ConjugationResult build(UnaugmentedTrilateralRoot root, int kov, List conjugations, String formula) {
        ConjugationResult conjResult = new ConjugationResult(kov, root, conjugations, formula);
        vocalizer.apply(conjResult);
        mahmouz.apply(conjResult);
        NounLamAlefModifier.getInstance().apply(conjResult);
        NounSunLamModifier.getInstance().apply(conjResult);
        return conjResult;
    }

}
