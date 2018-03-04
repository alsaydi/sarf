package sarf.verb.trilateral.unaugmented.modifier.hamza.ein;

import java.util.*;
import sarf.verb.trilateral.unaugmented.modifier.hamza.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.unaugmented.modifier.IUnaugmentedTrilateralModifier;
import sarf.verb.trilateral.unaugmented.ConjugationResult;
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
public class SpecialEmphsizedImperativeMahmouz extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {

    public SpecialEmphsizedImperativeMahmouz() {
    }

    public List getSubstitutions() {
        return null;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        UnaugmentedTrilateralRoot root = conjugationResult.getRoot();
        return root.getC1() == 'Ó' && root.getC2() == 'Á' && root.getC3() == 'á';
    }

    /**
     * override this method to return the custom list
     * @param words List
     * @param root TrilateralRoot
     */
    public void apply(List words, TrilateralRoot root) {
        words.set(2, "Óóáóäøó/ÇÓúÃáóäøó");
        words.set(3, "Óóáöäøó/ÇÓúÃáöäøó");
        words.set(4, "ÓóáÇóäøö/ÇÓúÃáÇóäøö");
        words.set(5, "Óóáõäøó/ÇÓúÃáõäøó");
        words.set(6, "ÓóáúäóÇäøö/ÇÓúÃáúäóÇäøö");
    }
}
