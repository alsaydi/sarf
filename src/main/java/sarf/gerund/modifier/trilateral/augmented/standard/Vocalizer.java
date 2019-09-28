package sarf.gerund.modifier.trilateral.augmented.standard;

import java.util.*;

import sarf.ConjugationResult;
import sarf.substitution.SubstitutionsApplier;
import sarf.verb.trilateral.Substitution.*;
import sarf.gerund.modifier.trilateral.augmented.standard.vocalizer.*;
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
public class Vocalizer {
    private final List<IAugmentedTrilateralModifier> modifiers;
    private final PreSeparatedLafifVocalizer preSeparatedLafifVocalizer;

    public Vocalizer() {
        modifiers = new LinkedList<>();
        preSeparatedLafifVocalizer = new PreSeparatedLafifVocalizer();

        modifiers.add(new MithalAjwaf1Vocalizer());
        modifiers.add(new MithalAjwaf2Vocalizer());
        modifiers.add(new MithalAjwaf3Vocalizer());
        modifiers.add(new MithalAjwaf4Vocalizer());
        modifiers.add(new MithalAjwaf5Vocalizer());
        modifiers.add(new WawiNakesLafifVocalizer());
        modifiers.add(new YaeiNakesLafifVocalizer());
    }

    public void apply(ConjugationResult conjResult) {
        if (preSeparatedLafifVocalizer.isApplied(conjResult))
            preSeparatedLafifVocalizer.apply(conjResult.getFinalResult(), conjResult.getRoot());

        for (IAugmentedTrilateralModifier modifier : modifiers) {
            if (modifier.isApplied(conjResult)) {
                ((SubstitutionsApplier) modifier).apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
    }
}
