package sarf.noun.trilateral.unaugmented.modifier.exaggeration;

import sarf.ConjugationResult;
import sarf.noun.TrilateralNounSubstitutionApplier;
import sarf.noun.trilateral.unaugmented.modifier.exaggeration.vocalizer.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
class Vocalizer {
    private final List<TrilateralNounSubstitutionApplier> modifiers = new ArrayList<>();

    public Vocalizer() {
        modifiers.add(new AVocalizer());
        modifiers.add(new B1Vocalizer());
        modifiers.add(new B2Vocalizer());
        modifiers.add(new C1Vocalizer());
        modifiers.add(new C2Vocalizer());
        modifiers.add(new C3Vocalizer());
        modifiers.add(new I1Vocalizer());
        modifiers.add(new I2Vocalizer());
        modifiers.add(new JVocalizer());

    }

    public void apply(ConjugationResult conjResult) {
        for (var modifier : modifiers) {
            if (modifier.isApplied(conjResult)) {
                modifier.apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
    }
}
