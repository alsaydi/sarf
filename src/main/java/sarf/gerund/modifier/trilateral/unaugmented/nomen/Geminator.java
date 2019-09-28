package sarf.gerund.modifier.trilateral.unaugmented.nomen;

import sarf.gerund.modifier.trilateral.unaugmented.nomen.geminator.Geminator1;
import sarf.gerund.modifier.trilateral.unaugmented.nomen.geminator.Geminator2;
import sarf.ConjugationResult;
import sarf.noun.trilateral.unaugmented.modifier.IUnaugmentedTrilateralNounModificationApplier;
import sarf.verb.trilateral.Substitution.SubstitutionsApplier;

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
public class Geminator {
    private final List<SubstitutionsApplier> modifiers = new ArrayList<>();

    public Geminator() {
        modifiers.add(new Geminator1());
        modifiers.add(new Geminator2());
    }

    public void apply(ConjugationResult conjResult) {
        for (var applier : modifiers) {
            IUnaugmentedTrilateralNounModificationApplier modifier = (IUnaugmentedTrilateralNounModificationApplier) applier;
            if (modifier.isApplied(conjResult)) {
                applier.apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
    }
}

