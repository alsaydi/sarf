package sarf.noun.trilateral.augmented.modifier.activeparticiple;

import java.util.*;

import sarf.noun.TrilateralNounSubstitutionApplier;
import sarf.noun.trilateral.augmented.modifier.activeparticiple.geminator.Geminator1;
import sarf.noun.trilateral.augmented.modifier.geminator.Geminator2;
import sarf.noun.trilateral.augmented.modifier.geminator.Geminator3;
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
public class Geminator {
    private final List<TrilateralNounSubstitutionApplier> modifiers = new LinkedList<>();

    public Geminator() {
        modifiers.add(new Geminator1());
        modifiers.add(new Geminator2());
        modifiers.add(new Geminator3());
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
