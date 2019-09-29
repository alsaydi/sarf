package sarf.noun.trilateral.unaugmented.modifier.timeandplace;

import java.util.*;
import sarf.noun.trilateral.unaugmented.modifier.timeandplace.vocalizer.*;
import sarf.substitution.SubstitutionsApplier;

import sarf.noun.trilateral.unaugmented.modifier.*;
import sarf.ConjugationResult;

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
    private final List<SubstitutionsApplier> modifiers = new ArrayList<>();

    public Vocalizer() {
        modifiers.add(new ACAjwaf1Vocalizer());
        modifiers.add(new ACAjwaf2Vocalizer());
        modifiers.add(new BAjwafVocalizer());
        modifiers.add(new ALafifNakesVocalizer());
        modifiers.add(new CLafifNakesVocalizer());
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
