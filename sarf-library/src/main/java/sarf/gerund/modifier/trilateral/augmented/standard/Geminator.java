package sarf.gerund.modifier.trilateral.augmented.standard;

import sarf.ConjugationResult;
import sarf.gerund.modifier.trilateral.augmented.standard.geminator.Geminator0;
import sarf.gerund.modifier.trilateral.augmented.standard.geminator.Geminator1;
import sarf.gerund.modifier.trilateral.augmented.standard.geminator.Geminator2;
import sarf.gerund.modifier.trilateral.augmented.standard.geminator.Geminator3;
import sarf.noun.TrilateralNounSubstitutionApplier;

import java.util.LinkedList;
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
public class Geminator {
    private final List<TrilateralNounSubstitutionApplier> modifiers = new LinkedList<>();

    public Geminator() {
        modifiers.add(new Geminator0());
        modifiers.add(new Geminator1());
        modifiers.add(new Geminator2());
        modifiers.add(new Geminator3());
    }

    public void apply(ConjugationResult conjResult) {
        for (TrilateralNounSubstitutionApplier modifier : modifiers) {
            if (modifier.isApplied(conjResult)) {
                modifier.apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
    }
}
