package sarf.noun.trilateral.augmented.modifier.activeparticiple;

import sarf.ConjugationResult;
import sarf.noun.TrilateralNounSubstitutionApplier;
import sarf.noun.trilateral.augmented.modifier.activeparticiple.vocalizer.*;

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
public class Vocalizer {
    private final List<TrilateralNounSubstitutionApplier> modifiers = new ArrayList<>();
    private final PreSeparatedLafifVocalizer preSeparatedLafifVocalizer = new PreSeparatedLafifVocalizer();

    public Vocalizer() {
        modifiers.add(new Mithal1Vocalizer());
        modifiers.add(new Mithal2Vocalizer());
        modifiers.add(new Ajwaf1Vocalizer());
        modifiers.add(new Ajwaf2Vocalizer());
        modifiers.add(new WawiNakesLafifVocalizer());
        modifiers.add(new YaeiNakesLafifVocalizer());
    }

    public void apply(ConjugationResult conjResult) {
        if (preSeparatedLafifVocalizer.isApplied(conjResult))
            preSeparatedLafifVocalizer.apply(conjResult.getFinalResult(), conjResult.getRoot());

        for (var modifier : modifiers) {
            if (modifier.isApplied(conjResult)) {
                modifier.apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
    }
}
