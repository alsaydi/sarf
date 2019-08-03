package sarf;

import sarf.verb.quadriliteral.augmented.AugmentedQuadrilateralRoot;
import sarf.verb.quadriliteral.unaugmented.UnaugmentedQuadrilateralRoot;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;

import java.util.List;

public interface SarfDictionary {
    List<UnaugmentedTrilateralRoot> getUnaugmentedTrilateralRoots(String rootText) throws Exception;

    AugmentedTrilateralRoot getAugmentedTrilateralRoot(String rootText) throws Exception;

    AugmentedQuadrilateralRoot getAugmentedQuadrilateralRoot(String rootText);

    UnaugmentedQuadrilateralRoot getUnaugmentedQuadrilateralRoot(String rootText) throws Exception;
}
