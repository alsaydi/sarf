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
public class SpecialEmphsizedImperativeMahmouz2 extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {

    public SpecialEmphsizedImperativeMahmouz2() {
    }

    public List getSubstitutions() {
        return null;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        UnaugmentedTrilateralRoot root = conjugationResult.getRoot();
        return root.getC1() == 'Á' && root.getC2() == 'ß' && root.getC3() == 'á'&& root.getConjugation().equals("1");
    }

    /**
     * override this method to return the custom list
     * @param words List
     * @param root TrilateralRoot
     */
    public void apply(List words, TrilateralRoot root) {
        words.set(2, "ßõáóäøó");
        words.set(3, "ßõáöäøó");
        words.set(4, "ßõáÇóäøö");
        words.set(5, "ßõáõäøó");
        words.set(6, "ßõáúäóÇäøö");
    }
}
