package sarf.noun.trilateral.augmented.modifier.activeparticiple;

import sarf.noun.TrilateralNounSubstitutionApplier;
import sarf.noun.trilateral.augmented.modifier.activeparticiple.hamza.EinMahmouz;
import sarf.noun.trilateral.augmented.modifier.activeparticiple.hamza.FaaMahmouz;
import sarf.noun.trilateral.augmented.modifier.activeparticiple.hamza.LamMahmouz;
import sarf.noun.trilateral.augmented.modifier.activeparticiple.hamza.RaaEinMahmouz;
import sarf.verb.trilateral.augmented.ConjugationResult;
import sarf.verb.trilateral.augmented.modifier.IAugmentedTrilateralModifier;

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
public class Mahmouz {
    private final List<TrilateralNounSubstitutionApplier> modifiers = new ArrayList<>();

    public Mahmouz() {
        modifiers.add(new RaaEinMahmouz());
        modifiers.add(new EinMahmouz());
        modifiers.add(new FaaMahmouz());
        modifiers.add(new LamMahmouz());
    }

    public void apply(ConjugationResult conjResult) {
        for (TrilateralNounSubstitutionApplier substitutionApplier : modifiers) {
            IAugmentedTrilateralModifier modifier = (IAugmentedTrilateralModifier) substitutionApplier;
            if (modifier.isApplied(conjResult)) {
                substitutionApplier.apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
    }
}
