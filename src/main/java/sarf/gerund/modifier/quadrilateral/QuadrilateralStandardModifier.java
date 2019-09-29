package sarf.gerund.modifier.quadrilateral;

import java.util.*;

import com.google.inject.Inject;
import sarf.verb.quadriliteral.*;
import sarf.*;

public class QuadrilateralStandardModifier {
    private final NounLamAlefModifier nounLamAlefModifier;
    private final NounSunLamModifier nounSunLamModifier;
    private final Vocalizer vocalizer;
    private final InternalMahmouz internalMahmouz;
    private final EndedMahmouz endedMahmouz;

    @Inject
    public QuadrilateralStandardModifier(NounLamAlefModifier nounLamAlefModifier, NounSunLamModifier nounSunLamModifier, Vocalizer vocalizer, InternalMahmouz internalMahmouz, EndedMahmouz endedMahmouz) {
        this.nounLamAlefModifier = nounLamAlefModifier;
        this.nounSunLamModifier = nounSunLamModifier;
        this.vocalizer = vocalizer;
        this.internalMahmouz = internalMahmouz;
        this.endedMahmouz = endedMahmouz;
    }

    public ConjugationResult build(QuadrilateralRoot root, int formulaNo, KindOfVerb kov, List<? extends Word> conjugations) {
        ConjugationResult conjResult = new ConjugationResult(kov, formulaNo, root, conjugations);
        if (vocalizer.isApplied(conjResult))
            vocalizer.apply(conjResult.getFinalResult(), conjResult.getRoot());
        if (internalMahmouz.isApplied(conjResult))
            internalMahmouz.apply(conjResult.getFinalResult(), conjResult.getRoot());
        if (endedMahmouz.isApplied(conjResult))
            endedMahmouz.apply(conjResult.getFinalResult(), conjResult.getRoot());
        nounLamAlefModifier.apply(conjResult);
        nounSunLamModifier.apply(conjResult);
        return conjResult;
    }
}
