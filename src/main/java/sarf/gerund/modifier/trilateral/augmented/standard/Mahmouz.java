package sarf.gerund.modifier.trilateral.augmented.standard;

import java.util.*;

import sarf.ConjugationResult;
import sarf.noun.TrilateralNounSubstitutionApplier;

import sarf.gerund.modifier.trilateral.augmented.standard.hamza.*;


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
            if (trilateralNounSubstitutionApplier.isApplied(conjResult)) {
                trilateralNounSubstitutionApplier.apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
    }
}
