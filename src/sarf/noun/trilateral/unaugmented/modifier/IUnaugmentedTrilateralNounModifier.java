package sarf.noun.trilateral.unaugmented.modifier;

import java.util.List;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;

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
public interface IUnaugmentedTrilateralNounModifier {
    public ConjugationResult build(UnaugmentedTrilateralRoot root, int kov, List conjugations, String formula);
}
