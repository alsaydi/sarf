package sarf.noun.trilateral.unaugmented.modifier.exaggeration;

import java.util.*;

import sarf.noun.TrilateralNounSubstitutionApplier;
import sarf.noun.trilateral.unaugmented.modifier.exaggeration.vocalizer.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.noun.trilateral.unaugmented.modifier.*;

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
public class Vocalizer {
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
        for (Object o : modifiers) {
            IUnaugmentedTrilateralNounModificationApplier modifier = (IUnaugmentedTrilateralNounModificationApplier) o;
            if (modifier.isApplied(conjResult)) {
                ((SubstitutionsApplier) modifier).apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
    }
}
