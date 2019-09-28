package sarf.verb.trilateral.unaugmented.modifier.hamza.faa;

import java.util.*;

import sarf.Conjugation;
import sarf.verb.trilateral.Substitution.*;
import sarf.ConjugationResult;
import sarf.verb.trilateral.unaugmented.modifier.IUnaugmentedTrilateralModifier;
import sarf.verb.trilateral.TrilateralRoot;

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
public class SpecialEmphsizedImperativeMahmouz2 extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {

    public SpecialEmphsizedImperativeMahmouz2() {
    }

    public List<Substitution> getSubstitutions() {
        return null;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        var root = conjugationResult.getRoot();
        return root.getC1() == 'ء' && root.getC2() == 'ك' && root.getC3() == 'ل'&& root.getConjugation() == Conjugation.First;
    }

    /**
     * override this method to return the custom list
     * @param words List
     * @param root TrilateralRoot
     */
    public void apply(List words, TrilateralRoot root) {
        words.set(2, "كُلَنَّ");
        words.set(3, "كُلِنَّ");
        words.set(4, "كُلاَنِّ");
        words.set(5, "كُلُنَّ");
        words.set(6, "كُلْنَانِّ");
    }
}
