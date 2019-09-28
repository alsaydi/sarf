package sarf.gerund.modifier.trilateral.augmented.standard;

import java.util.*;

import sarf.ConjugationResult;
import sarf.gerund.modifier.trilateral.augmented.standard.geminator.*;
import sarf.noun.TrilateralNounSubstitutionApplier;
import sarf.substitution.SubstitutionsApplier;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.*;

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
public class Geminator {
    private final List<TrilateralNounSubstitutionApplier> modifiers = new LinkedList<>();

    public Geminator() {
        modifiers.add(new Geminator0());
        modifiers.add(new Geminator1());
        modifiers.add(new Geminator2());
        modifiers.add(new Geminator3());
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
