package sarf.verb.trilateral.unaugmented.modifier.hamza.faa;

import java.util.*;

import sarf.Conjugation;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.ConjugationResult;
import sarf.verb.trilateral.unaugmented.modifier.IUnaugmentedTrilateralModifier;
import sarf.verb.trilateral.TrilateralRoot;
import sarf.verb.trilateral.unaugmented.*;

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
public class SpecialImperativeMahmouz1 extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {

    public SpecialImperativeMahmouz1() {
    }

    public List getSubstitutions() {
        return null;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        var root = conjugationResult.getRoot();
        return root.getC1() == 'ء' && root.getC2() == 'خ' && root.getC3() == 'ذ' && root.getConjugation() == Conjugation.First;
    }

    /**
     * override this method to return the custom list
     * @param words List
     * @param root TrilateralRoot
     */
    public void apply(List words, TrilateralRoot root) {
        words.set(2, "خُذْ");
        words.set(3, "خُذِي");
        words.set(4, "خُذَا");
        words.set(5, "خُذُوا");
        words.set(6, "خُذْنَ");
    }
}
