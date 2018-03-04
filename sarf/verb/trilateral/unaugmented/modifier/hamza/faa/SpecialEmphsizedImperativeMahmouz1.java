package sarf.verb.trilateral.unaugmented.modifier.hamza.faa;

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
public class SpecialEmphsizedImperativeMahmouz1 extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {

    public SpecialEmphsizedImperativeMahmouz1() {
    }

    public List getSubstitutions() {
        return null;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        UnaugmentedTrilateralRoot root = conjugationResult.getRoot();
        return root.getC1() == 'Á' && root.getC2() == 'Î' && root.getC3() == 'Ğ'&& root.getConjugation().equals("1");
    }

    /**
     * override this method to return the custom list
     * @param words List
     * @param root TrilateralRoot
     */
    public void apply(List words, TrilateralRoot root) {
        words.set(2, "ÎõĞóäøó");
        words.set(3, "ÎõĞöäøó");
        words.set(4, "ÎõĞóÇäøö");
        words.set(5, "ÎõĞõäøó");
        words.set(6, "ÎõĞúäóÇäøö");
    }
}
