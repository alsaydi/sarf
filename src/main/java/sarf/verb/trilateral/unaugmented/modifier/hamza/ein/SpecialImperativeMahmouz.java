package sarf.verb.trilateral.unaugmented.modifier.hamza.ein;

import java.util.*;

import sarf.substitution.SubstitutionsApplier;
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
public class SpecialImperativeMahmouz extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {

    public SpecialImperativeMahmouz() {
    }

    public List getSubstitutions() {
        return null;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        var root = conjugationResult.getRoot();
        return root.getC1() == 'س' && root.getC2() == 'ء' && root.getC3() == 'ل';
    }

    /**
     * override this method to return the custom list
     * @param words List
     * @param root TrilateralRoot
     */
    public void apply(List words, TrilateralRoot root) {
        words.set(2, "سَلْ/اسْأَلْ");
        words.set(3, "سَلِي/اسْأَلِي");
        words.set(4, "سَلاَ/اسْأَلاَ");
        words.set(5, "سَلُوا/اسْأَلُوا");
        words.set(6, "سَلْنَ/اسْأَلْنَ");
    }
}
