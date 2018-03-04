package sarf.noun.trilateral.unaugmented.modifier.elative;

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
public class ElativeModifier implements IUnaugmentedTrilateralNounModifier{
    private Geminator geminator = new Geminator();
    private Vocalizer vocalizer = new Vocalizer();
    private Mahmouz mahmouz = new Mahmouz();

    private AlkhairModifier alkhairModifier = new AlkhairModifier();
    private AlSharModifier alSharModifier = new AlSharModifier();

    private ElativeModifier() {
    }

    private static ElativeModifier instance = new ElativeModifier();

    public static ElativeModifier getInstance() {
        return instance;
    }

    public ConjugationResult build(UnaugmentedTrilateralRoot root, int kov, List conjugations, String formula) {
        ConjugationResult conjResult = new ConjugationResult(kov, root, conjugations, formula);
        if (alkhairModifier.isApplied(conjResult)) {
            alkhairModifier.apply(conjResult);
        }
        else if (alSharModifier.isApplied(conjResult)) {
            alSharModifier.apply(conjResult);
        }
        else {
            if (geminator.isApplied(conjResult))
                geminator.apply(conjResult.getFinalResult(), root);
            vocalizer.apply(conjResult);
            mahmouz.apply(conjResult);
            NounLamAlefModifier.getInstance().apply(conjResult);
            NounSunLamModifier.getInstance().apply(conjResult);
        }
        return conjResult;
    }

}
