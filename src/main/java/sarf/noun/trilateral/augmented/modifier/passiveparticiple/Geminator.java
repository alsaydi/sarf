package sarf.noun.trilateral.augmented.modifier.passiveparticiple;

import java.util.*;

import sarf.ConjugationResult;
import sarf.substitution.SubstitutionsApplier;

import sarf.noun.trilateral.augmented.modifier.passiveparticiple.geminator.*;
import sarf.noun.trilateral.augmented.modifier.geminator.*;


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
    private final List<SubstitutionsApplier> modifiers = new ArrayList<>();

    public Geminator() {
        modifiers.add(new Geminator1());
        modifiers.add(new Geminator2());
        modifiers.add(new Geminator3());
    }

    public void apply(ConjugationResult conjResult) {
        for (var modifier : modifiers) {
            if (modifier.isApplied(conjResult)) {
                ((SubstitutionsApplier) modifier).apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
    }
}
