package sarf.gerund.modifier.trilateral.augmented.standard;

import java.util.*;

import sarf.noun.TrilateralNounSubstitutionApplier;
import sarf.verb.trilateral.Substitution.*;
import sarf.gerund.modifier.trilateral.augmented.standard.hamza.*;
import sarf.verb.trilateral.augmented.*;
import sarf.verb.trilateral.augmented.modifier.IAugmentedTrilateralModifier;

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
public class Mahmouz {
    private final List<TrilateralNounSubstitutionApplier> modifiers = new LinkedList<>();

    public Mahmouz() {
        modifiers.add(new RaaEinMahmouz());
        modifiers.add(new EinMahmouz());
        modifiers.add(new FaaMahmouz());
        modifiers.add(new LamMahmouz());
    }

    public void apply(ConjugationResult conjResult) {
        for (TrilateralNounSubstitutionApplier trilateralNounSubstitutionApplier : modifiers) {
            IAugmentedTrilateralModifier modifier = (IAugmentedTrilateralModifier) trilateralNounSubstitutionApplier;
            if (modifier.isApplied(conjResult)) {
                ((SubstitutionsApplier) modifier).apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
    }
}
