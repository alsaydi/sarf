package sarf.gerund.modifier.trilateral.unaugmented.meem;

import sarf.ConjugationResult;
import sarf.gerund.modifier.trilateral.unaugmented.meem.vocalizer.Ajwaf1Vocalizer;
import sarf.gerund.modifier.trilateral.unaugmented.meem.vocalizer.Ajwaf2Vocalizer;
import sarf.gerund.modifier.trilateral.unaugmented.meem.vocalizer.AjwafListed1Vocalizer;
import sarf.gerund.modifier.trilateral.unaugmented.meem.vocalizer.NakesLafifVocalizer;
import sarf.substitution.SubstitutionsApplier;

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
    private final List<SubstitutionsApplier> modifiers = new ArrayList<>();

    public Vocalizer() {
        modifiers.add(new Ajwaf1Vocalizer());
        modifiers.add(new AjwafListed1Vocalizer());
        modifiers.add(new Ajwaf2Vocalizer());
        modifiers.add(new NakesLafifVocalizer());
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
